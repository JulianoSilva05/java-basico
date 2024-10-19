# 1. Estrutura de Controle em Java

Estruturas de controle em Java são mecanismos que permitem controlar o fluxo de execução de um programa. Elas são fundamentais para criar lógica e tomar decisões em um código. As principais estruturas de controle em Java são:

## 1. Estruturas de Repetição

### for

Utilizado quando se sabe previamente o número de iterações.

```java
for (inicialização; condição; incremento) {
    // código a ser repetido
}
```

### Exemplos de for:
 
```java
// Exemplo 1: Contagem regressiva
for (int i = 10; i >= 0; i--) {
    System.out.println("Contagem: " + i);
}

// Exemplo 2: Soma dos números pares de 1 a 100
int soma = 0;
for (int i = 2; i <= 100; i += 2) {
    soma += i;
}
System.out.println("A soma dos números pares de 1 a 100 é: " + soma);

// Exemplo 3: Percorrendo um array
String[] frutas = {"Maçã", "Banana", "Laranja", "Uva", "Pera"};
for (int i = 0; i < frutas.length; i++) {
    System.out.println("Fruta " + (i+1) + ": " + frutas[i]);
}
```
### while
Executa um bloco de código enquanto uma condição for verdadeira.

```java
while (condição) {
    // código a ser repetido
}
```

### Exemplos de While
```java
// Exemplo 1: Contagem regressiva
int contador = 10;
while (contador > 0) {
    System.out.println("Contagem: " + contador);
    contador--;
}

// Exemplo 2: Soma de números até um limite
int soma = 0;
int numero = 1;
while (soma < 100) {
    soma += numero;
    numero++;
}
System.out.println("A soma final é: " + soma);
```
### do-while
O ```do-while``` é uma estrutura de repetição útil em situações onde você deseja garantir que um bloco de código seja executado pelo menos uma vez, independentemente da condição.
```java
do {
    // código a ser repetido
} while (condição);
```
### Exemplos de do-while:
```java
// Exemplo 1: Leitura de entrada do usuário
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
int numero;
do {
    System.out.print("Digite um número positivo: ");
    numero = scanner.nextInt();
} while (numero <= 0);
System.out.println("Você digitou: " + numero);

// Exemplo 2: Jogo de adivinhação
import java.util.Random;

Random random = new Random();
int numeroSecreto = random.nextInt(100) + 1;
int tentativa;
do {
    System.out.print("Adivinhe o número (1-100): ");
    tentativa = scanner.nextInt();
    if (tentativa > numeroSecreto) {
        System.out.println("Muito alto!");
    } else if (tentativa < numeroSecreto) {
        System.out.println("Muito baixo!");
    }
} while (tentativa != numeroSecreto);
System.out.println("Parabéns! Você acertou!");

// Exemplo 3: Menu simples
int opcao;
do {
    System.out.println("\nMenu:");
    System.out.println("1. Opção 1");
    System.out.println("2. Opção 2");
    System.out.println("3. Sair");
    System.out.print("Escolha uma opção: ");
    opcao = scanner.nextInt();
    
    switch (opcao) {
        case 1:
            System.out.println("Você escolheu a Opção 1");
            break;
        case 2:
            System.out.println("Você escolheu a Opção 2");
            break;
        case 3:
            System.out.println("Saindo...");
            break;
        default:
            System.out.println("Opção inválida!");
    }
} while (opcao != 3);
```
# 2. Estrutura de Controle de Fluxo
### break
O break é utilizado para sair de um loop ou switch.

```java
// Exemplo 1: Sair de um loop for
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break; // Sai do loop quando i é 5
    }
    System.out.println(i);
}

// Exemplo 2: Sair de um loop while
int j = 0;
while (true) {
    if (j == 5) {
        break; // Sai do loop infinito quando j é 5
    }
    System.out.println(j);
    j++;
}

// Exemplo 3: Uso do break em um switch
int opcao = 2;
switch (opcao) {
    case 1:
        System.out.println("Opção 1");
        break;
    case 2:
        System.out.println("Opção 2");
        break;
    default:
        System.out.println("Opção inválida");
}
```
### continue
Pula para a próxima iteração de um loop.
```java
// Exemplo 1: Pular números pares
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue; // Pula a iteração se o número for par
    }
    System.out.println(i);
}

// Exemplo 2: Pular uma string específica em um array
String[] frutas = {"maçã", "banana", "laranja", "uva", "pêra"};
for (String fruta : frutas) {
    if (fruta.equals("laranja")) {
        continue; // Pula "laranja"
    }
    System.out.println(fruta);
}

// Exemplo 3: Uso do continue em um loop while
int j = 0;
while (j < 5) {
    j++;
    if (j == 3) {
        continue; // Pula quando j for 3
    }
    System.out.println("Número: " + j);
}
```

# 3. Atividade
1. Filtro de Números: Crie um programa que use 'for' para imprimir apenas os números ímpares de 1 a 20.
2. Contador Incremento : Crie um programa que solicite que o usuário digite diversos números, só pare de solicitar quando a soma destes números chegar à 100. A cada incremento, o programa deve avisa o valor da soma dos números.
3. Contador Regressivo: Crie um programa para o seguinte fluxograma:
   ![image](https://github.com/user-attachments/assets/593c76ee-9014-41d4-809d-51d337e30632)

4. DESAFIO PARA CASA:
Desenvolva um menu de opções de uma lanchonete usando 'do-while' e 'switch'. O menu deve ser exibido repetidamente até que o usuário escolha a opção de sair.
Para cada item escolhido, some o valor total.

|  | Bebidas |  |
| --- | --- | --- |
| cod | Item | Valor |
| 11 | Refrigerante | R$5,00 |
| 12 | Suco Natural | R$7,00 |
| 13 | Café | R$3,50 |
| 14 | Chá | R$3,00 |


|  | Lanches |  |
| --- | --- | --- |
| cod | Item | Valor |
| 21 | Hambúrguer  | R$12,00 |
| 22 | X-tudo | R$18,00 |
| 23 | Hot Dog | R$8,00 |
| 24 | Coxinha | R$4,00 |

   
