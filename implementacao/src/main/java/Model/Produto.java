/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Cairo
 */
public class Produto {

    private int id;
    private String nome;
    private String status;
    private Double sequencial;
    private Double codbarras;
    private String TipoProduto;
    private String Caracteristicas;
    private int quantidade;

    public Produto() {
        this.id = 0;
        this.nome = "";
        this.status = "";
        this.sequencial = 0.0;
        this.codbarras = 0.0;
        this.TipoProduto = "";
        this.Caracteristicas = "";
        this.quantidade = 0;
    }

    public Produto(int codProduto) {
        this.id = 0;
        this.nome = "";
        this.status = "";
        this.sequencial = 0.0;
        this.codbarras = 0.0;
        this.TipoProduto = "";
        this.Caracteristicas = "";
        this.quantidade = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getSequencial() {
        return sequencial;
    }

    public void setSequencial(Double sequencial) {
        this.sequencial = sequencial;
    }

    public Double getCodbarras() {
        return codbarras;
    }

    public void setCodbarras(Double codbarras) {
        this.codbarras = codbarras;
    }

    public String getTipoProduto() {
        return TipoProduto;
    }

    public void setTipoProduto(String TipoProduto) {
        this.TipoProduto = TipoProduto;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String Caracteristicas) {
        this.Caracteristicas = Caracteristicas;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Produto) {
            Produto p = (Produto) o;
            if (p.getId()== this.getId()) {
                return true;
            }
        }
        return false;
    }
}

