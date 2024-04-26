package GestordeHotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Administrador administrador = new Administrador("User1", "1234");
		Hotel hotel = new Hotel(administrador, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		Scanner sc = new Scanner(System.in);
		int opcion;
		int usuarioAdm, usuarioCliente, usuarioHabita ;
		Date fechaCheckOut, fechaCheckIn;

		// Por ejemplo: Agregar algunas habitaciones
		hotel.agregarHabitacion(new Habitacion(1234, "Individial", 60));
		hotel.agregarHabitacion(new Habitacion(3456, "doble", 100));
		hotel.agregarHabitacion(new Habitacion(5678, "familiar", 120));
		// Por ejemplo: Agregar algunos clientes
		hotel.agregarCliente(new Cliente("David", "1234"));
		hotel.agregarCliente(new Cliente("Rosa", "3456"));

		System.out.println("Bienvenido a la aplicación para la gestión del hotel");
		System.out.println("¿Qué es lo que desea hacer? Elige una de las opciones: ");
		System.out.println("1. Acceder como administrador");
		System.out.println("2. Acceder como clientes");
		System.out.println("3. Salir");
		opcion = sc.nextInt();

		switch (opcion) {
			case 1:
				System.out.println("Por favor, ingrese su usuario como administrador");
				usuarioAdm = sc.nextInt();
				if (usuarioAdm==administrador.getUsuario()) {
					administrador.gestionarHabitacion(hotel.getListaHabitaciones().get(0));
				}else {
					System.out.println("El usuario introducido no existe");
				}
				break;
			case 2:
				 System.out.print("Ingrese su usuario como cliente: ");
				    usuarioCliente = sc.nextInt();
				    Cliente clienteActual = null;
				    for (Cliente cliente : hotel.getListaClientes()) {
				        if (cliente.getUsuario() == usuarioCliente) {
				            clienteActual = cliente;
				            break;
				        }
				    }
				    if (clienteActual != null) {
				       
				    	// Mostrar las habitaciones disponibles
				        System.out.println("Habitaciones disponibles: ");
				        hotel.mostrarHabitaciones(hotel.verHabitacionesDisponibles());

				        // Solicitar detalles de la reserva
				        System.out.print("Ingrese el usuario de la habitación que desea reservar: ");
				        usuarioHabita =sc.nextInt();
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
			case 3:System.out.println("¡Hasta pronto!");
				break;
			default: System.out.println("ERROR! Opción no válida. Elija una de las opciones dentro de las señaladas.");
		}

	}

}
