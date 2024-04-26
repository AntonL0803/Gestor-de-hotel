package GestordeHotel;

public abstract class Habitacion extends Hotel{
    private String tipo;
    private int numeroHab;
    private double precioNoche;
    private boolean disponibilidad;

    public Habitacion(String tipo, int numeroHab, double precioNoche) {
        this.tipo = tipo;
        while (numeroOcupado(numeroHab)) {
            numeroHab++; // Incrementar el número hasta que sea único
        }
        this.numeroHab = numeroHab;
        this.precioNoche = precioNoche;
        this.disponibilidad = true;
    }
    private boolean numeroOcupado(int numero) {
        for (Habitacion habitacion : super.getHabitaciones()) {
            if (habitacion.getNumeroHab() == numero) {
                return true;
            }
        }
        return false;
    }

    public int getNumeroHab() {
        return numeroHab;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void reservar() {
        this.disponibilidad = false;
    }

    public void liberar() {
        this.disponibilidad = true;
    }
}
