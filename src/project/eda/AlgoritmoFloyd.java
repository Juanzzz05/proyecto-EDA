
package project.eda;

import java.awt.Color;
import java.util.Arrays;
import static VistaUsuario.Inicio2.jPanel1;

public class AlgoritmoFloyd {
    private DatosGraficos datosGraficos;
    private int tope;
    private int[][] distancias;
    private int[][] predecesores;

    private int origen;
    private int destino;
    private int acumuladoKM;

    // Constructor que recibe DatosGraficos, tope, origen y destino
    public AlgoritmoFloyd(DatosGraficos datosGraficos, int tope, int origen, int destino) {
        this.datosGraficos = datosGraficos;
        this.tope = tope;
        this.origen = origen;
        this.destino = destino;
        this.distancias = new int[tope][tope];
        this.predecesores = new int[tope][tope];
        this.acumuladoKM = 0;
    }

    // Ejecutar el algoritmo de Floyd-Warshall
    public void floydWarshall() {
        for (int k = 0; k < tope; k++) {
            for (int i = 0; i < tope; i++) {
                for (int j = 0; j < tope; j++) {
                    if (distancias[i][j] > distancias[i][k] + distancias[k][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        predecesores[i][j] = k;
                    }
                }
            }
        }
    }

    // Obtener el camino más corto entre dos nodos
    public void mostrarCamino(int inicio, int fin) {
        if (predecesores[inicio][fin] == -1) {
            System.out.println("No hay camino entre los nodos " + inicio + " y " + fin);
            return;
        }
        
        System.out.println("Camino más corto de " + inicio + " a " + fin + ":");
        imprimirCamino(inicio, fin);
    }

    // Método recursivo para imprimir el camino más corto
    private void imprimirCamino(int inicio, int fin) {
        if (inicio == fin) {
            System.out.print(inicio + " ");
        } else if (predecesores[inicio][fin] == -1) {
            System.out.print("No hay camino.");
        } else {
            imprimirCamino(inicio, predecesores[inicio][fin]);
            System.out.print("-> " + fin + " ");
        }
    }

    // Método para pintar el grafo y el camino más corto entre dos nodos
    public void pintarGrafoYCamino(int inicio, int fin) {
        // Primero, pintamos todos los nodos
        for (int i = 0; i < tope; i++) {
            PintarNodos.pinta_Circulo(jPanel1.getGraphics(),
                datosGraficos.getCordeX(i),
                datosGraficos.getCordeY(i),
                String.valueOf(i));  // Pintamos el nodo con su índice
        }

        // Pintamos las líneas (conexiones) entre los nodos
        for (int i = 0; i < tope; i++) {
            for (int j = 0; j < tope; j++) {
                if (distancias[i][j] != 999999 && distancias[i][j] != 0) {
                    PintarNodos.pinta_Linea(jPanel1.getGraphics(),
                        datosGraficos.getCordeX(i),
                        datosGraficos.getCordeY(i),
                        datosGraficos.getCordeX(j),
                        datosGraficos.getCordeY(j),
                        distancias[i][j]);
                }
            }
        }

        // Ahora pintamos el camino más corto de 'inicio' a 'fin'
        if (predecesores[inicio][fin] != -1) {
            int currentNode = fin;
            while (currentNode != inicio) {
                int prevNode = predecesores[inicio][currentNode];
                PintarNodos.pinta_Camino(jPanel1.getGraphics(),
                    datosGraficos.getCordeX(prevNode),
                    datosGraficos.getCordeY(prevNode),
                    datosGraficos.getCordeX(currentNode),
                    datosGraficos.getCordeY(currentNode),
                    Color.RED);  // Pintamos el camino en rojo
                currentNode = prevNode;
            }
        }
    }

    // Obtener la distancia más corta entre dos nodos
    public int getDistancia(int i, int j) {
        calcularAcumulado();
        return distancias[i][j];
    }
      private void calcularAcumulado() {
        
        if (distancias[origen][destino] != Integer.MAX_VALUE) {
            acumuladoKM = distancias[origen][destino]; // El acumulado es simplemente la distancia
        } else {
            acumuladoKM = 0; // Si no hay camino, el acumulado es 0
        }
    }

    public int getAcumuladoKM() {
        return acumuladoKM;
    }
}



