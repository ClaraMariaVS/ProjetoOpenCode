package entites;

// Classe associativa entre 'publicacoes' e 'midias'
// Representa uma relação onde uma publicação pode ou não conter uma mídia
public class midiaPost{

    private publicacoes publicacao;
    private midias midia;
    private boolean possuiMidia;

    public midiaPost() {}

    public midiaPost(publicacoes publicacao, midias midia, boolean possuiMidia) throws MidiaInvalidaException {
        this.publicacao = publicacao;
        setMidia(midia); // valida dentro do setter
        this.possuiMidia = possuiMidia;
    }

    public publicacoes getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(publicacoes publicacao) {
        this.publicacao = publicacao;
    }

    public midias getMidia() {
        return midia;
    }

    public void setMidia(midias midia) throws MidiaInvalidaException {
        if (midia == null || midia.getFormato() == null || midia.getFormato().isBlank()) {
            throw new MidiaInvalidaException("Mídia inválida ou não suportada.");
        }
        this.midia = midia;
    }

    public boolean isPossuiMidia() {
        return possuiMidia;
    }

    public void setPossuiMidia(boolean possuiMidia) {
        this.possuiMidia = possuiMidia;
    }

    // Método principal com tratamento de erro
    public void exibirMidiaPost() {
        try {
            System.out.println("=== PUBLICAÇÃO ===");
            publicacao.exibicaoPublicacoes();

            if (possuiMidia && midia != null) {
                System.out.println("=== MÍDIA ASSOCIADA ===");
                midia.exibicaoMidias();
            } else {
                throw new MidiaInvalidaException("Nenhuma mídia associada ou inválida.");
            }
        } catch (MidiaInvalidaException e) {
            System.err.println("Erro ao exibir mídia: " + e.getMessage());
        } finally {
            System.out.println("Exibição finalizada.\n");
        }
    }

    // Versão sobrecarregada com controle de exibição
    public void exibirMidiaPost(boolean mostrarMidia) {
        try {
            System.out.println("=== PUBLICAÇÃO ===");
            publicacao.exibicaoPublicacoes();

            if (mostrarMidia && possuiMidia && midia != null) {
                System.out.println("=== MÍDIA ASSOCIADA ===");
                midia.exibicaoMidias();
            } else {
                throw new MidiaInvalidaException("Mídia: [oculta ou inexistente]");
            }

        } catch (MidiaInvalidaException e) {
            System.err.println("Aviso: " + e.getMessage());
        } finally {
            System.out.println("Exibição finalizada.\n");
        }
    }

}



