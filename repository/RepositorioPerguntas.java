package repository;

import domain.pergunta.Pergunta;

import java.util.List;
import java.util.Optional;

public interface RepositorioPerguntas {

    void adicionar(Pergunta pergunta);

    void substituir(int indice, Pergunta novaPergunta);

    void remover(int indice);

    List<Pergunta> listar();

    Optional<Pergunta> buscarPorIndice(int indice);

    Optional<Pergunta> obterPerguntaAleatoria();

    boolean estaVazio();

    int totalPerguntas();
}
