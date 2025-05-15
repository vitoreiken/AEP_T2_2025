import javax.swing.JOptionPane;

public class TesteFila {
    public static void main(String[] args) {
        Fila fila = new Fila();
        int opcoes = 1;

        while (opcoes != 0) {
            opcoes = Integer.parseInt(JOptionPane.showInputDialog(
                    "1 - Enfileirar documento\n2 - Imprimir documento\n3 - Consultar\n4 - Exibir fila\n0 - Sair do sistema"));
            switch (opcoes) {
                case 1:
                    String arquivo = JOptionPane.showInputDialog("Digite o nome do arquivo");
                    String usuario = JOptionPane.showInputDialog("Digite o nome do usuário");
                    Documento novoDoc = new Documento(arquivo, usuario);
                    JOptionPane.showMessageDialog(null, fila.enfileiraDocumento(novoDoc));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, fila.desenfileiraDocumento());
                    break;
                case 3:
                    String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo que deseja consultar");
                    JOptionPane.showMessageDialog(null, fila.consultarDocumento(nomeArquivo));
                    break;
                case 4:
                    System.out.println("Exibindo fila\n" + fila);
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
