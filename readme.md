# 🎮 Trilha do Saber

O **Trilha do Saber** é um jogo educativo desenvolvido em **Java**, executado inicialmente em **terminal**, com o objetivo de reforçar o aprendizado por meio de desafios distribuídos em um tabuleiro em formato de trilha.

Este projeto foi construído com foco em **boas práticas de Orientação a Objetos**, **arquitetura organizada** e **facilidade de manutenção e evolução**.

---

## 📌 Visão Geral do Jogo

O jogador percorre uma trilha composta por várias casas. Algumas casas contêm desafios (perguntas) e outras são casas livres.  
Para avançar, o jogador precisa responder corretamente às perguntas apresentadas durante o percurso.

O jogo possui dois perfis principais:

- **Professor**
- **Aluno**

Cada perfil possui um painel específico de interação.

---

## 👥 Perfis do Sistema

### 🧑‍🏫 Painel do Professor
Permite gerenciar o conteúdo do jogo.

Funcionalidades:
- Adicionar perguntas
- Remover perguntas
- Substituir perguntas existentes
- Listar todas as perguntas cadastradas

As perguntas ficam armazenadas em um repositório central, reutilizado pelo jogo.

---

### 🧑‍🎓 Painel do Aluno
Permite jogar o **Trilha do Saber**.

Funcionalidades:
- Iniciar o jogo
- Visualizar a posição atual no tabuleiro
- Responder perguntas
- Receber feedback de acerto ou erro

---

## 🧩 Como o Jogo Funciona

1. O aluno inicia o jogo pelo **Painel do Aluno**
2. O jogo cria:
   - Um tabuleiro
   - Um jogador
   - Um nível de dificuldade
3. O jogador começa na posição `0`
4. A cada rodada:
   - O jogador avança para uma casa
   - Se a casa tiver desafio:
     - Uma pergunta é exibida
     - O jogador responde
     - O jogo valida a resposta
   - Se a casa não tiver desafio:
     - O jogador avança sem responder pergunta

---

## ⚠️ Regras de Penalidade

- Resposta correta:
  - Jogador avança uma casa
- Resposta incorreta:
  - Jogador retrocede uma casa
- Se o jogador ficar com posição negativa:
  - O jogo é encerrado imediatamente

---

## 🎯 Modos de Dificuldade

O jogo possui três níveis de dificuldade:

- **Fácil** → 50% das casas com desafios
- **Médio** → 80% das casas com desafios
- **Difícil** → 90% das casas com desafios

A dificuldade influencia diretamente a quantidade de casas com perguntas no tabuleiro.

---

## 🧠 Arquitetura do Projeto

O projeto foi estruturado para:
- Separar responsabilidades
- Facilitar manutenção
- Permitir expansão futura (GUI, novos tipos de perguntas, novos modos)

A organização do código segue uma divisão por **tipo técnico**:
- Interfaces
- Classes abstratas
- Implementações concretas
- Camada de controle (fachada)

---

## 🚀 Considerações Finais

O **Trilha do Saber** não é apenas um jogo, mas um projeto didático que demonstra conceitos importantes como:
- Polimorfismo
- Encapsulamento
- Herança
- Interfaces
- Princípios SOLID

Sinta-se à vontade para explorar, modificar e evoluir o projeto.
