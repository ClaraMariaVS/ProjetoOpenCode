import entites.avaliacao;
import entites.midiaPost;
import entites.midias;
import entites.publicacoes;
import entites.usuario;

public class Exception {
     public static void main(String[] args) {
       
        try {
            System.out.println("Teste 1: Avaliação com nota inválida (nota = 15, deve estar entre 0 e 10)");
            avaliacao aval = new avaliacao("Curso de Java", "Avaliação de curso", "01/01/2025", 20250101, 15);
            aval.exibicaoAvaliacao();
        } catch (Exception e) {
            System.err.println("Erro na Avaliação: " + e.getMessage());
        } finally {
            System.out.println("Teste 1 concluído.\n");
        }

        
        try {
            System.out.println("Teste 2: Mídia com formato inválido (formato vazio)");
            midias mid = new midias("Aula de Java", "Vídeo introdutório", "02/01/2025", "", 120);
            mid.exibicaoMidias();
        } catch (Exception e) {
            System.err.println("Erro na Mídia: " + e.getMessage());
        } finally {
            System.out.println("Teste 2 concluído.\n");
        }

       
        try {
            System.out.println("Teste 3: Mídia com duração negativa");
            midias mid2 = new midias("Aula de Java", "Vídeo introdutório", "02/01/2025", "Vídeo", -90);
            mid2.exibicaoMidias();
        } catch (Exception e) {
            System.err.println("Erro na Mídia: " + e.getMessage());
        } finally {
            System.out.println("Teste 3 concluído.\n");
        }

        
        try {
            System.out.println("Teste 4: Usuário com nome inválido (nome vazio)");
            usuario user = new usuario("Perfil de Usuário", "Dados do usuário", "03/01/2025", "", "Aluno");
            user.exibicaoUsuario();
        } catch (Exception e) {
            System.err.println("Erro no Usuário: " + e.getMessage());
        } finally {
            System.out.println("Teste 4 concluído.\n");
        }

        
        try {
            System.out.println("Teste 5: midiaPost com mídia nula");
           
            publicacoes pub = new publicacoes("Publicação Teste", "Descrição da publicação", "04/01/2025");
            
            midiaPost mp = new midiaPost(pub, null, true);
            mp.exibirMidiaPost();
        } catch (Exception e) {
            System.err.println("Erro no midiaPost: " + e.getMessage());
        } finally {
            System.out.println("Teste 5 concluído.\n");
        }

        System.out.println("Todos os testes foram realizados.");
    }
}
