package fiuba.algo3.Desgastes;

public class DesgastePorUsos extends Desgaste {

    private int usos;

    public DesgastePorUsos(int durabilidad, int usos) {
        if(durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();
        if (usos  <= 0) throw new NoSePuedeUsarSinUsosException();
        this.durabilidad = durabilidad;
        this.usos = usos;
    }

    @Override
    public void usar() {
        if(durabilidad <= 0) throw new NoSePuedeUsarSinDurabilidadException();
        this.usos--;
        if (usos <= 0) durabilidad = 0;
    }
}
