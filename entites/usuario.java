package entites;

// Classe 'usuario' herda da superclasse 'publicacoes'
public class usuario extends publicacoes implements Exibivel {
    
    private String nome;
    private String nivel;

    // Construtor padrão
    public usuario() {
        super();
    }

    // Construtor com validação
    public usuario(String titulo, String descricao, String dataUpload, String nome, String nivel) {
        super(titulo, descricao, dataUpload);
        try {
            setNome(nome);
            setNivel(nivel);
        } catch (UsuarioInvalidoException e) {
            System.err.println("Erro ao criar usuário: " + e.getMessage());
        }
    }

    // Getters e Setters com validação
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws UsuarioInvalidoException {
        if (nome == null || nome.isBlank()) {
            throw new UsuarioInvalidoException("Nome do usuário não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) throws UsuarioInvalidoException {
        if (nivel == null || nivel.isBlank()) {
            throw new UsuarioInvalidoException("Nível do usuário não pode ser vazio.");
        }
        this.nivel = nivel;
    }

    // Método sobrescrito com tratamento de erro
    @Override
    public void exibicaoUsuario() {
        try {
            super.exibicaoPublicacoes();
            System.out.println("Nome: " + nome);
            System.out.println("Nivel: " + nivel);
        } catch (Exception e) {
            System.err.println("Erro ao exibir usuário: " + e.getMessage());
        } finally {
            System.out.println("Fim da exibição do usuário.\n");
        }
    }

    // Sobrecarga do método exibicaoUsuario
    public void exibicaoUsuario(boolean mostrarNivel) {
        try {
            super.exibicaoPublicacoes();
            System.out.println("Nome: " + nome);
            if (mostrarNivel) {
                System.out.println("Nivel: " + nivel);
            } else {
                System.out.println("Nivel: [oculto]");
            }
        } catch (Exception e) {
            System.err.println("Erro ao exibir usuário: " + e.getMessage());
        } finally {
            System.out.println("Fim da exibição do usuário.\n");
        }
    }

    @Override
    public void exibir() {
        exibicaoUsuario();
    }

}