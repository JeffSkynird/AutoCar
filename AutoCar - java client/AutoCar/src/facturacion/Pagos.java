/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jefferson
 */
public class Pagos extends javax.swing.JInternalFrame {

    String driver = "org.postgresql.Driver";
    String ruta = "jdbc:postgresql://localhost:5432/AutoCar";
    String user = "postgres";
    String password = "12345"; 
    DefaultTableModel modelo;
    TableRowSorter<TableModel> tr;
    /**
     * Creates new form Pagos
     */
    public Pagos() throws ClassNotFoundException, SQLException {
        initComponents();
         cargarTodos();
        tr=new TableRowSorter<>(modelo);
        cargarFechaActual();
    }
public void cargarFechaActual(){
    Calendar c = new GregorianCalendar();
    String dia = Integer.toString(c.get(Calendar.DATE));
    String mes = Integer.toString(c.get(Calendar.MONTH));
    String annio = Integer.toString(c.get(Calendar.YEAR));
    fecha.setText(annio+"/"+mes+"/"+dia);
    
   
}
public boolean calculoFecha(String fecha1) throws ParseException{
  JOptionPane.showMessageDialog(null, diasDiferencia(fecha1));
    if(diasDiferencia(fecha1)>=30){
       return true;
    }else{
        return false;
    }
  }
    
public int diasDiferencia(String fechaIni) throws ParseException{
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
 
        Date fechaInicial=dateFormat.parse(fechaIni);
        Date fechaFinal=dateFormat.parse(fecha.getText());
 
        int diferencia=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/1000);
 
        int dias=0;
     
        if(diferencia>86400) {
            dias=(int)Math.floor(diferencia/86400);
            diferencia=diferencia-(dias*86400);
        }
        return dias;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cedulaPago = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pagoNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pagoDepartamento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pagoExtra = new javax.swing.JSpinner();
        pagoRol = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        filter = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cliTabla = new javax.swing.JTable();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Cédula:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baseline_monetization_on_black_18dp.png"))); // NOI18N
        jButton1.setText("PAGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nombre");

        pagoNombre.setEditable(false);

        jLabel5.setText("Rol");

        jLabel4.setText("Departamento");

        pagoDepartamento.setEditable(false);

        jLabel7.setText("Extra");

        pagoExtra.setEnabled(false);

        pagoRol.setEditable(true);
        pagoRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Secretario", "Jefe de sistemas", "Empleado de sistemas", "Administrador de base de datos", "Vendedor", "Contador" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(50, 50, 50)
                        .addComponent(pagoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(pagoRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pagoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pagoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pagoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pagoRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pagoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Fecha");

        fecha.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cedulaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cedulaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(94, 94, 94)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrar", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Consultar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed

    }//GEN-LAST:event_filterActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
//        String filtro=filter.getText();
//        if(!filtro.equals("")){
//
//            cliTabla.setRowSorter(tr);
//            tr.setRowFilter(RowFilter.regexFilter(filtro));
//        }else{
//            tr.setRowFilter(null);
//        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            tr.setRowFilter(null);
            cargarTodos();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Contratos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cliTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cliTablaMouseClicked

    }//GEN-LAST:event_cliTablaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(!cedulaPago.getText().equals("")){
         
