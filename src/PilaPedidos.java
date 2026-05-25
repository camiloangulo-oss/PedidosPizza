public class PilaPedidos {

    private Nodo tope;

    // Constructor
    public PilaPedidos() {
        tope = null;
    }

    // Método push()
    public void push(Pizza pizza) {

        Nodo nuevo = new Nodo(pizza);

        // El nuevo nodo apunta al actual tope
        nuevo.siguiente = tope;

        // Ahora el nuevo nodo es el tope
        tope = nuevo;

        System.out.println("Pizza registrada correctamente.");
    }

    // Método pop()
    public Pizza pop() {

        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return null;
        }

        Pizza pizzaEliminada = tope.pizza;

        // El tope avanza al siguiente nodo
        tope = tope.siguiente;

        return pizzaEliminada;
    }

    // Método peek()
    public Pizza peek() {

        if (isEmpty()) {
            return null;
        }

        return tope.pizza;
    }

    // Método isEmpty()
    public boolean isEmpty() {
        return tope == null;
    }
}