package controller;

import domain.dificuldade.Dificuldade;
import domain.dificuldade.DificuldadeFacil;
import domain.dificuldade.DificuldadeMedia;
import domain.dificuldade.DificuldadeDificil;
import repository.RepositorioPerguntas;
import ui.painel.Painel;
import ui.painel.PainelAluno;
import ui.painel.PainelProfessor;

import java.util.Scanner;

public class FachadaDoJogo {
    
    private RepositorioPerguntas repositorio;
    private Dificuldade dificuldade;
    private MotorDoJogo motor;
    private Scanner scanner;

    public FachadaDoJogo() {
    this.repositorio = new repository.RepositorioPerguntasCSV("data/");
    this.dificuldade = new DificuldadeFacil();
    this.scanner = new Scanner(System.in);
}

    public void iniciar() {

        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> iniciarPainelProfessor();
                case 2 -> selecionarDificuldadeEPlayar();
                case 3 -> exibirDificuldadeAtual();
                case 0 -> encerrar();
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n🎯 Trilha do Saber");
        System.out.println("1 - Painel do Professor");
        System.out.println("2 - Jogar (Aluno)");
        System.out.println("3 - Mostrar Dificuldade");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private void iniciarPainelProfessor() {
        Painel painel = new PainelProfessor(repositorio);
        painel.iniciar();
    }

    private void iniciarPainelAluno() {

        if (repositorio.estaVazio()) {
            System.out.println("⚠ Nenhuma pergunta cadastrada!");
            return;
        }

        this.motor = new MotorDoJogo(dificuldade, repositorio);

        Painel painel = new PainelAluno(motor);
        painel.iniciar();
    }

    private void selecionarDificuldadeEPlayar() {
        exibirMenuDificuldade();
        int opcao = Integer.parseInt(scanner.nextLine());

        this.dificuldade = switch (opcao) {
            case 1 -> new DificuldadeFacil();
            case 2 -> new DificuldadeMedia();
            case 3 -> new DificuldadeDificil();
            default -> dificuldade; // mantém a dificuldade anterior
        };

        iniciarPainelAluno();
    }

    private void exibirMenuDificuldade() {
        System.out.println("\n📊 Selecione o nível de dificuldade:");
        System.out.println("1 - Fácil (50% desafios)");
        System.out.println("2 - Médio (80% desafios)");
        System.out.println("3 - Difícil (90% desafios)");
        System.out.print("Escolha: ");
    }

    private void exibirDificuldadeAtual() {
        double percentual = dificuldade.percentualDesafios() * 100;
        System.out.println("\n📊 Dificuldade atual: " + percentual + "% de desafios");
    }

    private void encerrar() {
        System.out.println("🔚 Encerrando sistema...");
        scanner.close();
    }
}
