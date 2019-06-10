package fiuba.algo3.Desgastes;

public class DesgastePorcentual extends Desgaste {

    private double porcentajeDesgaste;

    public DesgastePorcentual(int durabilidad, double porcentajeDesgaste) {
        if(durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();
        if (porcentajeDesgaste  <= 0 || porcentajeDesgaste > 1) throw new NoSePuedeUsarSinPorcentajeDesgasteException();
        this.durabilidad = durabilidad;
        this.porcentajeDesgaste = porcentajeDesgaste;
        this.fuerza =(int)(durabilidad*porcentajeDesgaste);

    }

    @Override
    public void usar() {
        if (durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();

        durabilidad -= fuerza;
        fuerza= (int) (durabilidad * porcentajeDesgaste);
    }

    @Override
    public void usar(int fuerza) {
        if (durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();

        durabilidad -= (int) (durabilidad * porcentajeDesgaste);
    }
}