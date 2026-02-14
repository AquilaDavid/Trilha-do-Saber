package util;

import java.io.*;
import java.nio.file.*;

public class GameConfig {

    private static final String PATH = "data/config.txt";

    public static void salvarNumeroCasas(int numero) {
        try {
            Files.writeString(Paths.get(PATH), String.valueOf(numero),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar configuração.");
        }
    }

    public static int carregarNumeroCasas() {
        try {
            if (!Files.exists(Paths.get(PATH))) return 10;
            String conteudo = Files.readString(Paths.get(PATH));
            return Integer.parseInt(conteudo.trim());
        } catch (Exception e) {
            return 10;
        }
    }
}
