package domain.tabuleiro;

import java.util.List;

public class Tabuleiro {
    private List<Casa> casas;

    public Tabuleiro(List<Casa> casas) {
        if (casas.size() < 2) {
            throw new IllegalArgumentException("O tabuleiro deve ter no mínimo 2 casas.");
        }
        this.casas = casas;
    }

    public Casa getCasa(int posicao) {
        return casas.get(posicao);
    }

    public int totalCasas() {
        return casas.size();
    }
}
