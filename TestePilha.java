import java.util.Scanner;
import java.util.Date;

public class TestePilha {
    public static void main(String[] args) {
        // Classes utilitárias
        Scanner scanner = new Scanner(System.in);
        Pilha pilha = new Pilha();

        System.out.println("Digite o nome do arquivo");
        String arquivo = scanner.nextLine();
        System.out.println("Digite o nome do usuario");
        String usuario = scanner.nextLine();
        Long tempoAtual = System.currentTimeMillis();
        Date dataAtual = new Date(tempoAtual);

        Documento docTeste = new Documento(arquivo, usuario);
        docTeste.setHorarioSolicitacao(dataAtual);
        
        System.out.println("Pilha\n"+pilha);
        System.out.println("Empilhando:\n"+pilha.empilharDocumento(docTeste));
        System.out.println("Pilha\n"+pilha);
        System.out.println("Verificando:\n"+pilha.verificarDocumento(docTeste));
        System.out.println("Imprimindo:\n"+pilha.desempilharDocumento());
        System.out.println("Pilha\n"+pilha);
        scanner.close();
    }
}
