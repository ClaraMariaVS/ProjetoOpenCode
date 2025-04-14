package entites;

public class avaliacao extends publicacoes implements Exibivel {

    private int data;
    private int nota;

    // Construtor sem parâmetros
    public avaliacao() {
        super();
    }

    // Construtor com parâmetros
    public avaliacao(String titulo, String descricao, String dataUpload, int data, int nota) throws DataInvalidaException {
        super(titulo, descricao, dataUpload);

        if (data <= 0 || String.valueOf(data).length() != 8) {
            throw new DataInvalidaException("A data deve ter 8 dígitos no formato YYYYMMDD.");
        }

        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }

        this.data = data;
        this.nota = nota;
    }

    // Getters e Setters com validações
    public int getData() {
        return data;
    }

    public void setData(int data) throws DataInvalidaException {
        if (data <= 0 || String.valueOf(data).length() != 8) {
            throw new DataInvalidaException("Data inválida. Use o formato DDMMYYYY.");
        }
        this.data = data;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota inválida. Deve ser entre 0 e 10.");
        }
        this.nota = nota;
    }

    @Override
    public void exibicaoAvaliacao() {
        super.exibicaoPublicacoes();
        System.out.println("Data: " + data);
        System.out.println("Nota: " + nota);
    }

    public void exibicaoAvaliacao(boolean mostrarNota) {
        super.exibicaoPublicacoes();
        System.out.println("Data: " + data);
        if (mostrarNota) {
            System.out.println("Nota: " + nota);
        } else {
            System.out.println("Nota: [oculta]");
        }
    }

    @Override
    public void exibir() {
        exibicaoAvaliacao();
    }
}
