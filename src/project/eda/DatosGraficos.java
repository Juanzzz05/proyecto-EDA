
package project.eda;


public class DatosGraficos {
   

    private final double MatrizCoeficiente[][] = new double[51][51];
    private final int MatrizAdyacencia[][] = new int[51][51];
    private final int cordenadaX[] = new int[51];
    private final int cordenadaY[] = new int[51];
    private final String nombre[] = new String[51];
    private int visitado[]; // Cambiado de enArbol a visitado

  
    public DatosGraficos() {

    }

    public double getmCoeficiente(int i, int j) {
        return MatrizCoeficiente[i][j];
    }

    public int getmAdyacencia(int i, int j) {
        return MatrizAdyacencia[i][j];
    }

    public int getCordeX(int i) {
        return cordenadaX[i];
    }

    public int getCordeY(int i) {
        return cordenadaY[i];
    }

    public String getNombre(int i) {
        return nombre[i];
    }

    public int getVisitado(int i) {  // Cambiado de getEnArbol
        return visitado[i];
    }

    public void setmCoeficiente(int i, int j, double mCoeficiente) {
        this.MatrizCoeficiente[i][j] = mCoeficiente;
    }

    public void setmAdyacencia(int i, int j, int mAdyacencia) {
        this.MatrizAdyacencia[i][j] = mAdyacencia;
    }

    public void setCordeX(int i, int cordeX) {
        this.cordenadaX[i] = cordeX;
    }

    public void setCordeY(int i, int cordeY) {
        this.cordenadaY[i] = cordeY;
    }

    public void setNombre(int i, String nombre) {
        this.nombre[i] = nombre;
    }

    public void setVisitado(int i, int enArbol) {  // Cambiado de setEnArbol
        this.visitado[i] = enArbol;
    }

    public void crearVisitado(int i) {  // Cambiado de crearEnArbol
        visitado = new int[i];
    }
} 

