package fiuba.algo3.Mapa;

public class Mapa {

    private static Mapa actual;



    private Mapa(){

    }
    public static Mapa getMapa(){
        if( actual == null){
            actual = new Mapa();
        }
        return actual;
    }

}
