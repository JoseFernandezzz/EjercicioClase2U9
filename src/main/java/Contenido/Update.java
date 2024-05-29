package Contenido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Update {
    private static final String UPDATE_DIETAS_SQL = "UPDATE dietas SET cantidad = cantidad * 1.10 WHERE departamento = 'Ventas'";
    public ArrayList<String> updateVentas() {
        ArrayList<String> empleados = new ArrayList<>();
        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_DIETAS_SQL)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String empleado = String.format("ID: %s, Empleado: %s, Departamento: %s, Cantidad: %s",
                        rs.getString("id"), rs.getString("empleado"), rs.getString("departamento"), rs.getInt("cantidad"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }
}
