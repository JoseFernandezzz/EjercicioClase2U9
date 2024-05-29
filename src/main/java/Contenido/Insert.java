package Contenido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    private static final String INSERT_DIETAS_SQL = "INSERT INTO Dietas (empleado, departamento, cantidad,concepto) VALUES (?,?,?,?)";
    public void insertar(String empleado, String departamento, int cantidad, String concepto) {
        try (Connection con = Conexion.conectar();
             PreparedStatement pstmt = con.prepareStatement(INSERT_DIETAS_SQL)) {

            pstmt.setString(1, empleado);
            pstmt.setString(2, departamento);
            pstmt.setDouble(3, cantidad);
            pstmt.setString(4, concepto);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
