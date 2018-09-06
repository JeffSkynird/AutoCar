/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 * CLASE PARA CONECTARSE A UNA BASE DE DATOS POSTEGRES, INSERTAR Y RECUPERAR IMAGENES JPG
 */
public class Postgresql {

   //DATOS PARA LA CONEXION
   private String bd = "AutoCar";
   private String user = "postgres";
   private String password = "12345";
 String url = "jdbc:postgresql://localhost:5432/AutoCar";

   private Connection connection = null;
   private ResultSet resultSet = null;
   private Statement statement = null;

    //Constructor de clase que se conecta a la base de datoS
    public Postgresql()
    {
      try{
         Class.forName("org.postgresql.Driver");         
         connection = DriverManager.getConnection(url, user , password);
         System.out.println("Conectado a la base de datos [ " + this.bd + "]");
      }catch(Exception e){
         System.err.println(e.getMessage());
      }
    }

    /* metodo que guarda una imagen JPG en la base de datos
 * input: ID : identificador unico para el registro, osea primary key
 * name: nombre de la imagen para reconocerlo mas adelante
 * ruta: direccion absoluta de la imagen JPG
 */
    public boolean guardarfoto(String placa, String modelo, String marca,Integer anio, String chasis, String motor, Integer kilometraje, Double costo,String transmision, String ruta) throws IOException {
        FileInputStream fis = null;
        try {
             File file = new File(ruta);
             fis = new FileInputStream(file);
             BufferedImage  imagen = ImageIO.read(file);
             File outputfile = new File("C:\\Express_Backend\\public\\images\\"+placa+".png");
             ImageIO.write(imagen, "png", outputfile);
             PreparedStatement pstm = connection.prepareStatement("INSERT into " +
                        " autos(modelo, marca, anio,placa, chasis,motor,kilometraje,token,costo,transmision,archivo) " + " VALUES(?,?,?,?,?,?,?,?,?,?,?)");
             pstm.setString(1, modelo);
             pstm.setString(2, marca);
             pstm.setInt(3, anio);
             pstm.setString(4, placa);
             pstm.setString(5, chasis);
             pstm.setString(6, motor);
             pstm.setDouble(7, kilometraje);
             pstm.setInt(8, 0);
             pstm.setDouble(9, costo);
             pstm.setString(10, transmision);
             pstm.setBinaryStream(11, fis,(int) file.length());
          
             pstm.execute();
             pstm.close();
             return true;
        } catch (FileNotFoundException e) {
             System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
               fis.close();
             } catch (IOException e) {
               System.out.println(e.getMessage());
             }
        }
        return false;
   }

    /* Metodo que convierte una cadena de bytes en una imagen JPG
 * input:
 * bytes: array que contiene los binarios de la imagen
 * Output: la foto JPG en formato IMAGE
 */
 private Image ConvertirImagen(byte[] bytes) throws IOException {
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");    
    ImageReader reader = (ImageReader) readers.next();
    Object source = bis;
    ImageInputStream iis = ImageIO.createImageInputStream(source);
    reader.setInput(iis, true);
    ImageReadParam param = reader.getDefaultReadParam();
    return reader.read(0, param);
 }

 /* Metodo que extrae los registros de la tabla IMAGEN de la base de datos
 * crea instancia nueva de la clase imagen.java y añade los datos
 * agrega estos datos a un DefaultListModel
 * output:
 * dml: Es un DefaultListModel que contiene instancia de la clase imagen.java
 */
    public DefaultListModel Lista_Imagenes()
    {
        DefaultListModel dml = new DefaultListModel();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id,placa,archivo FROM autos " );
          while (resultSet.next())
          {  //se crea un objeto CITA y se le van agregando los datos
             Imagen img = new Imagen();
             img.setId( resultSet.getString("id") ) ;
             img.setName( resultSet.getString("placa") ) ;
             try { //antes de agregar el campo imagen, realiza la conversion de bytes a JPG
                 img.setArchivo(ConvertirImagen(resultSet.getBytes("archivo")));
             } catch (IOException ex) {
                System.err.println(ex.getMessage());
             }
             //por ultimo añade el objeto imagen:img al DefaultListModel
            dml.addElement(img);
          }
       }
       catch (SQLException ex) {
          System.err.println(ex.getMessage());
       }
       return dml;
    }
      public Imagen cargarImagen(String placa)
    {
         Imagen img = new Imagen();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT archivo FROM autos WHERE placa='"+placa+"'" );
          while (resultSet.next())
          {  //se crea un objeto CITA y se le van agregando los datos
              img.setId(placa);
              img.setName(placa);
             try { //antes de agregar el campo imagen, realiza la conversion de bytes a JPG
                 img.setArchivo(ConvertirImagen(resultSet.getBytes("archivo")));
             } catch (IOException ex) {
                System.err.println(ex.getMessage());
             }
    
          }
       }
       catch (SQLException ex) {
          System.err.println(ex.getMessage());
       }
        
        return img;
    }
       public void editarImagen(String placa,String modelo, String marca, Integer anio,  String chasis,String motor,Double kilometraje,Double costo,String transmision, String ruta)
    {
         FileInputStream fis = null;
        try {
             File file = new File(ruta);
             fis = new FileInputStream(file);
             PreparedStatement pstm = connection.prepareStatement("UPDATE autos "
                + "SET archivo = ? "
                       + ", modelo = ? "
                + ", marca = ? "
                + ", anio = ? "
                + ", chasis = ? "
                 + ", motor = ? "
                + ", kilometraje = ? "
                + ", costo = ? "
                + ", transmision = ? "
                + "WHERE  placa= ?");
             pstm.setBinaryStream(1, fis,(int) file.length());
            pstm.setString(2, modelo);
             pstm.setString(3, marca);
            pstm.setInt(4, anio);
            pstm.setString(5, chasis);
            pstm.setString(6, motor);
            pstm.setDouble(7, kilometraje);
            pstm.setDouble(8, costo);
            pstm.setString(9, transmision);
            pstm.setString(10, placa);
             pstm.execute();
             pstm.close();
        } catch (FileNotFoundException e) {
             System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
               fis.close();
             } catch (IOException e) {
               System.out.println(e.getMessage());
             }
        }
    }
       

}