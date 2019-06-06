package fiuba.algo3.Desgastes;

public abstract class Desgaste {

    protected int durabilidad;
    protected int fuerza;

    public int getDurabilidad(){
        return durabilidad;
    }

    public int getFuerza(){
        return fuerza;
    }

    public abstract void usar();
    public abstract void usar(int fuerza);
}

