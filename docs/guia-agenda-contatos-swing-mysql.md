# Guia completo: Agenda de Contatos em Java Swing + MySQL (NetBeans)

Este roteiro foi pensado para aula, do **zero até a instalação em rede** de uma aplicação desktop Java Swing que salva contatos com **nome** e **telefone** em banco **MySQL**.

---

## 1) Objetivo do projeto

Criar uma aplicação desktop com:

- Campo **Nome**
- Campo **Telefone**
- Botão **Salvar**
- Lista/Tabela de contatos gravados
- Persistência em banco MySQL

Arquitetura sugerida para os alunos:

- `model` → classe `Contato`
- `dao` → classe `ContatoDAO` (acesso ao banco)
- `view` → formulário Swing (`JFrame`)
- `util` → classe de conexão (`ConexaoMySQL`)

---

## 2) Pré-requisitos

Instalar na máquina do professor e dos alunos:

1. **JDK 17** (ou 11+)
2. **NetBeans IDE** (com suporte a Java)
3. **MySQL Server 8.x**
4. **MySQL Workbench** (opcional, mas facilita)

> Dica para aula: padronize a turma com a mesma versão de JDK e NetBeans para evitar erros de compatibilidade.

---

## 3) Criar o banco de dados

No MySQL (Workbench ou terminal), execute:

```sql
CREATE DATABASE agenda_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE agenda_db;

CREATE TABLE contatos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);
```

Crie um usuário específico da aplicação (recomendado):

```sql
CREATE USER 'agenda_user'@'%' IDENTIFIED BY 'SenhaForte123!';
GRANT ALL PRIVILEGES ON agenda_db.* TO 'agenda_user'@'%';
FLUSH PRIVILEGES;
```

---

## 4) Criar o projeto no NetBeans

1. Abra o NetBeans
2. **File > New Project**
3. Categoria: **Java with Ant** (ou Maven) > **Java Application**
4. Nome: `AgendaContatos`
5. Desmarque *Create Main Class* (opcional)
6. Finalize

Crie os pacotes:

- `br.com.agenda.model`
- `br.com.agenda.dao`
- `br.com.agenda.util`
- `br.com.agenda.view`

---

## 5) Adicionar driver JDBC do MySQL

### Opção A (Maven – recomendado)
No `pom.xml`, adicione:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>
```

### Opção B (Projeto Ant)
1. Baixe o conector em: <https://dev.mysql.com/downloads/connector/j/>
2. No projeto NetBeans: **Libraries > Add JAR/Folder**
3. Selecione o `.jar` do connector

---

## 6) Classe de conexão (`ConexaoMySQL`)

Crie `br.com.agenda.util.ConexaoMySQL`:

```java
package br.com.agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/agenda_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "agenda_user";
    private static final String PASS = "SenhaForte123!";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
```

> Em rede, troque `localhost` pelo IP/nome do servidor MySQL.

---

## 7) Classe de modelo (`Contato`)

Crie `br.com.agenda.model.Contato`:

```java
package br.com.agenda.model;

public class Contato {
    private int id;
    private String nome;
    private String telefone;

    public Contato() {}

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
```

---

## 8) Classe DAO (`ContatoDAO`)

Crie `br.com.agenda.dao.ContatoDAO`:

```java
package br.com.agenda.dao;

import br.com.agenda.model.Contato;
import br.com.agenda.util.ConexaoMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    public void salvar(Contato contato) {
        String sql = "INSERT INTO contatos (nome, telefone) VALUES (?, ?)";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar contato", e);
        }
    }

    public List<Contato> listarTodos() {
        String sql = "SELECT id, nome, telefone FROM contatos ORDER BY nome";
        List<Contato> contatos = new ArrayList<>();

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Contato c = new Contato();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                contatos.add(c);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar contatos", e);
        }

        return contatos;
    }
}
```

---

## 9) Criar interface gráfica (JFrame Form no NetBeans)

No pacote `view`, crie `AgendaView` (JFrame Form) com componentes:

- `JLabel` Nome
- `JTextField` (`txtNome`)
- `JLabel` Telefone
- `JTextField` (`txtTelefone`)
- `JButton` (`btnSalvar`)
- `JTable` (`tblContatos`) com colunas: ID, Nome, Telefone

Exemplo de código principal do formulário:

```java
package br.com.agenda.view;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AgendaView extends JFrame {

    private JTextField txtNome;
    private JTextField txtTelefone;
    private JButton btnSalvar;
    private JTable tblContatos;

    private final ContatoDAO contatoDAO = new ContatoDAO();

    public AgendaView() {
        initComponents();
        carregarTabela();
    }

    private void initComponents() {
        setTitle("Agenda de Contatos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtNome = new JTextField(20);
        txtTelefone = new JTextField(15);
        btnSalvar = new JButton("Salvar");
        tblContatos = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nome", "Telefone"}
        ));

        btnSalvar.addActionListener(e -> salvarContato());

        JPanel painel = new JPanel();
        painel.add(new JLabel("Nome:"));
        painel.add(txtNome);
        painel.add(new JLabel("Telefone:"));
        painel.add(txtTelefone);
        painel.add(btnSalvar);

        add(painel, "North");
        add(new JScrollPane(tblContatos), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    private void salvarContato() {
        String nome = txtNome.getText().trim();
        String telefone = txtTelefone.getText().trim();

        if (nome.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha nome e telefone.");
            return;
        }

        contatoDAO.salvar(new Contato(nome, telefone));
        txtNome.setText("");
        txtTelefone.setText("");
        carregarTabela();

        JOptionPane.showMessageDialog(this, "Contato salvo com sucesso!");
    }

    private void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblContatos.getModel();
        modelo.setRowCount(0);

        List<Contato> contatos = contatoDAO.listarTodos();
        for (Contato c : contatos) {
            modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getTelefone()});
        }
    }
}
```

---

## 10) Classe principal para iniciar a aplicação

Crie `br.com.agenda.Main`:

```java
package br.com.agenda;

