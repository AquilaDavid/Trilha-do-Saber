# 📊 Diagrama de Classes – Trilha do Saber

Este documento descreve detalhadamente a estrutura do sistema Trilha do Saber com base no Diagrama de Classes.

---

## 🖼️ Visualização do Diagrama

![Diagrama de Classes do Trilha do Saber](./Diagrama-Classes.png)

---

# 🧱 Visão Geral Arquitetural

O sistema foi modelado seguindo os princípios de:

- Alta coesão
- Baixo acoplamento
- Programação orientada a interfaces
- Separação clara de responsabilidades

A arquitetura é organizada em camadas:

- Interface (UI)
- Controle (Controller)
- Domínio (Domain)
- Persistência (Repository)
- Utilitário (Util)

---

# 🎛️ Camada de Interface

## Painel (Interface)

Define o contrato comum para os painéis do sistema:

- iniciar()
- encerrar()

---

## PainelAluno

Responsável por:

- Interagir com a FachadaDoJogo
- Iniciar partidas
- Exibir informações ao jogador

Depende da abstração `FachadaDoJogo`.

---

## PainelProfessor

Responsável por:

- Gerenciar perguntas
- Gerenciar disciplinas

Depende das abstrações:
- RepositorioPerguntas
- RepositorioDisciplinas

---

# 🎮 Camada de Controle

## FachadaDoJogo

Funciona como ponto de entrada simplificado para o jogo.

Responsável por:

- Inicializar o MotorDoJogo
- Delegar operações ao motor

---

## MotorDoJogo

É o núcleo da aplicação.

Responsabilidades:

- Controlar o tabuleiro
- Gerenciar o jogador
- Aplicar a dificuldade
- Buscar perguntas no repositório
- Validar respostas
- Determinar fim de jogo

Depende da interface `RepositorioPerguntas`, garantindo baixo acoplamento.

---

# 🧩 Camada de Domínio

## Pergunta

Representa um desafio do jogo.

Contém:

- Disciplina (String)
- Texto
- Resposta correta

Possui método para validação de resposta.

---

## Disciplina

Representa uma área de conhecimento associada às perguntas.

---

## Jogador

Controla a posição atual no tabuleiro.

---

## Casa

Pode conter uma pergunta ou ser vazia.

---

## Tabuleiro

Contém uma lista de casas.

Possui relação de composição com `Casa`, pois o tabuleiro é formado por casas.

---

## Dificuldade (Interface)

Define o percentual de casas que conterão desafios.

Implementações:

- DificuldadeFacil
- DificuldadeMedia
- DificuldadeDificil

Aplica o padrão Strategy.

---

# 💾 Camada de Persistência

## RepositorioPerguntas (Interface)

Define operações de:

- Adicionar
- Remover
- Substituir
- Listar
- Buscar
- Obter pergunta aleatória

---

## RepositorioPerguntasCSV

Implementação concreta que:

- Lê perguntas de arquivo CSV
- Salva alterações
- Embaralha perguntas
- Aplica rotação circular

---

## RepositorioDisciplinas (Interface)

Gerencia disciplinas do sistema.

---

## RepositorioDisciplinasCSV

Implementação que persiste disciplinas em arquivo CSV.

---

# 🔗 Principais Relações

- MotorDoJogo depende de RepositorioPerguntas (abstração)
- PainelProfessor depende das interfaces de repositório
- Tabuleiro compõe Casas
- Casa pode conter Pergunta
- Dificuldade é aplicada via polimorfismo

---

# ✅ Conclusão

O Diagrama de Classes do Trilha do Saber demonstra:

- Uso correto de abstrações
- Aplicação de polimorfismo
- Separação clara entre regras de negócio e persistência
- Organização estruturada e extensível

A modelagem está alinhada com a implementação real do sistema.
