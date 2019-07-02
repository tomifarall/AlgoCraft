package modelo.Materiales;
import modelo.Interfaces.IColeccionable;
import modelo.Interfaces.IMapeable;
import modelo.Interfaces.IMaterialHerramienta;
import modelo.Interfaces.IMaterialMapa;
import modelo.Mapa.Posicion;

public abstract class Material implements IMapeable, IMaterialHerramienta, IMaterialMapa, IColeccionable {

    protected int durabilidadInicial;
    protected int durabilidad;
    protected String tipoMaterial;
    protected Posicion posicion;

    protected int getDurabilidadInicial(){
        return durabilidadInicial;
    }

    @Override
    public String getTipo(){ return this.tipoMaterial;}

    public int getDurabilidad() { return this.durabilidad;}

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
    public  boolean esVacio(){
        return  false;
    }

    @Override
    public void serRecolectado(){
        if (this.durabilidad > 0){
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


   /* public boolean esigual (Material material) {

        if (material == this) {
            return true;
        }
        return ((this.getDurabilidad() == material.getDurabilidad()));
    }*/
}