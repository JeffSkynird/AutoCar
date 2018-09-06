/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;


public class Tabla{
    Object[][]m;
    public Object[][] obtenerClientes() throws SQLException{
        m = Conexion.leerDatosBD(); 
        return m;
   }
    public void ver_tabla(JTable tabla) throws SQLException{
        obtenerClientes();
        tabla.setDefaultRenderer(Object.class, new Render());
        
        JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
        
        for(int i=0;i<=m.length;i++){
            m[i][6] = btn1;
            m[i][7] = btn2;
        }
        DefaultTableModel d = new DefaultTableModel
        (
                m,
                new Object[]{"Cédula","Nombre","Dirección","Correo","Telefono","Ciudad","M","E"}
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        tabla.setModel(d);
        
        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());
  

    }
}
