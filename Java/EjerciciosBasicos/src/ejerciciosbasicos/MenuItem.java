package ejerciciosbasicos;

public class MenuItem {
    private char opcion;
    private String item;

    public MenuItem(char opcion, String item) {
        this.opcion = opcion;
        this.item = item;
    }

    public char getOpcion() {
        return opcion;
    }

    public void setOpcion(char opcion) {
        this.opcion = opcion;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    public String getItemMenu() {
        return opcion + " - " + item;
    }
}
