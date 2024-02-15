package br.com.ecommerce.school.pedidosms.dto.consultarPedido;

public class ClienteDTO {
    private String codigo;
    private String primeiroNome;
    private String ultimoNome;
    private String email;

    public ClienteDTO(String codigo, String primeiroNome, String ultimoNome, String email) {
        this.codigo = codigo;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public String getEmail() {
        return email;
    }
}
