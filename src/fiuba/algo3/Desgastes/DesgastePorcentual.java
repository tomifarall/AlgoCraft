package fiuba.algo3.Desgastes;

public class DesgastePorcentual extends Desgaste {

    private float porcentajeDesgaste;

    public DesgastePorcentual(int durabilidad, int fuerza, float porcentajeDesgaste) {
        if(durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();
        if (porcentajeDesgaste  <= 0 || porcentajeDesgaste > 100) throw new NoSePuedeUsarSinPorcentajeDesgasteException();
        this.durabilidad = durabilidad;
        this.fuerza = fuerza;
        this.porcentajeDesgaste = porcentajeDesgaste;
    }

    @Override
    public void usar() {
        this.durabilidad -=  this.durabilidad * porcentajeDesgaste;
    }

}