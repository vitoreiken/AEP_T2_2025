import javax.swing.JOptionPane;

public class TestePilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        int opcoes = 1;

        while (opcoes != 0) {
            opcoes = Integer.parseInt(JOptionPane.showInputDialog(
                    "1 - Empilhar documento\n2 - Imprimir documento\n3 - Verificar documento\n4 - Exibir pilha\n0 - Sair do sistema"));
            switch (opcoes) {
                case 1:
                    String arquivo = JOptionPane.showInputDialog("Digite o nome do arquivo");
                    String usuario = JOptionPane.showInputDialog("Digite o nome do usuário");
                    Documento docTeste = new Documento(arquivo, usuario);
                    JOptionPane.showMessageDialog(null, pilha.empilharDocumento(docTeste));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, pilha.desempilharDocumento());
                    break;
                case 3:
                    String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo que deseja verificar");
                    JOptionPane.showMessageDialog(null, pilha.verificarDocumento(nomeArquivo));
                    break;
                case 4:
                    System.out.println("Exibindo pilha\n"+pilha);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }
}
