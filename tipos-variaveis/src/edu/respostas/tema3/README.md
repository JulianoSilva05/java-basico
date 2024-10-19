# Classe String

A classe `String` em Java é uma classe fundamental que representa uma sequência imutável de caracteres. Ela é amplamente utilizada para manipular e armazenar texto. Aqui estão alguns pontos importantes sobre a classe `String`:

- **Imutabilidade**: Uma vez criada, uma `String` não pode ser alterada. Operações que parecem modificar uma `String` na verdade criam uma nova `String`.
- **Criação**: `Strings` podem ser criadas usando literais (entre aspas duplas) ou usando o construtor da classe `String`.
- **Métodos úteis**: A classe `String` oferece muitos métodos para manipulação de texto, como `length()`, `charAt()`, `substring()`, `toLowerCase()`, `toUpperCase()`, `trim()`, `replace()`, `split()`, entre outros.
- **Comparação**: Para comparar `Strings`, use o método `equals()` ou `equalsIgnoreCase()`, não o operador `==`.
- **Concatenação**: `Strings` podem ser concatenadas usando o operador `+` ou o método `concat()`.
- **Pool de Strings**: Java mantém um *pool* de `Strings` para otimizar o uso de memória.

```java
// Exemplos de uso da classe String
String str1 = "Hello";
String str2 = new String("World");
String str3 = str1 + " " + str2; // Hello World
int length = str3.length(); // 11
char ch = str3.charAt(0); // 'H'
String sub = str3.substring(0, 5); // "Hello"
boolean equals = str1.equals("Hello"); // true
A classe String é essencial em Java e é usada em praticamente todos os programas para manipulação de texto.
´´´
##Métodos de String
A classe String em Java oferece uma ampla variedade de métodos úteis para manipulação e análise de strings. Aqui estão alguns dos métodos mais comumente utilizados, com exemplos:

###1. length()
Retorna o número de caracteres na string.

´´´java

String str = "Hello";
int length = str.length(); // length = 5
2. charAt(int index)
Retorna o caractere na posição especificada.
´´´
´´´java

String str = "Hello";
char ch = str.charAt(1); // ch = 'e'
3. substring(int beginIndex, int endIndex)
Extrai uma parte da string, começando do índice beginIndex (inclusive) até endIndex (exclusive).
´´´
´´´java

String str = "Hello World";
String sub = str.substring(6, 11); // sub = "World"
4. toLowerCase() e toUpperCase()
Converte todos os caracteres para minúsculas ou maiúsculas, respectivamente.
´´´
´´´java

String str = "Hello";
String lower = str.toLowerCase(); // lower = "hello"
String upper = str.toUpperCase(); // upper = "HELLO"
5. trim()
Remove espaços em branco do início e do fim da string.
´´´
´´´java

String str = "  Hello World  ";
String trimmed = str.trim(); // trimmed = "Hello World"
6. replace(CharSequence target, CharSequence replacement)
Substitui todas as ocorrências de uma sequência de caracteres por outra.
´´´
´´´java

String str = "Hello World";
String replaced = str.replace("o", "0"); // replaced = "Hell0 W0rld"
7. split(String regex)
Divide a string em um array de substrings com base em uma expressão regular.
´´´
´´´java

String str = "apple,banana,orange";
String[] fruits = str.split(","); // fruits = ["apple", "banana", "orange"]
8. contains(CharSequence sequence)
Verifica se a string contém uma sequência específica de caracteres.
´´´
´´´java

String str = "Hello World";
boolean contains = str.contains("World"); // contains = true
9. startsWith(String prefix) e endsWith(String suffix)
Verifica se a string começa ou termina com uma determinada sequência.
´´´
´´´java

String str = "Hello World";
boolean starts = str.startsWith("Hello"); // starts = true
boolean ends = str.endsWith("World"); // ends = true
10. indexOf(String str) e lastIndexOf(String str)
Retorna o índice da primeira ou última ocorrência de uma substring.
´´´


´´´java

String str = "Hello World";
int index = str.indexOf("o"); // index = 4
int lastIndex = str.lastIndexOf("o"); // lastIndex = 7
´´´
Estes são apenas alguns dos muitos métodos disponíveis na classe String. Cada método tem sua utilidade específica e pode ser combinado com outros para realizar operações complexas de manipulação de strings em ´´´java´´´.

Atividade:
Escreva um programa que verifique a primeira letra de uma string fornecida pelo usuário, usando o método charAt().
Crie um programa que substitua todas as ocorrências de uma letra por outra em uma string, usando o método replace().
Escreva uma função que remova todos os espaços em branco no início e no final de uma string.
Implemente um validador de senhas que verifique se uma string contém pelo menos 8 caracteres, usando o método length().
Desenvolva um programa que encontre a primeira e a última ocorrência de uma letra em uma frase, usando os métodos indexOf() e lastIndexOf().
Exemplo:

java

String texto = "O dia está ensolarado hoje";
int textoPrimeiraOcorrencia = texto.indexOf("d");
int textoUltimaOcorrencia = texto.lastIndexOf("j");
System.out.println(textoPrimeiraOcorrencia + " - " + textoUltimaOcorrencia);
// Deve retornar
// 2 - 24
Implemente um programa que imprima o primeiro e último caractere de um texto digitado pelo usuário.
Escreva um programa que verifique se o último caractere de uma string fornecida pelo usuário é ".".