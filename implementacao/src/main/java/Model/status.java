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
public class status {
    
    public enum Tipostatus {

    ATIVO(1, "Ativo"),

    PROCESSADO(2, "Processado"),

    CANCELADA(3, "Cancelada");

    private final int ID;
    private final String DESCRICAO;

    private Tipostatus(int id, String descricao) {
        this.ID = id;
        this.DESCRICAO = descricao;
    }

  
    public int getId() {
        return ID;
    }

    @Override
    public String toString() {
        return this.DESCRICAO;
    }
  }
}
    

