package GestordeHotel;

import java.util.Scanner;

public class Doble extends Habitacion{
    public Doble() {
        super("Doble",1, 80.0);
    }

    public void cambiarDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que datos desea modificar?:\n1. Precio por noche\n2. Disponibilidad");
        switch(sc.nextInt()){
            case 1:
                System.out.print("Introduzca el dato: ");
                setPrecioNoche(sc.nextDouble());
                break;
            case 2:
                System.out.print("(1) Libre\n(2) Reservado");
                if (sc.nextInt() == 1){
                    setDisponibilidad(true);
                } else {
                    setDisponibilidad(false);
                }
        }
        // Aquí podrías implementar la lógica para cambiar los datos específicos de la habitación individual
        System.out.println("Cambiando datos de habitación doble...");
    }
}
