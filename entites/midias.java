package entites;

public class midias extends publicacoes implements Exibivel {
    
private String formato;
private int duracao;

// Construtor padrão
public midias() {
    super();
}

// Construtor com parâmetros e validação
public midias(String titulo, String descricao, String dataUpload, String formato, int duracao) throws MidiaInvalidaException {
    super(titulo, descricao, dataUpload);

    if (formato == null || formato.isBlank()) {
        throw new MidiaInvalidaException("Formato da mídia não pode ser nulo ou vazio.");
    }

    if (duracao < 0) {
        throw new MidiaInvalidaException("Duração da mídia não pode ser negativa.");
    }

    this.formato = formato;
    this.duracao = duracao;
}

// Getters e Setters com validação
public String getFormato() {
    return formato;
}

public void setFormato(String formato) throws MidiaInvalidaException {
    if (formato == null || formato.isBlank()) {
        throw new MidiaInvalidaException("Formato inválido.");
    }
    this.formato = formato;
}

public int getDuracao() {
    return duracao;
}

public void setDuracao(int duracao) throws MidiaInvalidaException {
    if (duracao < 0) {
        throw new MidiaInvalidaException("Duração não pode ser negativa.");
    }
    this.duracao = duracao;
}

// Sobrescrita com tratamento
@Override
public void exibicaoMidias() {
    try {
        super.exibicaoPublicacoes();
        if (formato == null || formato.isBlank()) {
            throw new MidiaInvalidaException("Formato ausente.");
        }
        System.out.println("Formato: " + formato);
        System.out.println("Duração: " + duracao);
    } catch (MidiaInvalidaException e) {
        System.err.println("Erro ao exibir mídia: " + e.getMessage());
    } finally {
        System.out.println("Fim da exibição da mídia.\n");
    }
}

// Sobrecarga com tratamento
public void exibicaoMidias(boolean mostrarDuracao) {
    try {
        super.exibicaoPublicacoes();
        if (formato == null || formato.isBlank()) {
            throw new MidiaInvalidaException("Formato ausente.");
        }
        System.out.println("Formato: " + formato);
        if (mostrarDuracao) {
            System.out.println("Duração: " + duracao);
        } else {
            System.out.println("Duração: [oculta]");
        }
    } catch (MidiaInvalidaException e) {
        System.err.println("Erro ao exibir mídia: " + e.getMessage());
    } finally {
        System.out.println("Fim da exibição da mídia.\n");
    }
}

@Override
public void exibir() {
    exibicaoMidias();
}
}