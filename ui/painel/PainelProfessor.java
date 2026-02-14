package ui.painel;

import domain.pergunta.Pergunta;
import repository.RepositorioPerguntas;

import java.util.List;
import java.util.Scanner;

public class PainelProfessor implements Painel {
    
    private RepositorioPerguntas repositorio;
    private Scanner scanner;

    public PainelProfessor(RepositorioPerguntas repositorio) {
        this.repositorio = repositorio;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void iniciar() {

        int opcao;

        do {
            exibirMenu();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> adicionarPergunta();
                case 2 -> listarPerguntas();
                case 3 -> removerPergunta();
                case 4 -> substituirPergunta();
                case 5 -> definirNumeroCasas();
                case 0 -> encerrar();
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\n📚 Painel do Professor");
        System.out.println("1 - Adicionar pergunta");
        System.out.println("2 - Listar perguntas");
        System.out.println("3 - Remover pergunta");
        System.out.println("4 - Substituir pergunta");
        System.out.println("5 - Definir número de casas");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private void adicionarPergunta() {

    System.out.print("Digite o nome da disciplina: ");
    String disciplina = scanner.nextLine();

    System.out.print("Digite o enunciado: ");
    String texto = scanner.nextLine();

    System.out.print("Digite a resposta correta: ");
    String resposta = scanner.nextLine();

    Pergunta pergunta = new Pergunta(disciplina, texto, resposta);

    repositorio.adicionar(pergunta);

    System.out.println("✅ Pergunta adicionada!");
}


    private void listarPerguntas() {
        List<Pergunta> perguntas = repositorio.listar();

        if (perguntas.isEmpty()) {
            System.out.println("Nenhuma pergunta cadastrada.");
            return;
        }

        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println(i + " - " + perguntas.get(i).getTexto());
        }
    }

    private void removerPergunta() {
        listarPerguntas();
        System.out.print("Digite o índice da pergunta para remover: ");
        int indice = Integer.parseInt(scanner.nextLine());

        try {
            repositorio.remover(indice);
            System.out.println("🗑 Pergunta removida!");
        } catch (Exception e) {
            System.out.println("Índice inválido.");
        }
    }

    private void substituirPergunta() {

    listarPerguntas();

    System.out.print("Digite o índice da pergunta para substituir: ");
    int indice = Integer.parseInt(scanner.nextLine());

    System.out.print("Nova disciplina: ");
    String disciplina = scanner.nextLine();

    System.out.print("Novo enunciado: ");
    String texto = scanner.nextLine();

    System.out.print("Nova resposta correta: ");
    String resposta = scanner.nextLine();

    Pergunta novaPergunta = new Pergunta(disciplina, texto, resposta);

    try {
        repositorio.substituir(indice, novaPergunta);
        System.out.println("🔄 Pergunta substituída!");
    } catch (Exception e) {
        System.out.println("Índice inválido.");
    }
}


    private void definirNumeroCasas() {
    System.out.print("Digite o número de casas do jogo: ");
    int numero = Integer.parseInt(scanner.nextLine());
    util.GameConfig.salvarNumeroCasas(numero);
    System.out.println("✅ Número de casas salvo!");
}

    @Override
    public void encerrar() {
        System.out.println("🔚 Encerrando painel do professor.");
    }

}
