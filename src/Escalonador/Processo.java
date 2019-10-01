/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

/**
 *
 * @author Admin
 */
public class Processo {

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    @Override
    public String toString(){
        return "Processo [id=" +id + ", prioridade=" +prioridade + ", tempo=" +tempo+ "]";
    }
    
   private String id;
   private int prioridade;
   private int tempo;
}