           try {
               buscar(cedulaPago.getText());
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
           }
          
        }else{
            JOptionPane.showMessageDialog(null,"AVISO: Ingrese una cédula");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            pagar(cedulaPago.getText());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
 public void guardarPago(String cedula,double monto, String fechaG) throws ClassNotFoundException, SQLException{
                    double extra=0;
                    try{
                       Class.forName(driver);
                       Connection conne=(Connection) DriverManager.getConnection(ruta,user,password);
                       Statement consulta=(Statement) conne.createStatement();
                       if(Double.parseDouble(pagoExtra.getValue().toString())>=0){
                           extra=Double.parseDouble(pagoExtra.getValue().toString());
                       
                       }else{
                           extra=0;
                       }
                       consulta.executeUpdate("insert into pagos(cedula, pago,fecha,ultimo) values('"+cedula+"', "+(monto+extra)+", '"+fechaG+"',"+1+" )");
                        JOptionPane.showMessageDialog(null,"Pago guardado con éxito");
                        pagoNombre.setText("");
                        pagoDepartamento.setText("");
                        pagoExtra.setValue(0);
                    } catch(SQLException e){
                       JOptionPane.showMessageDialog(null,"Error desconocido. Contácte con administrador");

                   } catch(ClassNotFoundException e){
                       JOptionPane.showMessageDialog(null,"Error inesperado");
                } 
                                 
}
     
   
    public void pagar(String cedula) throws ClassNotFoundException, SQLException, ParseException{
    Class.forName(driver);
        Connection conn=(Connection) DriverManager.getConnection(ruta,user,password);
        String comprobador="";
        String fechaUltima="";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM pagos WHERE cedula='"+cedula+"'");
            while (rs.next())
            {
              comprobador=rs.getString(1);
              fechaUltima=rs.getString(4);
            }
             if(calculoFecha(fechaUltima)==true){
                  guardarPago(cedula, obtenerSueldo(cedulaPago.getText()), fecha.getText());
              }else{
                  JOptionPane.showMessageDialog(null, "Error: Ya existe un pago en este mes del usuario.");
              }
            
            rs.close();
            st.close();
            conn.close();
        }
}
public double obtenerSueldo(String cedula) throws ClassNotFoundException, SQLException{
    Class.forName(driver);
        Connection conn=(Connection) DriverManager.getConnection(ruta,user,password);
        String comprobador="";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE cedula='"+cedula+"'");
            while (rs.next())
            {
             if(rs.getString(5).equals("Secretario")){
                 return 375;
             }else if(rs.getString(5).equals("Jefe de sistemas")){
                return 1200;
             }else if(rs.getString(5).equals("Empleado de sistemas")){
              return 500;  
            }else if(rs.getString(5).equals("Administrador de base de datos")){
                return 1000;
            }else if(rs.getString(5).equals("Vendedor")){
                return 375;
            }else if(rs.getString(5).equals("Contador")){
                return 800;
            }
            }
             
            rs.close();
            st.close();
            conn.close();
        }
        return 0.0;
}
 public void cargarTodos() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        Connection conn=(Connection) DriverManager.getConnection(ruta,user,password);
        String Titulo[]={"Cédula","Nombre","Rol","Departamento","Monto","Fecha"};
        String registros[]=new String[6];
        modelo= new DefaultTableModel(null,Titulo);
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM pagos");
            while (rs.next())
            {
               String []datos=datosUsuario(rs.getString(2));
                     
                registros[0]=rs.getString(2);
                registros[1]=datos[0];
                registros[2]=datos[1];
                registros[3]=datos[2];
                registros[4]=rs.getString(3);
                registros[5]=rs.getString(4);
              
                modelo.addRow(registros);
            }
            cliTabla.setModel(modelo);
            rs.close();
            st.close();
            conn.close();
        }
        
    }
 public String[]datosUsuario(String cedula) throws ClassNotFoundException, SQLException{
     String datosTempo[]=new String[3]; 
     Class.forName(driver);
        Connection conn=(Connection) DriverManager.getConnection(ruta,user,password);
      
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE cedula='"+cedula+"'");
            while (rs.next())
            {
                datosTempo[0]=rs.getString(2);
                datosTempo[1]=rs.getString(5);
                datosTempo[2]=rs.getString(8);
            }
            
            rs.close();
            st.close();
            conn.close();
            return datosTempo;
        }
 }
  public void buscar(String cedula) throws ClassNotFoundException, SQLException{
        Class.forName(driver);
     
        String nombre="";
        String rol="";
        String departamento="";
        Connection conn=(Connection) DriverManager.getConnection(ruta,user,password);
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE cedula='"+cedula+"'");
            while (rs.next())
            {
              
                nombre=rs.getString(2);
                rol=rs.getString(5);
                departamento=rs.getString(8);
              
            }
            cliTabla.setModel(modelo);
            rs.close();
            st.close();
            if(!nombre.equals("")){
                 pagoNombre.setText(nombre);
                 if(rol.equals("Secretario")){
                    pagoRol.setSelectedIndex(0);
                }else if(rol.equals("Jefe de sistemas")){
                     pagoRol.setSelectedIndex(1);
                }else if(rol.equals("Empleado de sistemas")){
                     pagoRol.setSelectedIndex(2);
                }else if(rol.equals("Administrador de base de datos")){
                     pagoRol.setSelectedIndex(3);
                }else if(rol.equals("Vendedor")){
                     pagoRol.setSelectedIndex(4);
                }else if(rol.equals("Contador")){
                     pagoRol.setSelectedIndex(5);
                }
                
                pagoDepartamento.setText(departamento);
               pagoExtra.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null,"Aviso: No se encontró un usuario con esa cédula");
            }
            conn.clearWarnings();
            conn.close();
            
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cedulaPago;
    private javax.swing.JTable cliTabla;
    private javax.swing.JLabel fecha;
    private javax.swing.JTextField filter;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField pagoDepartamento;
    private javax.swing.JSpinner pagoExtra;
    private javax.swing.JTextField pagoNombre;
    private javax.swing.JComboBox<String> pagoRol;
    // End of variables declaration//GEN-END:variables
}
