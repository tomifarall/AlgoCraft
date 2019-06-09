package fiuba.algo3.Desgastes;

public class DesgastePorcentual extends Desgaste {

    private double porcentajeDesgaste;

    public DesgastePorcentual(int durabilidad, double porcentajeDesgaste) {
        if(durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();
        if (porcentajeDesgaste  <= 0 || porcentajeDesgaste > 100) throw new NoSePuedeUsarSinPorcentajeDesgasteException();
        this.durabilidad = durabilidad;
        this.porcentajeDesgaste = porcentajeDesgaste;
        this.fuerza =(int)(durabilidad*porcentajeDesgaste);

    }

    @Override
    public void usar() {

        durabilidad -= fuerza;
        fuerza= (int) (durabilidad * porcentajeDesgaste);
    }

    @Override
    public void usar(int fuerza) {
        durabilidad -= (int) (durabilidad * porcentajeDesgaste);
    }
}