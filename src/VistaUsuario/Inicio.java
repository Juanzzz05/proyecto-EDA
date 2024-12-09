package VistaUsuario;


public class Inicio extends javax.swing.JFrame {

        public Inicio() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_principal = new javax.swing.JPanel();
        Porcentaje = new javax.swing.JLabel();
        Titulo_principal = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();
        Lema = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Panel_principal.setBackground(new java.awt.Color(59, 34, 128));

        Porcentaje.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        Porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        Porcentaje.setText("%");
        Porcentaje.setName("Percent"); // NOI18N

        Titulo_principal.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        Titulo_principal.setForeground(new java.awt.Color(255, 255, 255));
        Titulo_principal.setText("BIENVENIDO AL PROTORIPO CLOBI");

        ProgressBar.setForeground(new java.awt.Color(204, 204, 204));

        Lema.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        Lema.setForeground(new java.awt.Color(255, 255, 255));
        Lema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lema.setText("LA MEJOR MANERA DE TRANSPORTARSE");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovi.png"))); // NOI18N

        javax.swing.GroupLayout Panel_principalLayout = new javax.swing.GroupLayout(Panel_principal);
        Panel_principal.setLayout(Panel_principalLayout);
        Panel_principalLayout.setHorizontalGroup(
            Panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Panel_principalLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(Panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Titulo_principal)
                    .addGroup(Panel_principalLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_principalLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1))
                    .addGroup(Panel_principalLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(Porcentaje))
                    .addGroup(Panel_principalLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(Lema)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        Panel_principalLayout.setVerticalGroup(
            Panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_principalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Titulo_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lema, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(Porcentaje)
                .addGap(11, 11, 11)
                .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Titulo_principal.getAccessibleContext().setAccessibleParent(null);
        Lema.getAccessibleContext().setAccessibleParent(null);
        jLabel2.getAccessibleContext().setAccessibleParent(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Panel_principal.getAccessibleContext().setAccessibleParent(null);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
    // Crear la instancia de la pantalla de inicio
    Inicio Mysplash = new Inicio();

    // Ejecutar la pantalla en el hilo de eventos de Swing
    java.awt.EventQueue.invokeLater(() -> {
        Mysplash.setVisible(true);
    });

    // Crear un hilo para actualizar la barra de progreso
    Thread progressThread = new Thread(() -> {
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(20);  // Simula una carga
                Mysplash.ProgressBar.setValue(i);  // Actualiza la barra de progreso
                Mysplash.Porcentaje.setText(Integer.toString(i) + "%");  // Actualiza el porcentaje
            }
        } catch (InterruptedException e) {
            e.printStackTrace();  // Muestra el error si ocurre una excepción
        }

        // Una vez que la carga termine, inicia la siguiente ventana
        new Inicio2().setVisible(true);
        Mysplash.dispose();  // Cierra la ventana de inicio
    });

    // Inicia el hilo de progreso
    progressThread.start();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lema;
    private javax.swing.JPanel Panel_principal;
    private javax.swing.JLabel Porcentaje;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel Titulo_principal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
