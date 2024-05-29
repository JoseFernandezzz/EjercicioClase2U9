package Contenido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Select {
    private static final String SELCT_DIETAS_SQL = "SELECT * FROM dietas WHERE departamento = 'Informática' AND cantidad > 30.00";
    public ArrayList<String> selectInformatica() {
        ArrayList<String> empleados = new ArrayList<>();
        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(SELCT_DIETAS_SQL)) {
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
