/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaUsuario;

import project.eda.DatosGraficos;
import project.eda.PintarNodos;
import static VistaUsuario.Inicio2.jPanel1;
import java.awt.Color;

public class MostrarDibujos {
    private int tope = 0; // lleva el # de nodos creados
    private int nodoFin;
    private int permanente;
    int n = 0, nn = 0, id, id2; // controla que se haya dado click sobre un nodo
    private int aristaMayor;
    DatosGraficos arboles = new DatosGraficos();

    // Repintar todo el grafo
    public static void R_repaint(int tope, DatosGraficos arboles) {
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                if (arboles.getmAdyacencia(j, k) == 1)
                    PintarNodos.pinta_Linea(jPanel1.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), arboles.getCordeX(k), arboles.getCordeY(k), arboles.getmCoeficiente(j, k));
            }
        }
        for (int j = 0; j < tope; j++)
            PintarNodos.pinta_Circulo(jPanel1.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), String.valueOf(arboles.getNombre(j)));
    }

    // Método para pintar el resultado del algoritmo de Floyd-Warshall
    public static void pintarCaminoFloyd(int tope, DatosGraficos arboles, double[][] distancias, int[][] predecesores, int origen, int destino) {
        int nodoActual = destino;
        while (nodoActual != origen) {
            int nodoPredecesor = predecesores[origen][nodoActual];
            PintarNodos.pinta_Camino(jPanel1.getGraphics(),
                    arboles.getCordeX(nodoActual), arboles.getCordeY(nodoActual),
                    arboles.getCordeX(nodoPredecesor), arboles.getCordeY(nodoPredecesor), Color.RED);
            nodoActual = nodoPredecesor;
        }
        // Resalta el nodo destino
        PintarNodos.seleccionNodo(jPanel1.getGraphics(),
                arboles.getCordeX(destino), arboles.getCordeY(destino), null, Color.RED);
    }

    // Método para actualizar el grafo visual después de ejecutar Floyd-Warshall
    public void ejecutarFloyd() {
        // Aquí puedes ejecutar tu algoritmo de Floyd-Warshall y obtener los resultados
        double[][] distancias = new double[tope][tope];
        int[][] predecesores = new int[tope][tope];

        // Llamamos a Floyd-Warshall (asegurándonos de que el algoritmo calcule distancias y predecesores)
        floydWarshall(distancias, predecesores);

        // Repintar el grafo con los caminos más cortos
        R_repaint(tope, arboles);

        // Pintar el camino más corto de origen a destino
        pintarCaminoFloyd(tope, arboles, distancias, predecesores, permanente, nodoFin);
    }

    // Implementación de Floyd-Warshall para obtener distancias y predecesores
    private void floydWarshall(double[][] distancias, int[][] predecesores) {
        // Inicialización de las distancias y predecesores
        for (int i = 0; i < tope; i++) {
            for (int j = 0; j < tope; j++) {
                if (i == j) {
                    distancias[i][j] = 0;
                    predecesores[i][j] = -1;
                } else if (arboles.getmAdyacencia(i, j) == 1) {
                    distancias[i][j] = arboles.getmCoeficiente(i, j);
                    predecesores[i][j] = i;
                } else {
                    distancias[i][j] = Double.MAX_VALUE;
                    predecesores[i][j] = -1;
                }
            }
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < tope; k++) {
            for (int i = 0; i < tope; i++) {
                for (int j = 0; j < tope; j++) {
                    if (distancias[i][j] > distancias[i][k] + distancias[k][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        predecesores[i][j] = predecesores[k][j];
                    }
                }
            }
        }
    }
}

