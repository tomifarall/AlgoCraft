package fiuba.algo3.Materiales;
import fiuba.algo3.Interfaces.IColeccionable;
import fiuba.algo3.Interfaces.IMapeable;
import fiuba.algo3.Interfaces.IMaterialHerramienta;
import fiuba.algo3.Interfaces.IMaterialMapa;
import fiuba.algo3.Mapa.Posicion;

public abstract class Material implements IMapeable, IMaterialHerramienta, IMaterialMapa, IColeccionable {

    protected int durabilidad;

    protected int durabilidadInicial;

    protected Posicion posicion;

    public int getDurabilidad() { return this.durabilidad;}

    protected int getDurabilidadInicial(){
        return durabilidadInicial;
    }

    @Override
    public void setPosicion(Posicion posicion){
        this.posicion= posicion;
    }

    @Override
    public Posicion getPosicion(){
        return  this.posicion;
    }


    public void debilitarse(int fuerza) { this.durabilidad -= fuerza; }

    @Override
    public void serRecolectado(){
        if(this.durabilidad > 0){
            throw new NoSePuedeRecolectarUnMaterialNoDestruidoException();
        }
    }
    @Override
    public boolean esIgual (IMapeable elemento) {

        if (elemento == this) {
            return true;
        }
        if (elemento.esVacio()){
            return false;
        }
        Material elementoMaterial = (Material) elemento;
        return ((this.getDurabilidadInicial() == elementoMaterial.getDurabilidadInicial()));
    }


    @Override
    public  boolean esVacio(){
        return  false;
    }
}
