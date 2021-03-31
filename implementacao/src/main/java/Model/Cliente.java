/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Cairo
 */
public class Cliente {
    
    private int idcliente;
    private String nome;
    private String cpf_cnpj;
    private String endereco;
    
//Contructor
    public Cliente() {
        this.idcliente = 0;
        this.nome = "";
        this.cpf_cnpj = "";
        this.endereco="";
    }
//Gets and setters

    public int getIdcliente() {
        return idcliente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public String getEndereco() {
        return endereco;
    }
    

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    }

