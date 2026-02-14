# 📘 Relatório Técnico – Decisões Arquiteturais
Projeto: Trilha do Saber  
Linguagem: Java  
Paradigma: Orientação a Objetos  

---

# 1. Visão Geral da Arquitetura

O sistema foi estruturado seguindo o princípio de separação de responsabilidades, dividido em camadas lógicas:

- Camada de Domínio
- Camada de Repositório (Persistência)
- Camada de Serviço/Regras de Negócio
- Camada de Aplicação (Execução do jogo)

Essa divisão reduz acoplamento, aumenta coesão e facilita manutenção e evolução do sistema.

---

# 2. Descrição das Classes e Padrões Utilizados

---

## 🎯 Classe: Disciplina

### Responsabilidade
Representar uma área de conhecimento do jogo.

### Conceitos aplicados
- Encapsulamento (atributos privados)
- Objeto de Domínio
- Alta coesão

### Papel arquitetural
Entidade central do domínio educacional.

---

## ❓ Classe: Pergunta

### Responsabilidade
Representar uma pergunta associada a uma disciplina.

### Conceitos aplicados
- Encapsulamento
- Objeto de Domínio
- Método de exportação para CSV (persistência simplificada)

### Padrão aplicado
- DTO implícito (estrutura simples de transporte de dados)

---

## 🧩 Interface: RepositorioDisciplinas

### Responsabilidade
Definir o contrato para persistência de disciplinas.

### Padrões aplicados
- Repository Pattern
- Programação orientada a interfaces
- Dependency Inversion Principle (DIP)

### Benefício arquitetural
Permite trocar a implementação (CSV, Banco de Dados, memória) sem alterar regras de negócio.

---

## 🧩 Interface: RepositorioPerguntas

### Responsabilidade
Definir contrato para manipulação de perguntas.

### Padrões aplicados
- Repository Pattern
- Abstração por contrato
- DIP (Dependência por abstração)

---

## 💾 Classe: RepositorioPerguntasCSV

### Responsabilidade
Implementação concreta de persistência em arquivo CSV.

### Padrões aplicados
- Strategy (variação de persistência)
- Repository Pattern (implementação concreta)
- Encapsulamento de I/O

### Decisões técnicas
- Uso de Optional para evitar NullPointerException
- Uso de Collections.shuffle para aleatoriedade controlada
- Persistência automática após alteração

### Benefício arquitetural
Isola totalmente a lógica de armazenamento da lógica do jogo.

---

## 🎲 Classe: Tabuleiro

### Responsabilidade
Gerenciar casas e fluxo do jogo.

### Conceitos aplicados
- Composição (Tabuleiro possui Casas)
- Encapsulamento
- Alta coesão

### Padrão implícito
- Aggregate Root (controle central da estrutura de casas)

---

## 🟦 Classe: Casa

### Responsabilidade
Representar uma posição no tabuleiro.

### Conceitos aplicados
- Objeto de valor
- Encapsulamento

---

## 🎮 Classe: Jogo

### Responsabilidade
Orquestrar a execução do sistema.

### Conceitos aplicados
- Controller (camada de aplicação)
- Orquestração de serviços
- Separação entre regra e persistência

---

## ⚙ Classe: Dificuldade (se existir hierarquia)

### Padrão aplicado
- Strategy Pattern (caso existam múltiplas dificuldades)
- Polimorfismo

---

# 3. Aplicação dos Princípios SOLID

Nesta seção são detalhadas as classes que aplicam diretamente cada princípio SOLID e como essa aplicação ocorre na prática.

---

## 🟢 S — Single Responsibility Principle (SRP)

Uma classe deve ter apenas um motivo para mudar.

### Classes que aplicam:

✔ Disciplina  
→ Responsável apenas por representar uma disciplina.

✔ Pergunta  
→ Responsável apenas por representar dados de uma pergunta.

✔ RepositorioPerguntasCSV  
→ Responsável exclusivamente pela persistência em CSV.

✔ Tabuleiro  
→ Responsável apenas pela estrutura e organização das casas.

✔ Casa  
→ Representa somente uma posição do tabuleiro.

