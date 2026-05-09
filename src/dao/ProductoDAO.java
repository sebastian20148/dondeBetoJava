package dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Producto;

public class ProductoDAO {

    public void listarProductos() {

        String sql = "SELECT * FROM producto";

        try (
            Connection conexion = ConexionBD.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {

            System.out.println("=== LISTA DE PRODUCTOS ===");

            while (rs.next()) {

                System.out.println(
                    "ID: " + rs.getInt("id_producto") +
                    " | Nombre: " + rs.getString("nombre") +
                    " | Categoría: " + rs.getString("categoria") +
                    " | Precio: " + rs.getDouble("precio") +
                    " | Stock: " + rs.getInt("stock_actual")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       
    public void insertarProducto(Producto producto) {

 
        String sql = "INSERT INTO producto(nombre, categoria, precio, stock_actual, stock_minimo) VALUES (?, ?, ?, ?, ?)";

    
        try (

           
            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

        ) {

            
            ps.setString(1, producto.getNombre());

         
            ps.setString(2, producto.getCategoria());

            
            ps.setDouble(3, producto.getPrecio());

            
            ps.setInt(4, producto.getStockActual());

            
            ps.setInt(5, producto.getStockMinimo());

         
            ps.executeUpdate();

            System.out.println("Producto insertado correctamente");

        } catch (SQLException e) {

     
            e.printStackTrace();
        }
    }
   
    public void actualizarStock(int idProducto, int nuevoStock) {

   
        String sql = "UPDATE producto SET stock_actual = ? WHERE id_producto = ?";

        try (

       
            Connection conexion = ConexionBD.conectar();

         
            PreparedStatement ps = conexion.prepareStatement(sql);

        ) {

        
            ps.setInt(1, nuevoStock);

           
            ps.setInt(2, idProducto);

          
            ps.executeUpdate();

            System.out.println("Stock actualizado correctamente");

        } catch (SQLException e) {

           
            e.printStackTrace();
        }
    }
        
    public void eliminarProducto(int idProducto) {

        
        String sql = "DELETE FROM producto WHERE id_producto = ?";

        try (

           
            Connection conexion = ConexionBD.conectar();

          
            PreparedStatement ps = conexion.prepareStatement(sql);

        ) {

            
            ps.setInt(1, idProducto);

            
            ps.executeUpdate();

            System.out.println("Producto eliminado correctamente");

        } catch (SQLException e) {

           
            e.printStackTrace();
        }
    }
}