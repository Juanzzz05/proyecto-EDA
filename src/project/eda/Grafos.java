/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.eda;

/**
 *
 * @author Lenovo
 */
public class Grafos {
     private int Q, A, peso;
    private int matrizAdyacencia[][];
    
    public Grafos(int nodos){
    this.Q=nodos;
    this.A=0;
    this.matrizAdyacencia=new int[nodos][nodos];
    }
    
    public void agregarArista(int u, int v,int peso){
    matrizAdyacencia[u][v]=peso;
    matrizAdyacencia[v][u]=peso;//Para no dirijidos
    A++;
    }

    public void imprimirGrafo(){
    for(int i=0;i<Q;i++){
        System.out.println("Fila "+i+" :");    
        for(int k=0;k<Q;k++){
        System.out.println(matrizAdyacencia[i][k]+"");    
        }
        System.out.println("");
    }
    }

    public int getQ() {
        return Q;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }
    
}
