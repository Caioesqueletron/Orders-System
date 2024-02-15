package br.com.ecommerce.school.pedidosms.dto;

public class ClienteDTO {

    private String codigo;
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private EStatusCliente status;

    public ClienteDTO() {
    }

    public ClienteDTO(String codigo, String primeiroNome, String ultimoNome, String email, EStatusCliente status) {
        this.codigo = codigo;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.status = status;
    }

    public ClienteDTO(String primeiroNome, String ultimoNome, String email, EStatusCliente status) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.status = status;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EStatusCliente getStatus() {
        return status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setStatus(EStatusCliente status) {
        this.status = status;
    }
}
