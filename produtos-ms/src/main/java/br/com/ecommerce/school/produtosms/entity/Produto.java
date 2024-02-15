package br.com.ecommerce.school.produtosms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    private String codigo = UUID.randomUUID().toString();;

    private String descricao;

    private BigDecimal valor;

    @Min(0)
    private BigDecimal quantidade;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void calcularEstoque(BigDecimal valor){
        if(this.getQuantidade().equals(BigDecimal.ZERO)){
            this.quantidade = this.getQuantidade();
        }else{
            this.quantidade = this.getQuantidade().subtract(valor);
        }
    }
}
