package repository.repository;

import domain.disciplina.Disciplina;
import java.util.List;
import java.util.Optional;

public interface RepositorioDisciplinas {

    void adicionar(Disciplina disciplina);

    void remover(String nome);

    List<Disciplina> listar();

    Optional<Disciplina> buscarPorNome(String nome);

    boolean estaVazio();

    int totalDisciplinas();
}
