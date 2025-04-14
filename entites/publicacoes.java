package entites;

// Classe base para todas as publicações (como avaliações, mídias, usuários, etc.)
public class publicacoes {

    protected int id;
    protected String titulo;
    protected String descricao;
    protected String dataUpload;

    // Construtor padrão
    public publicacoes() {
        // Nada a fazer aqui
    }

    // Construtor com validações
    public publicacoes(String titulo, String descricao, String dataUpload) {
        try {
            setTitulo(titulo);
            setDescricao(descricao);
            setDataUpload(dataUpload);
        } catch (PublicacaoInvalidaException e) {
            System.err.println("Erro na criação da publicação: " + e.getMessage());
        }
    }

    // Getters e setters com validação
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws PublicacaoInvalidaException {
        if (titulo == null || titulo.isBlank()) {
            throw new PublicacaoInvalidaException("Título da publicação não pode ser nulo ou vazio.");
        }
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws PublicacaoInvalidaException {
        if (descricao == null || descricao.isBlank()) {
            throw new PublicacaoInvalidaException("Descrição da publicação não pode ser nula ou vazia.");
        }
        this.descricao = descricao;
    }

    public String getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(String dataUpload) throws PublicacaoInvalidaException {
        if (dataUpload == null || dataUpload.isBlank()) {
            throw new PublicacaoInvalidaException("Data de upload não pode ser nula ou vazia.");
        }
        this.dataUpload = dataUpload;
    }

    // Método padrão com tratamento
    public void exibicaoPublicacoes() {
        try {
            System.out.println("Titulo: " + titulo);
            System.out.println("Descrição: " + descricao);
            System.out.println("Data do Upload: " + dataUpload);
        } catch (Exception e) {
            System.err.println("Erro ao exibir publicação: " + e.getMessage());
        } finally {
            System.out.println("Fim da exibição da publicação.\n");
        }
    }

    // Sobrecarga com opção de ocultar descrição
    public void exibicaoPublicacoes(boolean mostrarDescricao) {
        try {
            System.out.println("Titulo: " + titulo);
            if (mostrarDescricao) {
                System.out.println("Descrição: " + descricao);
            } else {
                System.out.println("Descrição: [oculta]");
            }
            System.out.println("Data do Upload: " + dataUpload);
        } catch (Exception e) {
            System.err.println("Erro ao exibir publicação: " + e.getMessage());
        } finally {
            System.out.println("Fim da exibição da publicação.\n");
        }
    }

    // Métodos sobrescritos nas subclasses
    public void exibicaoMidias() {
        // Implementação nas subclasses
    }

    public void exibicaoAvaliacao() {
        // Implementação nas subclasses
    }

    public void exibicaoUsuario() {
        // Implementação nas subclasses
    }
}