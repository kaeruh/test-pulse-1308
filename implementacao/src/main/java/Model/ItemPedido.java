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
public class ItemPedido {
    
    
    private int codigo;
    private Pedido pedido;
    private Produto produto;
    private int quantidade;
    private Double valorUnitario;

    public ItemPedido() {
        this.codigo = 0;
        this.pedido = new pedido();
        this.produto = new Produto();
        this.quantidade = 0;
        this.valorUnitario = 0.0;
    }

    public ItemPedido(int codigo) {
        this.codigo = codigo;
        this.pedido = new pedido();
        this.produto = new Produto();
        this.quantidade = 0;
        this.valorUnitario = 0.0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
