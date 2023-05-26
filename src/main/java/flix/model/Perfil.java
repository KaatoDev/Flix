package flix.model;

public class Perfil {
    private final int id, cpf;
    private String display;
    private boolean kid;
    private int icon;

    public Perfil(int id, int cpf, String display, boolean kid, int icon) {
        this.id = id;
        this.cpf = cpf;
        this.display = display;
        this.kid = kid;
        this.icon = icon;
    }

    public String getDisplay() {
        return display;
    }

    public int getCpf() {
        return cpf;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public boolean isKid() {
        return kid;
    }

    public void setKid(boolean kid) {
        this.kid = kid;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }
    
}
