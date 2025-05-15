import java.util.Date;

public class Pilha {
    Documento[] documentos;
    int topo;

    //Construtores
    public Pilha (int capacidade){
        topo = 0;
        documentos = new Documento[capacidade];
    }

    public Pilha(){
        this(10);
    }

    // Verificação de pilha
    public boolean pilhaVazia(){
        return topo==0;
    }
    public boolean pilhaCheia(){
        return topo==documentos.length;
    }

    // Documento adicionado ao topo da pilha de reimpressão
    public String empilharDocumento(Documento e){
        if(pilhaCheia()) return "Capacidade máxima foi atingida";
        Long tempoSolicitacao = System.currentTimeMillis();
        Date data = new Date(tempoSolicitacao);
        e.setHorarioSolicitacao(data);
        documentos[topo++] = e;
        return "Arquivo: "+e.getNomeArquivo()+" foi adicionado a pilha de reimpressão, pedido feito pelo usuário "+e.getNomeUsuario()+" na data de "+e.getHorarioSolicitacao();
    }

    // Documento que está no topo da pilha é reimpresso (removido do topo).
    public String desempilharDocumento(){    
        if(pilhaVazia()) return "Pilha está vazia";
        Long horarioImpressao = System.currentTimeMillis();
        Date dataImpressao = new Date(horarioImpressao);
        Date dataSolicitacao = (Date)documentos[--topo].getHorarioSolicitacao();
        long tempoEspera = dataImpressao.getTime()-dataSolicitacao.getTime();
        return "Horário de reimpressão: "+dataImpressao+"\nTempo desde a solicitação: "+(tempoEspera/1000)+" segundos";
    }

    // Verificar se um documento está na pilha de reimpressão, sua posição (a partir do topo) e o horário de solicitação 
    public String verificarDocumento(String novo){
        if (pilhaVazia()) return "Pilha está vazia";
        Long horarioReimpressao = System.currentTimeMillis();
        Date dataReimpressao = new Date(horarioReimpressao);
        // Verificar a partir do topo
        for(int i=topo-1, posicao = 0; i>=0; i--, posicao++){
            if (novo.equals(documentos[i].getNomeArquivo())){
                return "Documento está na pilha de reimpressão\nNome: "+documentos[i].getNomeArquivo()+"\nPosição: "+posicao+"\nHorário de solicitação de reimpressão: "+dataReimpressao;
            }
        }
        return "Documento não está na pilha";
    }

    @Override
    public String toString(){
        if (pilhaVazia())
            return "Pilha vazia";
        String s ="";
        for (int i = 0, cont=topo; cont!=0; cont--, i++){
            s = s + documentos[i]+"\n";
        }
        return s;
    }
}