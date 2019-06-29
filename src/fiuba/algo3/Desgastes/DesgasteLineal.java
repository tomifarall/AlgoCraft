package fiuba.algo3.Desgastes;

public class DesgasteLineal extends Desgaste {

    float multiplicador;
    public DesgasteLineal(int durabilidadInicial, int fuerza, float multiplicador){
        if (durabilidadInicial <= 0) throw new NoSePuedeUsarSinDurabilidadException();
        if (fuerza  <= 0) throw new FuerzaInvalidaException();
        if (multiplicador  <= 0 || multiplicador > 1) throw new MultiplicadorDeFuerzaInvalidoException();

        this.durabilidad = durabilidadInicial;
        this.fuerza = fuerza;
        this.multiplicador = multiplicador ;
    }

    @Override
    public void usar(){
        if (durabilidad <= 0) {
            throw new NoSePuedeUsarSinDurabilidadException();
        }
        durabilidad -= (int) (this.fuerza * this.multiplicador);
    }
}