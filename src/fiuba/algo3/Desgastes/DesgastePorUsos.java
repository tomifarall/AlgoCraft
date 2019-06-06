package fiuba.algo3.Desgastes;

public class DesgastePorUsos extends Desgaste {

    private int usos;

    public DesgastePorUsos(int durabilidad, int usos, int fuerza) {
        if(durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();
        if (usos  <= 0) throw new NoSePuedeUsarSinUsosException();
        this.durabilidad = durabilidad;
        this.usos = usos;
        this.fuerza = fuerza;
    }

    @Override
    public void usar() {
        if(durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();
        this.usos--;
        if (usos <= 0) durabilidad = 0;
    }
    @Override
    public void usar(int fuerza) {
        if(durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();
        this.usos--;
        if (usos <= 0) durabilidad = 0;
    }
}
