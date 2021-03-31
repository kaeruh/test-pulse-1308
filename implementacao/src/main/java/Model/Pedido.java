/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cairo
 */
public class Pedido {
    private int codigo;
    private Cliente cliente;
    private Date dataVenda;
    private Double valorTotal;
    private status situacao;
    private List<ItemPedido> itens;
    private List<ItemPedido> itensRemover;
    
    public Pedido() {
        this.codigo = 0;
        this.cliente = new Cliente();
        this.dataVenda = new Date();
        this.valorTotal = 0.0;
        this.itens = new ArrayList<>();
        this.itensRemover = new ArrayList<>();
    }

    public Pedido (int codigo) {
        this.codigo = codigo;
        this.cliente = new Cliente();
        this.dataVenda = new Date();
        this.valorTotal = 0.0;
        this.itens = new ArrayList<>();
        this.itensRemover = new ArrayList<>();
}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public status getSituacao() {
        return situacao;
    }

    public void setSituacao(status situacao) {
        this.situacao = situacao;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public List<ItemPedido> getItensRemover() {
        return itensRemover;
    }

    public void setItensRemover(List<ItemPedido> itensRemover) {
        this.itensRemover = itensRemover;
    }
    
}
