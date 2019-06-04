package fiuba.algo3.Desgastes;

public class DesgasteLineal extends Desgaste {

    private int restador;

    public DesgasteLineal(int durabilidadInicial) {
        if (durabilidadInicial <= 0) throw new NoSePuedeUsarSinDurabilidadException();

        this.durabilidad = durabilidadInicial;
        this.restador = 0;
    }

    public DesgasteLineal(int durabilidadInicial, int fuerza, double multiplicador){
        if (durabilidadInicial <= 0) throw new NoSePuedeUsarSinDurabilidadException();
        if (fuerza  <= 0) throw new FuerzaInvalidaException();
        if (multiplicador  <= 0 || multiplicador > 1) throw new MultiplicadorDeFuerzaInvalidoException();

        this.durabilidad = durabilidadInicial;
        this.restador = (int) (fuerza*multiplicador);
    }

    @Override
    public void usar(){
        if (durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();

        durabilidad -= restador;
    }

    public void usar(int fuerza) {
        if (durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();
        if (fuerza  <= 0) throw new FuerzaInvalidaException();

        durabilidad-=fuerza;
    }
}