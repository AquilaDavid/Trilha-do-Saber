package domain.pergunta;

public class Pergunta {

    private String disciplina;
    private String texto;
    private String respostaCorreta;

    public Pergunta(String disciplina, String texto, String respostaCorreta) {
        this.disciplina = disciplina;
        this.texto = texto;
        this.respostaCorreta = respostaCorreta;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getTexto() {
        return texto;
    }

    public boolean estaCorreta(String resposta) {
        return respostaCorreta.equalsIgnoreCase(resposta);
    }

    public String exportarParaCSV() {
        return disciplina + ";" + texto + ";" + respostaCorreta;
    }
}
