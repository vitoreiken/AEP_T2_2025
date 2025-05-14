public class Pilha {
    Documento[] dados;
    int topo;

    //Construtores
    public Pilha (int capacidade){
        topo = 0;
        dados = new Documento[capacidade];
    }

    public Pilha(){
        this(10);
    }

    // Verificação de pilha
    public boolean pilhaVazia(){
        return topo==0;
    }
    public boolean pilhaCheia(){
        return topo==dados.length;
    }

    // Verificar orientação
    // Documento adicionado ao topo da pilha de reimpressão
    public String empilharDocumento(Documento e){
        if(pilhaCheia()) throw new RuntimeException("Capacidade máxima foi atingida");
        dados[topo++] = e;
        return "Arquivo: "+e.getNomeArquivo()+" foi adicionado a pilha de reimpressão, pedido feito pelo usuário "+e.getNomeUsuario()+" na data de "+e.getHorarioSolicitacao();
    }

    // Verificar orientação
    // Documento que está no topo da pilha é reimpresso (removido do topo).
    public Documento desempilharDocumento(){    
        if(pilhaVazia()) throw new RuntimeException("Pilha está vazia");
        return dados[--topo];
    }

    // Verificar orientação
    // Verificar se um documento está na pilha de reimpressão, sua posição (a partir do topo) e o horário de solicitação 
    public Documento verificarDocumento(Documento novo){
        if (pilhaVazia())  throw new RuntimeException("Pilha está vazia");
        return dados[topo-1];
    }

    @Override
    public String toString(){
        if (pilhaVazia())
            return "Pilha vazia";
        String s ="";
        for (int i = 0, cont=topo; cont!=0; cont--, i++){
            s = s + dados[i]+" ";
        }
        System.out.println("Acabou");
        return s;
    }
}