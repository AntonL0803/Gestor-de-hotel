package GestordeHotel;

public class Reserva {
    private int numeroHab;
    private String nombreCliente;
    private String fechaInicio;
    private String fechaSalida;

    public Reserva(int numeroHab, String nombreCliente, String fechaInicio, String fechaSalida) {
        this.numeroHab = numeroHab;
        this.nombreCliente = nombreCliente;
        this.fechaInicio = fechaInicio;
        this.fechaSalida = fechaSalida;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
