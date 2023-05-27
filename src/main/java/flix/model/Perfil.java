package flix.model;

public class Perfil {
    private final int id, cpf;
    private int genFav1, genFav2;
    private String display;
    private boolean kid;
    private int icon;

    public Perfil(int id, int cpf, int genFav1, int genFav2, String display, boolean kid, int icon) {
        this.id = id;
        this.cpf = cpf;
        this.genFav1 = genFav1;
        this.genFav2 = genFav2;
        this.display = display;
        this.kid = kid;
        this.icon = icon;
    }

    public int getGenFav1() {
        return genFav1;
    }

    public void setGenFav1(int genFav1) {
        this.genFav1 = genFav1;
    }

    public int getGenFav2() {
        return genFav2;
    }

    public void setGenFav2(int genFav2) {
        this.genFav2 = genFav2;
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
