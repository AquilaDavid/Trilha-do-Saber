# 🎮 Trilha do Saber

O **Trilha do Saber** é um jogo educativo desenvolvido em **Java puro**, executado inicialmente em **terminal**, cujo foco principal é promover o aprendizado por meio de desafios e, ao mesmo tempo, demonstrar a aplicação correta de **Orientação a Objetos**, **arquitetura limpa** e **princípios SOLID**.

O projeto foi pensado para ser simples na execução, porém **robusto na organização do código**, permitindo fácil avaliação acadêmica e futura evolução, como a adição de interface gráfica ou novos tipos de desafios.

---

## 🎯 Objetivo do Jogo

O objetivo do jogo é conduzir o jogador por uma **trilha de casas**, respondendo corretamente aos desafios apresentados ao longo do percurso até alcançar a linha de chegada.

O progresso do jogador depende:
- Do acerto ou erro das perguntas
- Do nível de dificuldade selecionado
- Da distribuição aleatória dos desafios no tabuleiro

---

## 👥 Perfis do Sistema

O sistema possui **dois perfis distintos**, cada um com responsabilidades bem definidas, acessados por meio de painéis específicos.

### 🧑‍🏫 Professor
O professor é responsável pela **configuração e manutenção do conteúdo do jogo**.

Por meio do **Painel do Professor**, é possível:
- Cadastrar novas perguntas
- Editar ou substituir perguntas existentes
- Remover perguntas
- Visualizar todas as perguntas cadastradas

As perguntas são armazenadas em um **repositório central**, permitindo reutilização e desacoplamento entre o conteúdo e a lógica do jogo.

---

### 🧑‍🎓 Aluno
O aluno é o jogador do sistema.

Por meio do **Painel do Aluno**, é possível:
- Iniciar uma nova partida
- Acompanhar sua posição atual no tabuleiro
- Visualizar o estado da casa atual (com ou sem desafio)
- Responder perguntas
- Receber feedback imediato sobre acertos e erros

---

## 🧩 Estrutura do Tabuleiro

- O tabuleiro representa a trilha do jogo
- A quantidade de casas é definida pelo professor
- O sistema garante um **mínimo de 2 casas**
- Cada casa pode:
  - Conter um desafio (pergunta)
  - Ou ser uma casa vazia (casa de sorte)

### Distribuição dos desafios
- A distribuição das perguntas ocorre de forma **aleatória**
- Caso o número de casas seja maior que o número de perguntas disponíveis:
  - As perguntas são reutilizadas de forma randômica
- Nem todas as casas necessariamente terão desafios

---

## ❓ Perguntas e Desafios

As perguntas são modeladas como um **conceito central do domínio do jogo**.

Características:
- Cada pergunta possui:
  - Um texto
  - Uma resposta correta
- Existe uma classe abstrata base (`Pergunta`)
- Tipos específicos de perguntas são representados por subclasses, como:
  - Pergunta de Matemática
  - Pergunta de Geografia
  - Pergunta de História

Essa abordagem permite:
- Reutilização de lógica comum
- Organização semântica
- Fácil extensão futura sem alterar código existente

---

## 🎯 Modos de Dificuldade

O jogo possui três modos de dificuldade, implementados de forma **polimórfica**:

- **Fácil**  
  - 50% das casas possuem desafios
- **Médio**  
  - 80% das casas possuem desafios
- **Difícil**  
  - 90% das casas possuem desafios

O cálculo do número de desafios é baseado no **total de casas do tabuleiro**, garantindo sempre um valor inteiro.

---

## 🔁 Dinâmica do Jogo

1. O jogador inicia na posição `0`
2. A cada rodada:
   - O sistema informa a posição atual do jogador
   - Exibe se a casa atual possui desafio ou não
3. Caso a casa **não possua desafio**:
   - O jogador é informado que teve sorte
   - Pode avançar normalmente
4. Caso a casa **possua desafio**:
   - A pergunta é exibida
   - O jogador insere sua resposta
   - O sistema valida automaticamente a resposta

---

## ⚠️ Penalidades e Regras de Fim de Jogo

- **Resposta correta**
  - O jogador avança uma casa
  - O contador de desafios restantes diminui
- **Resposta incorreta**
  - O jogador retrocede uma casa (-1)
- Se a posição do jogador ficar **menor que zero**:
  - O jogo é encerrado imediatamente
  - Uma mensagem de incentivo/zoação é exibida
- Ao alcançar a última casa do tabuleiro:
  - O jogo é encerrado com sucesso
  - Uma mensagem encorajadora é exibida
  - É informado que o jogador “ganhou 1 ponto na disciplina” (valor simbólico)

---

## 📊 Informações Exibidas Durante o Jogo

Durante a execução, o sistema exibe:
- Posição atual do jogador
- Estado da casa (com ou sem desafio)
- Quantidade de desafios restantes no percurso
- Resultado da resposta (acerto ou erro)

---

## 🧠 Arquitetura e Organização do Código

O projeto foi desenvolvido com foco em:
- Separação clara de responsabilidades
- Baixo acoplamento
- Alta coesão

Principais decisões arquiteturais:
- Uso de **interfaces** para contratos (`Painel`, `Dificuldade`)
- Uso de **classe abstrata** para conceitos do domínio (`Pergunta`)
- Aplicação de **polimorfismo**, evitando `instanceof`
- Organização de pacotes por **tipo técnico** (interfaces, abstratas, implementações)

Essa arquitetura facilita:
- Manutenção
- Testes
- Evolução futura (ex: interface gráfica)

---

## 🚀 Considerações Finais

O **Trilha do Saber** é um jogo educativo simples em sua execução, porém cuidadosamente planejado do ponto de vista de engenharia de software.  
Ele demonstra, de forma prática, conceitos fundamentais de **Orientação a Objetos**, **UML** e **princípios SOLID**, atendendo plenamente aos critérios de atividades acadêmicas rigorosas.

---
