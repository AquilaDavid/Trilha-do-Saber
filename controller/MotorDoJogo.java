package controller;

import domain.dificuldade.Dificuldade;
import domain.jogador.Jogador;
import domain.pergunta.Pergunta;
import domain.tabuleiro.Casa;
import domain.tabuleiro.Tabuleiro;
import repository.RepositorioPerguntas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MotorDoJogo {
    
    private Tabuleiro tabuleiro;
    private Jogador jogador;
    private Dificuldade dificuldade;
    private RepositorioPerguntas repositorio;

    public MotorDoJogo(Dificuldade dificuldade, RepositorioPerguntas repositorio) {
        this.dificuldade = dificuldade;
        this.repositorio = repositorio;
        this.jogador = new Jogador();
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {

    int totalCasas = util.GameConfig.carregarNumeroCasas();
    int totalDesafios = (int) (totalCasas * dificuldade.percentualDesafios());

    List<Casa> casas = new ArrayList<>();

    for (int i = 0; i < totalCasas; i++) {

        if (totalDesafios > 0) {

            Optional<Pergunta> perguntaOpt = repositorio.obterPerguntaAleatoria();

            if (perguntaOpt.isPresent()) {
                casas.add(new Casa(perguntaOpt.get()));
                totalDesafios--;
                continue;
            }
        }

        casas.add(new Casa(null));
    }

    this.tabuleiro = new Tabuleiro(casas);
}

    public boolean processarJogada(String resposta) {

        Casa casaAtual = tabuleiro.getCasa(jogador.getPosicao());

        if (!casaAtual.temDesafio()) {
            jogador.avancar();
            return true;
        }

        Pergunta pergunta = casaAtual.getPergunta();

        if (pergunta.estaCorreta(resposta)) {
            casaAtual.removerPergunta();
            jogador.avancar();
            return true;
        } else {
            jogador.retroceder();
            return false;
        }
    }

    public boolean jogoFinalizado() {
        return jogador.getPosicao() >= tabuleiro.totalCasas() - 1;
    }

    public int getPosicaoJogador() {
        return jogador.getPosicao();
    }

    public Pergunta getPerguntaAtual() {
        Casa casa = tabuleiro.getCasa(jogador.getPosicao());
        return casa.getPergunta();
    }
}
