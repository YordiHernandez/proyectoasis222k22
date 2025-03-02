import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class BuscarJug extends javax.swing.JFrame {

    /**
     * Creates new form BuscarJug
     */
    public BuscarJug() {
        initComponents();
       this.setLocationRelativeTo(null);
        
    }

    void mostrardatos(String valor) throws IOException{
        conectar cc=new conectar();
        Connection cn=cc.conexion();
        DefaultTableModel modelo=new DefaultTableModel();
       
        modelo.addColumn("Id_Jugador");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Año_Nacimiento");
        modelo.addColumn("Numero_Camisola");
        modelo.addColumn("Equipo");
          
        jTable2.setModel(modelo);
        String sql="";
        if (valor.equals(""))
        {
            //sql = "select * from jugador";
           sql="SELECT jugador.Id_Jugador,jugador.Nombre,jugador.Apellido,jugador.Año_Nacimiento,jugador.Numero_Camisola,equipos.Nombre, jugador.Foto FROM jugador INNER JOIN equipos USING(Id_Equipo)";
        }
        else{
            sql="SELECT jugador.Id_Jugador,jugador.Nombre,jugador.Apellido,jugador.Año_Nacimiento,jugador.Numero_Camisola,equipos.Nombre, jugador.Foto FROM jugador INNER JOIN equipos USING(Id_Equipo) WHERE (Id_Jugador='"+valor+"'  OR Nombre='"+valor+"')";
        }  
        
        String []datos=new String [6];
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
            datos[5]=rs.getString(6);
            
            modelo.addRow(datos);
            Blob fotos = rs.getBlob(7);
            byte []recuperar = fotos.getBytes(1, (int )fotos.length());
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(recuperar));

            lbfoto.setIcon(new ImageIcon(img));
            }
            jTable2.setModel(modelo);
        }catch(SQLException ex){
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    
    
    
    void mostrar(String valor) throws IOException{
        conectar cc=new conectar();
        Connection cn=cc.conexion();
        DefaultTableModel modelo=new DefaultTableModel();
       
        modelo.addColumn("Id_Jugador");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Año_Nacimiento");
        modelo.addColumn("Numero_Camisola");
        modelo.addColumn("Equipo");
          
        jTable1.setModel(modelo);
        String sql="";
        if (valor.equals(""))
        {
            //sql = "select * from jugador";
           sql="SELECT jugador.Id_Jugador,jugador.Nombre,jugador.Apellido,jugador.Año_Nacimiento,jugador.Numero_Camisola,equipos.Nombre FROM jugador INNER JOIN equipos USING(Id_Equipo)";
        }
        else{
            sql="SELECT * FROM jugador WHERE (Id_Jugador='"+valor+"'  OR Nombre='"+valor+"')";
        }  
        
        String []datos=new String [6];
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
            datos[5]=rs.getString(6);
            
            modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
        }catch(SQLException ex){
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        btmostrar = new javax.swing.JButton();
        btbuscar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbfoto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 3, 36)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/36535849-jugador-de-fútbol-de-dibujos-animados.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(153, 153, 0));
        jButton6.setText("?");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton6))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Informal Roman", 1, 36)); // NOI18N
        jLabel1.setText("BUSCAR JUGADOR");

        lbfecha.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N

        btmostrar.setText("Mostrar");
        btmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmostrarActionPerformed(evt);
            }
        });

        btbuscar.setText("Buscar");
        btbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbuscarActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(lbfecha)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btmostrar)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btbuscar)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 82, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btmostrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btbuscar))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JOptionPane.showMessageDialog(null," En este Menú se podrán mostrar todos los jugadores y los que se insertan en el campo especifico.");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmostrarActionPerformed

        try {
            mostrar("");
        } catch (IOException ex) {
            Logger.getLogger(BuscarJug.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btmostrarActionPerformed

    private void btbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbuscarActionPerformed
        try {
            mostrardatos(jTextField1.getText());
        } catch (IOException ex) {
            Logger.getLogger(BuscarJug.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btbuscarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarJug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarJug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarJug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarJug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarJug().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbuscar;
    private javax.swing.JButton btmostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbfoto;
    // End of variables declaration//GEN-END:variables

    
}
