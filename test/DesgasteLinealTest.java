import modelo.Desgastes.*;

import modelo.Materiales.Diamante;
import modelo.Materiales.Madera;
import modelo.Materiales.Metal;
import modelo.Materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class DesgasteLinealTest {
    @Test (expected = DurabilidadInvalidaException.class)
    public void Test01DesgasteLinealDaErrorConDurabilidad0(){
        int durabilidad =0;
        float multiplicador = 0.8f;
        int fuerza = 20;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza,multiplicador);
    }

    @Test (expected = MultiplicadorDeFuerzaInvalidoException.class)
    public void Test02DesgasteLinealDaErrorConMultiplicador0(){
        int durabilidad = 1000;
        float multiplicador = 0;
        int fuerza = 20;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);
    }

    @Test (expected = MultiplicadorDeFuerzaInvalidoException.class)
    public void Test03DesgasteLinealDaErrorConMultiplicadorMayorA1(){
        int durabilidad = 1000;
        float multiplicador = 10;
        int fuerza = 20;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);
    }

    @Test (expected = FuerzaInvalidaException.class)
    public void Test04DesgasteLinealDaErrorConFuerza0(){
        int durabilidad = 1000;
        float multiplicador = 0.1f;
        int fuerza = 0;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);
    }

    @Test (expected = FuerzaInvalidaException.class)
    public void Test05DesgasteLinealDaErrorConFuerzaMenora0(){
        int durabilidad = 1000;
        float multiplicador = 0.1f;
        int fuerza = -2;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);
    }

    @Test (expected = DurabilidadInvalidaException.class)
    public void Test06DesgasteLinealDaErrorConDurabilidadNegativa(){
        int durabilidad = -6;
        float multiplicador = 0.1f;
        int fuerza = 2;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);
    }


    @Test
    public void Test07DesgasteLinealSeCreaConLaDurabilidadRecibidaPorParametro(){
        int durabilidad = 1000;
        float multiplicador = 0.8f;
        int fuerza = 20;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }




    @Test
    public void Test08DesgasteLinealSeCreaConLaDurabilidadRecibidaPorParametroConFuerzaYMultiplicador(){
        int durabilidad = 5;
        float multiplicador = 0.1f;
        int fuerza = 2;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }

    @Test
    public void Test09DesgasteLinealSeDesgastaCorrectamente(){
        int durabilidad = 100;
        float multiplicador = 0.5f;
        int fuerza = 20;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( durabilidad-(int)(fuerza*multiplicador) , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( durabilidad-2*(int)(fuerza*multiplicador) , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( durabilidad-3*(int)(fuerza*multiplicador) , desgaste.getDurabilidad());
    }

    @Test
    public void Test10DesgasteLinealDebilitaMadera(){
        Madera madera = new Madera();
        DesgasteLineal desgaste = new DesgasteLineal(1000,3,0.5f);
        int fuerza = desgaste.getFuerza();
        int durabilidad = madera.getDurabilidad();

        desgaste.debilitarMaterial(madera);
        desgaste.debilitarMaterial(madera);
        desgaste.debilitarMaterial(madera);

        Assert.assertEquals(durabilidad - 3 * fuerza, madera.getDurabilidad());
    }

    @Test
    public void Test11DesgasteLinealDebilitaPiedra(){
        Piedra piedra = new Piedra();
        DesgasteLineal desgaste = new DesgasteLineal(1000,3,0.5f);
        int fuerza = desgaste.getFuerza();
        int durabilidad = piedra.getDurabilidad();

        desgaste.debilitarMaterial(piedra);
        desgaste.debilitarMaterial(piedra);
        desgaste.debilitarMaterial(piedra);

        Assert.assertEquals(durabilidad - 3 * fuerza, piedra.getDurabilidad());
    }

    @Test
    public void Test12DesgasteLinealDebilitaMetal(){
        Metal metal = new Metal();
        DesgasteLineal desgaste = new DesgasteLineal(1000,3,0.5f);
        int fuerza = desgaste.getFuerza();
        int durabilidad = metal.getDurabilidad();

        desgaste.debilitarMaterial(metal);
        desgaste.debilitarMaterial(metal);
        desgaste.debilitarMaterial(metal);

        Assert.assertEquals(durabilidad - 3 * fuerza, metal.getDurabilidad());
    }

    @Test
    public void Test13DesgasteLinealDebilitaDiamante(){
        Diamante diamante = new Diamante();
        DesgasteLineal desgaste = new DesgasteLineal(1000,3,0.5f);
        int fuerza = desgaste.getFuerza();
        int durabilidad = diamante.getDurabilidad();

        desgaste.debiliatarMaterial(diamante);
        desgaste.debiliatarMaterial(diamante);
        desgaste.debiliatarMaterial(diamante);

        Assert.assertEquals(durabilidad - 3 * fuerza, diamante.getDurabilidad());
    }

    @Test (expected = HerramientaRotaException.class)
    public void Test14DesgasteLinealNoSePuedeUsarSinDurabilidad(){
        int multiplicador = 1;
        DesgasteLineal desgaste = new DesgasteLineal(10,1,1);
        int durabilidad = desgaste.getDurabilidad();
        int fuerza = desgaste.getFuerza();
        int cantidadDeUsos = durabilidad / ((int) (fuerza*multiplicador)) -1;

        for (int i = 0; i < cantidadDeUsos; i++) {
            try {
                desgaste.usar();
            }catch (HerramientaRotaException e){
                throw new FuerzaInvalidaException();
            }
        }

        desgaste.usar();
    }

}
