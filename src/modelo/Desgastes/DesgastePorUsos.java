package modelo.Desgastes;

public class DesgastePorUsos extends Desgaste {

    private int usos;

    public DesgastePorUsos(int durabilidad, int usos, int fuerza) {
        if(durabilidad <= 0) throw new DurabilidadInvalidaException();
        if (usos  <= 0) throw new NoSePuedeUsarSinUsosException();
        this.durabilidad = durabilidad;
        this.usos = usos;
        this.fuerza = fuerza;
    }

    @Override
    public void usar() {
        this.usos--;
        if (usos <= 0) this.durabilidad = 0;
        if(durabilidad <= 0) throw new HerramientaRotaException();
    }
}
