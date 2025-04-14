package entites;

public class App {
    public static void main(String[] args) {
        try {
            // Publicação com mídia associada
            midias midia1 = new midias("Java para iniciantes", "Curso básico de Java", "05/08/2025", "Vídeo", 120);
            avaliacao avaliacao1 = new avaliacao("Curso", "Muito empolgante!", "06/04/2025", 20250406, 10);
            midiaPost associacaoComMidia = new midiaPost(avaliacao1, midia1, true);
            usuario usuario1 = new usuario("Java para iniciantes", "Comentário: Achei incrível, muito didático!", "06/04/2025", "Ben Afleck de Souza", "Aluno");

            System.out.println("=== PUBLICAÇÃO COM MÍDIA ===");
            associacaoComMidia.exibirMidiaPost();

            System.out.println("--- USUÁRIO QUE COMENTOU ---");
            usuario1.exibicaoUsuario();

            // Publicação sem mídia associada (com data inválida proposital para teste)
            try {
                avaliacao avaliacao2 = new avaliacao("Java para iniciantes", "Preparação do curso", "05/08/2025", 20250805, 4);
                midiaPost associacaoSemMidia = new midiaPost(avaliacao2, null, false);
                usuario usuario2 = new usuario("Java para iniciantes", "Comentário: Espero ansiosamente!", "10/008/2025", "Ben Afleck de Souza", "Aluno");

                System.out.println("\n=== PUBLICAÇÃO SEM MÍDIA ===");
                associacaoSemMidia.exibirMidiaPost();

                System.out.println("--- USUÁRIO QUE COMENTOU ---");
                usuario2.exibicaoUsuario();

                // SOBRECARGA do método
                System.out.println("\n=== Comentário ===");
                associacaoComMidia.exibirMidiaPost(false);

                // Forçando mostrar mídia mesmo que seja null
                System.out.println("\n=== Comentário ===");
                associacaoSemMidia.exibirMidiaPost(true);

                // POLIMORFISMO VIA INTERFACE
                System.out.println("\n=== EXIBIÇÃO VIA INTERFACE Exibivel ===");
                Exibivel[] elementos = {
                    avaliacao1,
                    midia1,
                    usuario1,
                    avaliacao2,
                    usuario2
                };

                for (Exibivel elemento : elementos) {
                    elemento.exibir();
                    System.out.println("---------------------------");
                }

            } catch (DataInvalidaException e) {
                System.err.println("Erro de data inválida: " + e.getMessage());
            } catch (MidiaNaoDisponivelException e) {
                System.err.println("Erro de mídia: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Erro inesperado no programa: " + e.getMessage());
        } finally {
            System.out.println("\nPrograma finalizado.");
        }
    }
    }
    
