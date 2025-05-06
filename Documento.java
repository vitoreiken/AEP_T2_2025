import java.util.Date;

public class Documento{
    private String nomeArquivo;
    private String nomeUsuario;
    private Date horarioSolicitacao;

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
    public Date getHorarioSolicitacao() {
        return horarioSolicitacao;
    }
    public void setHorarioSolicitacao(Date horarioSolicitacao) {
        this.horarioSolicitacao = horarioSolicitacao;
    }   
}