package br.com.ecommerce.school.clientems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String codigo = UUID.randomUUID().toString();
    private String primeiroNome;
    private String ultimoNome;
    private String email;

    @Enumerated(value = EnumType.STRING)
    private EStatusCliente status;

    public Cliente() {
    }

    public Cliente(String codigo, String primeiroNome, String ultimoNome, String email, EStatusCliente status) {
        this.codigo = codigo;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.status = status;
    }

    public Cliente(String primeiroNome, String ultimoNome, String email, EStatusCliente status) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.status = status;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
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

    public void setStatus(EStatusCliente status) {
        this.status = status;
    }
}
