package domain.jogador;

public class Jogador {
    private int posicao;

    public Jogador() {
        this.posicao = 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public void avancar() {
        posicao++;
    }

    public void retroceder() {
        if (posicao > 0) {
            posicao--;
        }
    }
}
