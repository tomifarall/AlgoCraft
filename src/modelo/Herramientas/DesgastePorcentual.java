package modelo.Herramientas;

public class DesgastePorcentual extends Desgaste {

    private float porcentajeDesgaste;

    public DesgastePorcentual(int durabilidad, int fuerza, float porcentajeDesgaste) {
        if(durabilidad <= 0) throw new DurabilidadInvalidaException();
        if (porcentajeDesgaste  <= 0 || porcentajeDesgaste > 1) throw new NoSePuedeUsarSinPorcentajeDesgasteException();
        this.durabilidad = durabilidad;
        this.fuerza = fuerza;
        this.porcentajeDesgaste = porcentajeDesgaste;
    }

    @Override
    public void usar() {
        this.durabilidad -=  this.durabilidad * porcentajeDesgaste;
        if (durabilidad <= 0) {
            throw new HerramientaRotaException();
        }
    }

}