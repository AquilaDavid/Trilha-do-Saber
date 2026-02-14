package domain.tabuleiro;

import domain.pergunta.Pergunta;

public class Casa {
    private Pergunta pergunta;

    public Casa(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public boolean temDesafio() {
        return pergunta != null;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void removerPergunta() {
        this.pergunta = null;
    }
}
