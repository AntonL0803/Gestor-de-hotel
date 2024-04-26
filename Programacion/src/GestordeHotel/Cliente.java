package GestordeHotel;

public class Cliente extends Hotel {
    private String nombre;
    private String password;

    public Cliente(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }
}
