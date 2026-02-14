package repository;

import domain.pergunta.Pergunta;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class RepositorioPerguntasCSV implements RepositorioPerguntas {

    private final String pasta;
    private final List<Pergunta> perguntas = new ArrayList<>();
    private int indiceCircular = 0;

    public RepositorioPerguntasCSV(String pasta) {
        this.pasta = pasta;
        criarEstrutura();
        carregarArquivo();
    }

    private void criarEstrutura() {
        try {
            Files.createDirectories(Paths.get(pasta));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar pasta data.");
        }
    }

    private void carregarArquivo() {

        Path path = Paths.get(pasta + "perguntas.csv");
        if (!Files.exists(path)) return;

        try (BufferedReader br = Files.newBufferedReader(path)) {

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(";");

                if (partes.length < 3) continue;

                Pergunta p = new Pergunta(
                        partes[0], // disciplina
                        partes[1], // texto
                        partes[2]  // resposta
                );

                perguntas.add(p);
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler perguntas.csv");
        }

        Collections.shuffle(perguntas);
    }

    private void salvarTudo() {

        Path path = Paths.get(pasta + "perguntas.csv");

        try (BufferedWriter bw = Files.newBufferedWriter(
                path,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            for (Pergunta p : perguntas) {
                bw.write(p.exportarParaCSV());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar perguntas.");
        }
    }

    @Override
    public void adicionar(Pergunta pergunta) {
        perguntas.add(pergunta);
        salvarTudo();
    }

    @Override
    public void substituir(int indice, Pergunta novaPergunta) {
        perguntas.set(indice, novaPergunta);
        salvarTudo();
    }

    @Override
    public void remover(int indice) {
        perguntas.remove(indice);
        salvarTudo();
    }

    @Override
    public List<Pergunta> listar() {
        return new ArrayList<>(perguntas);
    }

    @Override
    public Optional<Pergunta> buscarPorIndice(int indice) {
        if (indice < 0 || indice >= perguntas.size()) return Optional.empty();
        return Optional.of(perguntas.get(indice));
    }

    @Override
    public Optional<Pergunta> obterPerguntaAleatoria() {

        if (perguntas.isEmpty()) return Optional.empty();

        if (indiceCircular >= perguntas.size()) {
            indiceCircular = 0;
            Collections.shuffle(perguntas);
        }

        return Optional.of(perguntas.get(indiceCircular++));
    }

    @Override
    public boolean estaVazio() {
        return perguntas.isEmpty();
    }

    @Override
    public int totalPerguntas() {
        return perguntas.size();
    }
}
