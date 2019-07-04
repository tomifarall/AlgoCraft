package modelo.Herramientas;

public class DesgasteLineal extends Desgaste {

    float multiplicador;
    public DesgasteLineal(int durabilidadInicial, int fuerza, float multiplicador){
        if (durabilidadInicial <= 0) throw new DurabilidadInvalidaException();
        if (fuerza  <= 0) throw new FuerzaInvalidaException();
        if (multiplicador  <= 0 || multiplicador > 1) throw new MultiplicadorDeFuerzaInvalidoException();

        this.durabilidad = durabilidadInicial;
        this.fuerza = fuerza;
        this.multiplicador = multiplicador ;
    }

    @Override
    public void usar(){
        durabilidad -= (int) (this.fuerza * this.multiplicador);
        if (durabilidad <= 0) {
            throw new HerramientaRotaException();
        }
    }
}