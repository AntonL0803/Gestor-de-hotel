package GestordeHotel;

import java.util.*;

public class Principal {
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Principal p = new Principal();
        int opcion;
        int usuarioAdm, usuarioCliente, usuarioHabita;
        Date fechaCheckOut, fechaCheckIn;

        System.out.println("Bienvenido a la aplicación para la gestión del hotel");
        System.out.println("¿Qué es lo que desea hacer? Elige una de las opciones: ");
        System.out.println("1. Acceder como administrador");
        System.out.println("2. Acceder como clientes");
        System.out.println("3. Salir");
        switch (sc.nextInt()) {
            case 1:
                Administrador admin = new Administrador();
                System.out.println("Elija una opción de las siguientes (Gestión de habitaciones):\n1. Dar de alta\n2. Dar de baja\n3.Modificar datos ");
                p.opcionesAdmin(admin, hotel);
            case 2:
                if (clienteActual != null) {

                    // Mostrar las habitaciones disponibles
                    System.out.println("Habitaciones disponibles: ");
                    hotel.mostrarHabitaciones(hotel.verHabitacionesDisponibles());

                    // Solicitar detalles de la reserva
                    System.out.print("Ingrese el usuario de la habitación que desea reservar: ");
                    usuarioHabita = sc.nextInt();
                    Habitacion habitacionSeleccionada = null;
                    for (Habitacion habitacion : hotel.verHabitacionesDisponibles()) {
                        if (habitacion.getDni() == usuarioHabita) {
                            habitacionSeleccionada = habitacion;
                            break;
                        }
                    }
                    if (habitacionSeleccionada != null) {
                        System.out.print("Ingrese la fecha de entrada (DD/MM/AAAA): ");
                        fechaCheckIn = sc.next();
                        System.out.print("Ingrese la fecha de salida (DD/MM/AAAA): ");
                        fechaCheckOut = sc.next();

                        // Realizar la reserva
                        hotel.reservarHabitacion(habitacionSeleccionada, clienteActual, fechaCheckIn, fechaCheckOut);
                        System.out.println("¡Reserva realizada con éxito!");
                    } else {
                        System.out.println("Habitación no encontrada o no disponible.");
                    }
                } else {
                    System.out.println("Usuario de cliente incorrecto.");
                }
                break;
            case 3:
                System.out.println("¡Hasta pronto!");
                break;
            default:
                System.out.println("ERROR! Opción no válida. Elija una de las opciones dentro de las señaladas.");
        }

    }

    public void opcionesAdmin(Administrador admin, Hotel h){
        switch (sc.nextInt()){
            case 1:
                admin.altaHabitacion();
                break;
            case 2:
                h.imprimirHab();
                System.out.print("\nIntroduzca el número de la habitación que desea eliminar: ");
                admin.bajaHabitacion(sc.nextInt());
            case 3:
                h.imprimirHab();
                System.out.print("\nIntroduzca el número de la habitación que desea modificar: ");
                h.cambiarDatosHabitacion(sc.nextInt());
        }
    }
}
