/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimiento;

 

import reclamos.*;
import usuarios.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jefferson
 */
public class Lavados extends javax.swing.JInternalFrame {

    String driver = "org.postgresql.Driver";
    String ruta = "jdbc:postgresql://localhost:5432/AutoCar";
    String user = "postgres";
    String password = "12345"; 
    DefaultTableModel modelo;
  
    /**
     * Creates new form Cliente
     */
    public Lavados() throws ClassNotFoundException, SQLException {
        initComponents();
        cargarTodos();
        tr=new TableRowSorter<>(modelo);
    }
 
    TableRowSorter<TableModel> tr;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lavPlaca = new javax.swing.JTextField();
        lavFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lavDescripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        lavCoste = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cliTabla = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        filter = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);

        jPanel2.setBackground(new java.awt.Color(50, 93, 127));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Agregar lavado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        lavPlaca.setName(""); // NOI18N
        lavPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lavPlacaActionPerformed(evt);
            }
        });
        jPanel1.add(lavPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 270, -1));

        lavFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lavFechaActionPerformed(evt);
            }
        });
        jPanel1.add(lavFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 270, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 43, -1));

        jLabel2.setText("Agregar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel3.setText("Placa");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel6.setText("Descripción");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel7.setText("Fecha");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/deny.png"))); // NOI18N
        jButton8.setText("Cancelar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        lavDescripcion.setColumns(20);
        lavDescripcion.setRows(5);
        jScrollPane2.setViewportView(lavDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 270, 68));

        jLabel8.setText("Coste");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        lavCoste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lavCosteActionPerformed(evt);
            }
        });
        jPanel1.add(lavCoste, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 270, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lavado.png"))); // NOI18N

        cliTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Dirección", "Ciudad", "Correo", "Telefono"
            }
        ));
        cliTabla.setEnabled(false);
        cliTabla.setRowHeight(25);
        cliTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cliTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cliTabla);

        jLabel16.setText("Filtrar");

        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/filter.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("Nuevo", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String filtro=filter.getText();
        if(!filtro.equals("")){

            cliTabla.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(filtro));
        }else{
            tr.setRowFilter(null);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed

    }//GEN-LAST:event_filterActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            tr.setRowFilter(null);
            cargarTodos();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Lavados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cliTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cliTablaMouseClicked

    }//GEN-LAST:event_cliTablaMouseClicked

    private void lavCosteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lavCosteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lavCosteActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        lavPlaca.setText("");
        lavDescripcion.setText("");
        lavFecha.setText("");
        lavCoste.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            guardarLavado(lavPlaca.getText(), lavDescripcion.getText(), lavFecha.getText(),Double.parseDouble(lavCoste.getText()));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lavados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Lavados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lavFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lavFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lavFechaActionPerformed

    private void lavPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lavPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lavPlacaActionPerformed
    public void guardarLavado(String placa, String descripcion, String fecha,double coste) throws ClassNotFoundException, SQLException{
           // Insertar datos a la bd:
           if(existe(fecha,placa)==false){
                try{
               Class.forName(driver);
               Connection conne=(Connection) DriverManager.getConnection(ruta,user,password);
               Statement consulta=(Statement) conne.createStatement();
               consulta.executeUpdate("insert into lavados(placa, descripcion, fecha,coste) values('"+placa+"', '"+descripcion+"', '"+fecha+"',"+coste+")");
               JOptionPane.showMessageDialog(null,"Lavado guardado con éxito");
               lavPlaca.setText("");
               lavDescripcion.setText("");
               lavFecha.setText("");
               lavCoste.setText("");
               conne.close();
               consulta.close();
               
               } catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getErrorCode());

           } catch(ClassNotFoundException e){
               JOptionPane.showMessageDialog(null,"Error inesperado");
       } 
           }else{
               JOptionPane.showMessageDialog(null, "Aviso: Ya existe el registro del lavado");
           }
          
   }
    public boolean existe(String fecha,String placa) throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        String comprobador="";
        Connection conn=(Connection) DriverManager.getConnection(ruta,user,password);
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM lavados WHERE fecha='"+fecha+"'");
            while (rs.next())
            {
                if(placa.equals(rs.getString(2))){
                    comprobador=rs.getString(2);
                }
              
            }
            rs.close();
            st.close();
            conn.close();
            if(!comprobador.equals("")){
                return true;
            }else{
                return false;
            }
         
         }
         
    }
    public void cargarTodos() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        Connection conn=(Connection) DriverManager.getConnection(ruta,user,password);
        String Titulo[]={"Placa","Descripción","Coste","Fecha"};
        String registros[]=new String[4];
        modelo= new DefaultTableModel(null,Titulo);
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM lavados");
            while (rs.next())
            {
                registros[0]=rs.getString(2);
                registros[1]=rs.getString(4);
                registros[2]=rs.getString(5);
                registros[3]=rs.getString(3);
               
                modelo.addRow(registros);
            }
            cliTabla.setModel(modelo);
            rs.close();
            st.close();
            conn.close();
        }
        
    }
   

     public void eliminarReclamo(String cedula) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conn=(Connection) DriverManager.getConnection(ruta,user,password);
         String SQL = "DELETE FROM reclamos WHERE cedula = ?";
        try (Connection con = conn;
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
 
            pstmt.setString(1, cedula);
            int n = pstmt.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null,"Eliminación exitosa");
            }else{
                JOptionPane.showMessageDialog(null,"Error: Reclamo inexistente");
            }
            conn.close();
            con.close();
            pstmt.close();
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Reclamo inexistente");
      
    
        }
     }
       
         
    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cliTabla;
    private javax.swing.JTextField filter;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lavCoste;
    private javax.swing.JTextArea lavDescripcion;
    private javax.swing.JTextField lavFecha;
    private javax.swing.JTextField lavPlaca;
    // End of variables declaration//GEN-END:variables
}
