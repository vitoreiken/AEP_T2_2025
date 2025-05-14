import java.util.Date;

public class Fila {
    Documento[] documentos;
    int primeiro, ultimo, ocupacao;


    //Construtores
    public Fila(int capacidade) {
        primeiro = 0;
        ultimo = 0;
        ocupacao = 0;
        documentos = new Documento[capacidade];
    }

    public Fila() {
        this(10);
    }

    // Verificação de fila
    public boolean filaVazia() {
        return ocupacao == 0;
    }

    public boolean filaCheia() {
        return ocupacao == documentos.length;
    }

    // Verifica a próxima posição
    private int proximaPosicao(int posicao) {
        return (posicao + 1) % documentos.length;
    }

    // Um documento entra na fila de impressão (é adicionado ao final da fila)
    public String enfileiraDocumento(Documento e) {
        if (filaCheia()) return "Capacidade máxima foi atingida";
        Long tempoSolicitacao = System.currentTimeMillis();
        Date data = new Date(tempoSolicitacao);
        e.setHorarioSolicitacao(data);
        documentos[ultimo] = e;
        ultimo = proximaPosicao(ultimo);
        ocupacao++;
        return "Arquivo: "+e.getNomeArquivo()+" foi cadasatrado pelo usuário "+e.getNomeUsuario()+" na data de "+e.getHorarioSolicitacao();
    }

    // O primeiro documento da fila é impresso (removido da frente).
    public String desenfileiraDocumento() {
        if (filaVazia()) return "Fila está vazia";
        Documento aux = documentos[primeiro];
        primeiro = proximaPosicao(primeiro);
        ocupacao--;
        Long horarioImpressao = System.currentTimeMillis();
        Date dataImpressao = new Date(horarioImpressao);
        Date dataSolicitacao = (Date) aux.getHorarioSolicitacao();
        long tempoEspera = dataImpressao.getTime()-dataSolicitacao.getTime();
        return "Horario de impressao: "+dataImpressao+"\nTempo de espera: "+(tempoEspera/1000);
    }

    // O sistema deve permitir consultar se um determinado documento está na fila, sua posição e o horário de solicitação
    public String consultarDocumento(String novo){
        if (filaVazia())
            return "Fila está vazia";
        Long horarioImpressao = System.currentTimeMillis();
        Date dataImpressao = new Date(horarioImpressao);
        for(int i=primeiro, cont = 0; cont < ocupacao; i = proximaPosicao(i), cont++){
            System.out.println(documentos[i]);
            if (novo.equals(documentos[i].getNomeArquivo())){
                System.out.println("Print: "+i+"\n"+documentos[i].getNomeArquivo());
                return "Documento está na fila\nNome: "+documentos[i].getNomeArquivo()+"\nPosição: "+i+"\nHorário de solicitação de impressão: "+dataImpressao;
            }
        }
        return "Documento não está na fila";
    }

    @Override
    public String toString() {
        if (filaVazia())
            return "Fila vazia";
        String s = "";
        for (int i = primeiro, cont = 0; cont < ocupacao; i = proximaPosicao(i), cont++) {
            s = s + documentos[i] + "\n";
        }
        return s;
    }

    public String stringVetor() {
        int i = 0;
        String s = "";
        if (filaVazia())
            for (i = 0; i < documentos.length; i++)
                s = s + "_ ";
        else if (filaCheia())
            for (i = 0; i < documentos.length; i++)
                s = s + documentos[i] + " ";
        else if (primeiro < ultimo) {
            for (i = 0; i < primeiro; i++)
                s = s + "_ ";
            for (i = primeiro; i < ultimo; i++)
                s = s + documentos[i] + " ";
            for (i = ultimo; i < documentos.length; i++)
                s = s + documentos[i] + "_ ";
        } 
        else {
            for (i = 0; i < primeiro; i++)
                s = s + documentos[i] + " ";
            for (i = ultimo; i < primeiro; i++)
                s = s + "_ ";
            for (i = primeiro; i < documentos.length; i++)
                s = s + documentos[i] + " ";
        }
        return s;
    }
}