import br.com.agenda.view.AgendaView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgendaView().setVisible(true));
    }
}
```

---

## 11) Testes em sala (roteiro de validação)

1. Abrir a aplicação
2. Cadastrar 3 contatos
3. Fechar e abrir novamente
4. Confirmar que os dados persistiram
5. Tentar salvar com campos vazios (deve bloquear)

Consultas SQL úteis para demonstrar resultado:

```sql
SELECT * FROM contatos;
```

---

## 12) Build executável (JAR)

### No NetBeans
1. Clique com botão direito no projeto
2. **Clean and Build**
3. O JAR será gerado em `dist/AgendaContatos.jar`

### Executar via terminal

```bash
java -jar AgendaContatos.jar
```

> Se usar Ant, confirme que as bibliotecas estão em `dist/lib` junto do JAR.

---

## 13) Publicação e instalação em rede (laboratório/escola)

### Cenário recomendado
- 1 servidor com MySQL
- Várias máquinas cliente rodando o app Swing

### Passos

1. **Servidor MySQL**
   - Defina IP fixo (ex.: `192.168.1.50`)
   - Libere porta `3306` no firewall
   - Configure `bind-address` para aceitar rede local (se necessário)

2. **Banco e usuário**
   - Já criar usuário com host `%` ou por sub-rede
   - Exemplo mais restrito:
     ```sql
     CREATE USER 'agenda_user'@'192.168.1.%' IDENTIFIED BY 'SenhaForte123!';
     GRANT ALL PRIVILEGES ON agenda_db.* TO 'agenda_user'@'192.168.1.%';
     FLUSH PRIVILEGES;
     ```

3. **Aplicação cliente**
   - Em `ConexaoMySQL`, trocar URL para:
     ```java
     jdbc:mysql://192.168.1.50:3306/agenda_db?useSSL=false&serverTimezone=UTC
     ```

4. **Distribuição**
   - Copiar para cada máquina:
     - `AgendaContatos.jar`
     - pasta `lib/` (quando houver dependências externas)

5. **Requisito mínimo em cada cliente**
   - Java JRE/JDK instalado

6. **Atalho de execução**
   - Windows: arquivo `.bat`
     ```bat
     @echo off
     java -jar AgendaContatos.jar
     ```

7. **Teste final de rede**
   - Abrir em duas máquinas
   - Salvar contatos em ambas
   - Conferir no banco central se registros entraram

---

## 14) Boas práticas para evolução da aula

- Validação de telefone com máscara ou regex
- Botões de editar/excluir contato
- Pesquisa por nome
- Separar credenciais em arquivo `.properties`
- Criar backup diário do banco (`mysqldump`)
- Mostrar diferença entre `Statement` e `PreparedStatement` (segurança contra SQL Injection)

---

## 15) Problemas comuns (e como resolver)

1. **`No suitable driver found`**
   - JDBC do MySQL não foi adicionado corretamente

2. **`Access denied for user`**
   - Usuário/senha incorretos ou sem permissão

3. **`Communications link failure`**
   - IP/porta do servidor incorretos
   - Firewall bloqueando 3306
   - MySQL não está aceitando conexões remotas

4. **Acentuação quebrada**
   - Banco/tabela sem `utf8mb4`

---

## 16) Sugestão de sequência didática (2 a 3 aulas)

- **Aula 1:** Banco, model, conexão, inserir contato
- **Aula 2:** Tela Swing + tabela + listar contatos
- **Aula 3:** Build, distribuição em rede e testes entre máquinas

Com esse plano, os alunos saem de interface gráfica isolada para um sistema real com persistência e implantação básica em ambiente de rede.
