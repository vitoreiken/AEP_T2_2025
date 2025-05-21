public class Documento{
    private String nomeArquivo;
    private String nomeUsuario;
    private Object horarioSolicitacao;
    
    // Construtor
    public Documento(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    public Documento(String nomeArquivo, String nomeUsuario){
        this.nomeArquivo = nomeArquivo;
        this.nomeUsuario = nomeUsuario;
    }

    public Documento(String nomeArquivo, String nomeUsuario, Object horarioSolicitacao){
        this.nomeArquivo = nomeArquivo;
        this.nomeUsuario = nomeUsuario;
        this.horarioSolicitacao = horarioSolicitacao;
    } 

    // Getters e Setters
    public String getNomeArquivo() {
        return nomeArquivo;
    }
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public Object getHorarioSolicitacao() {
        return horarioSolicitacao;
    }
    public void setHorarioSolicitacao(Object horarioSolicitacao) {
        this.horarioSolicitacao = horarioSolicitacao;
    }
    

    @Override
    public String toString() {
        return "Nome do arquivo = " + nomeArquivo + ", nome do usuário = " + nomeUsuario + ", data = "+ getHorarioSolicitacao();
    }

}