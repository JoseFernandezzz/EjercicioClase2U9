package Contenido;

import java.util.Scanner;

public class Main {
    static Insert insert = new Insert();
    static Select select = new Select();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conexion.conectar();
        for (int i = 0; i < 10; i++) {
            insertarDieta(scanner);

        }
        select.selectInformatica();

    }

    private static void insertarDieta(Scanner scanner) {


        System.out.print("Ingrese Empleado: ");
        String empleado = scanner.next();

        System.out.print("Ingrese Departamento: ");
        String departamento = scanner.next();

        System.out.print("Ingrese cantidad: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese concepto: ");
        String concepto = scanner.next();

        insert.insertar ( empleado, departamento, cantidad, concepto);
        System.out.println("AGREGADO!!");
    }
}
