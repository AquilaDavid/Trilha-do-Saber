package ui.painel;

import controller.MotorDoJogo;
import domain.pergunta.Pergunta;

import java.util.Scanner;

public class PainelAluno implements Painel {
    
    private MotorDoJogo motor;
    private Scanner scanner;

    public PainelAluno(MotorDoJogo motor) {
        this.motor = motor;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void iniciar() {

        System.out.println("🎮 Bem-vindo ao Trilha do Saber!");
        System.out.println("O jogo começou!\n");

        while (!motor.jogoFinalizado()) {

            System.out.println("📍 Posição atual: " + motor.getPosicaoJogador());

            Pergunta pergunta = motor.getPerguntaAtual();

            if (pergunta != null) {
                System.out.println("❓ Pergunta:");
                System.out.println(pergunta.getTexto());

                System.out.print("Sua resposta: ");
                String resposta = scanner.nextLine();

                boolean acertou = motor.processarJogada(resposta);

                if (acertou) {
                    System.out.println("✅ Resposta correta! Você avançou.\n");
                } else {
                    System.out.println("❌ Resposta incorreta! Você retrocedeu.\n");
                }

            } else {
                System.out.println("🟢 Casa livre! Você avançou.\n");
                motor.processarJogada("skip"); // sem desafio nesta casa
            }
        }

        System.out.println("🏆 Parabéns! Você chegou ao final do jogo!");
        encerrar();
    }

    @Override
    public void encerrar() {
        System.out.println("🔚 Jogo encerrado.");
    }

}
