import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Desgastes.MultiplicadorDeFuerzaInvalidoException;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Desgastes.FuerzaInvalidaException;

import org.junit.Assert;
import org.junit.Test;

public class DesgasteLinealTest {
    @Test (expected = NoSePuedeUsarSinDurabilidadException.class)
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

    @Test (expected = NoSePuedeUsarSinDurabilidadException.class)
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

}