✔ Jogo  
→ Responsável por orquestrar a execução do jogo.

Cada classe possui responsabilidade única e bem definida, evitando mistura de regras de negócio com persistência ou controle de fluxo.

---

## 🔵 O — Open/Closed Principle (OCP)

Classes devem estar abertas para extensão e fechadas para modificação.

### Classes que aplicam:

✔ RepositorioPerguntas (interface)  
✔ RepositorioDisciplinas (interface)

Essas interfaces permitem que novas implementações sejam criadas sem alterar o código existente.

Exemplo:
- Pode-se criar RepositorioPerguntasBancoDados
- Pode-se criar RepositorioPerguntasMemoria

Sem modificar a lógica do jogo.

Se houver hierarquia de dificuldade:

✔ Dificuldade (interface ou classe abstrata)  
→ Permite criar novas dificuldades sem alterar código existente.

---

## 🟡 L — Liskov Substitution Principle (LSP)

Subtipos devem poder substituir seus tipos base sem alterar o comportamento esperado.

### Classes que aplicam:

✔ RepositorioPerguntasCSV  
→ Pode substituir RepositorioPerguntas sem quebrar o sistema.

✔ Qualquer futura implementação de RepositorioDisciplinas

A aplicação utiliza polimorfismo corretamente, garantindo intercambialidade.

---

## 🟣 I — Interface Segregation Principle (ISP)

Interfaces devem ser específicas e coesas.

### Classes que aplicam:

✔ RepositorioPerguntas  
✔ RepositorioDisciplinas

As interfaces contêm apenas métodos relacionados à sua responsabilidade.

Não existem interfaces genéricas com métodos não utilizados.

Isso evita dependências desnecessárias.

---

## 🔴 D — Dependency Inversion Principle (DIP)

Módulos de alto nível não devem depender de módulos de baixo nível, mas sim de abstrações.

### Classes que aplicam:

✔ Jogo  
→ Depende de RepositorioPerguntas (interface)  
→ Não depende diretamente de RepositorioPerguntasCSV

✔ Camada de aplicação  
→ Trabalha com abstrações de repositório

✔ Implementações concretas (RepositorioPerguntasCSV)  
→ Dependem da interface base

Isso garante baixo acoplamento e flexibilidade arquitetural.

---

# 📊 Resumo Geral

| Princípio | Classes que Aplicam |
|------------|---------------------|
| SRP | Disciplina, Pergunta, Casa, Tabuleiro, Jogo, RepositorioPerguntasCSV |
| OCP | RepositorioPerguntas, RepositorioDisciplinas, Dificuldade |
| LSP | RepositorioPerguntasCSV e futuras implementações |
| ISP | RepositorioPerguntas, RepositorioDisciplinas |
| DIP | Jogo + Interfaces de Repositório |

---

# 📌 Conclusão Técnica

A aplicação dos princípios SOLID foi realizada de forma estrutural, principalmente por meio de:

- Uso de interfaces como contratos
- Separação clara entre domínio e persistência
- Polimorfismo
- Encapsulamento rigoroso
- Baixo acoplamento entre camadas

A arquitetura atual facilita manutenção, testes e evolução futura do sistema.


# 4. Decisões de Persistência

Foi escolhida persistência em CSV por:

- Simplicidade
- Facilidade de leitura
- Ausência de dependências externas
- Adequação ao escopo acadêmico

A arquitetura permite substituição futura por banco relacional.

---

# 5. Controle de Erros

- Uso de Optional para evitar null
- Validação de índices antes de acesso
- Tratamento de exceções de I/O encapsulado

---

# 6. Benefícios da Arquitetura

- Baixo acoplamento
- Alta coesão
- Facilidade de manutenção
- Escalabilidade futura
- Código testável
- Organização clara por responsabilidade

---

# 7. Conclusão

O projeto foi desenvolvido com foco em boas práticas de engenharia de software, aplicando conceitos sólidos de orientação a objetos e padrões arquiteturais clássicos.

A estrutura atual permite evolução futura sem necessidade de refatorações estruturais profundas.
