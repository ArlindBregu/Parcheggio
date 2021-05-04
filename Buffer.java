/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

/**
 *
 * @author arlin
 */
public class Buffer {
    
    private int[] buffer;
    private int conta;
    private int metti;
    private int togli;
    private int DIM_BUFFER = 10;

    public Buffer() {
        
        this.buffer = new int[DIM_BUFFER];
        this.conta = 0;
        this.metti = 0;
        this.togli = 0;
        
    }
    
    public synchronized void deposita(int dato) throws InterruptedException{
    
        while(conta == DIM_BUFFER)
            this.wait();
        
        this.buffer[metti] = dato;
        metti = (metti +1) % DIM_BUFFER;
        
        conta++;
        this.notify();
    }
    
    public synchronized void preleva() throws InterruptedException{
    
        while(conta == 0)
            this.wait();
        
        int dato;
        dato = this.buffer[togli];
        togli = (togli + 1) % DIM_BUFFER;
        
        conta--;
        this.notify();
    }
    
    
}
