import java.util.Scanner;

public class GestionPedidos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Pila principal (UNDO)
        PilaPedidos pilaPrincipal = new PilaPedidos();

        // Pila secundaria (REDO)
        PilaPedidos pilaSecundaria = new PilaPedidos();

        int opcion;

        do {

            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Registrar Pizza");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {

                case 1:

                    System.out.print("Nombre de la pizza: ");
                    String nombre = sc.nextLine();

                    String[] ingredientes = new String[3];

                    for(int i = 0; i < 3; i++) {
                        System.out.print("Ingrediente " + (i + 1) + ": ");
                        ingredientes[i] = sc.nextLine();
                    }

                    Pizza nuevaPizza = new Pizza(nombre, ingredientes);

                    // Push a la pila principal
                    pilaPrincipal.push(nuevaPizza);

                    break;

                case 2:

                    // Undo
                    Pizza eliminada = pilaPrincipal.pop();

                    if(eliminada != null) {

                        // Push a pila secundaria
                        pilaSecundaria.push(eliminada);

                        System.out.println("Pedido deshecho.");
                    }

                    break;

                case 3:

                    // Redo
                    Pizza recuperada = pilaSecundaria.pop();

                    if(recuperada != null) {

                        // Regresa a pila principal
                        pilaPrincipal.push(recuperada);

                        System.out.println("Pedido rehecho.");
                    }

                    break;

                case 4:

                    Pizza actual = pilaPrincipal.peek();

                    if(actual != null) {

                        System.out.println("\nPedido actual:");
                        actual.mostrarPizza();

                    } else {

                        System.out.println("No hay pedidos.");
                    }

                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while(opcion != 0);

        sc.close();
    }
}