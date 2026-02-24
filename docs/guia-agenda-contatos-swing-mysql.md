# Guia completo (funcional): Agenda de Contatos em Java Swing + MySQL no NetBeans (USANDO ROOT)

Este material foi ajustado para evitar os problemas mais comuns:

- “não está inserindo dados”
- “não está exibindo os dados já salvos”
- MySQL 8: Public Key Retrieval
- Permissão: Access denied

## 1) Pré-requisitos

- JDK 17 (ou 11+)
- NetBeans
- MySQL Server 8+
- (Opcional) MySQL Workbench

## 2) Banco de dados

Execute no MySQL (Workbench ou terminal):

```sql
CREATE DATABASE IF NOT EXISTS agenda_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE agenda_db;

CREATE TABLE IF NOT EXISTS contatos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);
```

Teste rápido:

```sql
INSERT INTO contatos (nome, telefone) VALUES ('Teste SQL', '(11) 90000-0000');
SELECT * FROM contatos;
```

## 3) Criar o projeto no NetBeans

1. File > New Project > Java Application
2. Nome: `AgendaContatos`
3. Criar pacotes:
   - `br.com.agenda.model`
   - `br.com.agenda.util`
   - `br.com.agenda.dao`
   - `br.com.agenda.view`

## 4) Driver JDBC (obrigatório)

### Maven (recomendado)

No `pom.xml`:

```xml
<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <version>8.4.0</version>
</dependency>
```

### Ant

Adicione o JAR em `Libraries > Add JAR/Folder`.

## 5) Classe de conexão (MySQL 8 + ROOT)

`br.com.agenda.util.ConexaoMySQL`

```java
package br.com.agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    // Em rede, troque localhost pelo IP do servidor MySQL
    private static final String URL =
        "jdbc:mysql://localhost:3306/agenda_db"
      + "?useSSL=false"
      + "&allowPublicKeyRetrieval=true"
      + "&serverTimezone=America/Sao_Paulo"
      + "&characterEncoding=UTF-8";

    private static final String USER = "root";
    private static final String PASS = "986050";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
```

✅ Esse `allowPublicKeyRetrieval=true` evita o erro: `Public Key Retrieval is not allowed`

## 6) Model

`br.com.agenda.model.Contato`

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

## 7) DAO (com erros claros)

`br.com.agenda.dao.ContatoDAO`

```java
package br.com.agenda.dao;

import br.com.agenda.model.Contato;
import br.com.agenda.util.ConexaoMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    public void salvar(Contato contato) throws SQLException {
        String sql = "INSERT INTO contatos (nome, telefone) VALUES (?, ?)";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.executeUpdate();
        }
    }

    public List<Contato> listarTodos() throws SQLException {
        String sql = "SELECT id, nome, telefone FROM contatos ORDER BY id DESC";
        List<Contato> lista = new ArrayList<>();

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Contato c = new Contato();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                lista.add(c);
            }
        }

        return lista;
    }
}
```

## 8) Tela Swing (JFrame Form) — versão que atualiza tabela corretamente

Crie um `JFrame Form` chamado `AgendaView` com:

- `txtNome` (JTextField)
- `txtTelefone` (JTextField)
- `btnSalvar` (JButton)
- `btnAtualizar` (JButton) (opcional, mas útil)
- `tblContatos` (JTable)

Lógica do `AgendaView` (cole na classe)

Importante: não deixe a JTable com linhas `{null,null,null}` no modelo.

```java
package br.com.agenda.view;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AgendaView extends javax.swing.JFrame {

    private final ContatoDAO contatoDAO = new ContatoDAO();

    public AgendaView() {
        initComponents();
        configurarTabela();
        carregarTabela();
    }

    private void configurarTabela() {
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Nome", "Telefone"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblContatos.setModel(modelo);
    }

    private void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblContatos.getModel();
        modelo.setRowCount(0);

        try {
            List<Contato> contatos = contatoDAO.listarTodos();
            for (Contato c : contatos) {
                modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getTelefone()});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Erro ao listar contatos: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarContato() {
        String nome = txtNome.getText().trim();
        String telefone = txtTelefone.getText().trim();

        if (nome.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha nome e telefone.");
            return;
        }

        try {
            contatoDAO.salvar(new Contato(nome, telefone));
            txtNome.setText("");
            txtTelefone.setText("");
            carregarTabela();
            JOptionPane.showMessageDialog(this, "Contato salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Erro ao salvar contato: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Vincule no ActionPerformed do botão Salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        salvarContato();
    }

    // Vincule no ActionPerformed do botão Atualizar (se você criou)
    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        carregarTabela();
    }
}
```

## 9) Main

`br.com.agenda.Main`

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

## 10) Checklist (quando “não salva” ou “não lista”)

Verifique nesta ordem:

1. O driver JDBC está mesmo no projeto? (Maven baixou / Ant com JAR em Libraries)
2. `ConexaoMySQL` aponta para o banco certo? (`agenda_db` na URL)
3. URL contém `allowPublicKeyRetrieval=true` (MySQL 8)
4. O botão Salvar está ligado ao evento `btnSalvarActionPerformed`?
5. `configurarTabela()` e `carregarTabela()` são chamados no construtor após `initComponents()`?
6. No Workbench, `SELECT * FROM contatos;` retorna registros?

## 11) Build executável (JAR)

No NetBeans:

1. Botão direito no projeto
2. Clean and Build
3. JAR em `dist/AgendaContatos.jar`

Executar:

```bash
java -jar AgendaContatos.jar
```

## 12) Rede (laboratório) — usando root (funciona, mas atenção)

No cliente, mude apenas a URL:

```java
"jdbc:mysql://192.168.1.50:3306/agenda_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Sao_Paulo&characterEncoding=UTF-8"
```

E mantenha:

```java
USER = "root";
PASS = "986050";
```