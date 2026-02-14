# 🎮 Trilha do Saber

O **Trilha do Saber** é um jogo educativo desenvolvido em **Java puro**, executado em ambiente de **terminal**, cujo objetivo é unir aprendizado e prática de conceitos sólidos de **Orientação a Objetos**, **arquitetura em camadas** e **princípios SOLID**.

O sistema foi projetado para ser simples na execução, porém robusto na organização interna, permitindo fácil manutenção, avaliação acadêmica e futuras evoluções (como interface gráfica ou persistência em banco de dados).

---

## 🎯 Objetivo do Jogo

O jogador percorre uma trilha composta por casas.  
Algumas casas possuem desafios (perguntas) e outras são casas neutras.

O objetivo é alcançar a última casa do tabuleiro respondendo corretamente aos desafios encontrados no percurso.

O progresso depende de:
- Acertos e erros nas perguntas
- Nível de dificuldade escolhido
- Distribuição dos desafios no tabuleiro

---

## 👥 Perfis do Sistema

O sistema possui dois perfis distintos:

### 🧑‍🏫 Professor

Responsável por gerenciar o conteúdo do jogo.

Através do painel do professor é possível:
- Cadastrar perguntas
- Substituir perguntas existentes
- Remover perguntas
- Visualizar perguntas cadastradas
- Gerenciar disciplinas

As informações são armazenadas em arquivos `.csv`, garantindo persistência simples e desacoplada da lógica do jogo.

---

### 🧑‍🎓 Aluno

Responsável por jogar a partida.

Através do painel do aluno é possível:
- Iniciar uma nova partida
- Escolher o nível de dificuldade
- Visualizar sua posição no tabuleiro
- Responder perguntas
- Receber feedback imediato sobre acertos e erros

---

## 🧩 Estrutura do Tabuleiro

- O tabuleiro é composto por uma lista de casas
- O número de casas é configurável
- O sistema garante um mínimo de 2 casas
- Cada casa pode conter ou não um desafio

### Distribuição dos desafios

A quantidade de casas com perguntas depende da dificuldade escolhida:

- Fácil → 50%
- Médio → 80%
- Difícil → 90%

Caso o número de casas seja maior que o número de perguntas disponíveis:
- As perguntas são reutilizadas de forma rotativa
- A lista é embaralhada automaticamente

---

## 🔁 Dinâmica do Jogo

1. O jogador inicia na posição `0`
2. O sistema informa o estado da casa atual
3. Se houver desafio:
   - A pergunta é exibida
   - O jogador responde
   - O sistema valida automaticamente
4. Se não houver desafio:
   - O jogador avança normalmente

---

## ⚠️ Regras

- Resposta correta → jogador avança uma casa
- Resposta incorreta → jogador retrocede uma casa
- Se a posição ficar menor que zero → jogo encerrado
- Ao alcançar a última casa → vitória

Durante o jogo, o sistema informa:
- Posição atual
- Estado da casa
- Resultado da resposta

---

## 🧠 Arquitetura do Projeto

O sistema foi estruturado com:

- Separação em camadas (UI, Controller, Domain, Repository, Util)
- Uso de interfaces como contratos
- Dependência por abstração
- Composição entre Tabuleiro e Casa
- Uso de `Optional` para evitar valores nulos
- Persistência em arquivos CSV

Essa organização permite:

- Fácil manutenção
- Evolução futura
- Baixo acoplamento
- Alta coesão

---

## 📊 Documentação Técnica

A explicação detalhada do **Diagrama de Classes** encontra-se na pasta:

