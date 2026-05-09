import dao.ProductoDAO;
import modelos.Producto;

public class Main {

    public static void main(String[] args) {

        // Crear objeto DAO
        ProductoDAO productoDAO = new ProductoDAO();

        // =========================
        // CREATE -> INSERT
        // =========================

        Producto productoNuevo = new Producto();

        productoNuevo.setNombre("BomBomBum");

        productoNuevo.setCategoria("Dulces");

        productoNuevo.setPrecio(1000);

        productoNuevo.setStockActual(40);

        productoNuevo.setStockMinimo(5);

        productoDAO.insertarProducto(productoNuevo);

        // =========================
        // READ -> SELECT
        // =========================

        productoDAO.listarProductos();

        // =========================
        // UPDATE
        // =========================

        productoDAO.actualizarStock(1, 99);

        // =========================
        // DELETE
        // =========================

        productoDAO.eliminarProducto(3);

        // =========================
        // LISTA FINAL
        // =========================

        productoDAO.listarProductos();
    }
}