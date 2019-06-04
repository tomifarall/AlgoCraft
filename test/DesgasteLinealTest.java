import fiuba.algo3.Desgastes.DesgasteLineal;
import fiuba.algo3.Desgastes.MultiplicadorDeFuerzaInvalidoException;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Desgastes.FuerzaInvalidaException;

import org.junit.Assert;
import org.junit.Test;

public class DesgasteLinealTest {
    @Test
    public void Test01DesgasteLinealDaErrorConDurabilidad0{
        try{
            DesgasteLineal desgaste = new DesgasteLineal(0);
        } catch(NoSePuedeUsarSinDurabilidadException e){}
    }

    @Test
    public void Test02DesgasteLinealDaErrorConDurabilidadNegativa{
        try{
            DesgasteLineal desgaste = new DesgasteLineal(-1);
        } catch(NoSePuedeUsarSinDurabilidadException e){}
    }

    @Test
    public void Test03DesgasteLinealSeCreaConLaDurabilidadRecibidaPorParametro{
        int durabilidad = 5;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }

    @Test
    public void Test04DesgasteLinealDaErrorConMultiplicador0{
        int durabilidad = 5;
        double multiplicador = 0;
        int fuerza = 2;
        try {
            DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);
        }catch (MultiplicadorDeFuerzaInvalidoException e){}
    }

    @Test
    public void Test05DesgasteLinealDaErrorConMultiplicadorMayorAUno{
        int durabilidad = 5;
        double multiplicador = 1.1;
        int fuerza = 2;
        try {
            DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);
        }catch (MultiplicadorDeFuerzaInvalidoException e){}
    }
    @Test
    public void Test06DesgasteLinealDaErrorConFuerza0{
        int durabilidad = 5;
        double multiplicador = 0.1;
        int fuerza = 0;
        try {
            DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);
        }catch (FuerzaInvalidaException e){}
    }

    @Test
    public void Test07DesgasteLinealDaErrorConFuerzaNegativa{
        int durabilidad = 5;
        double multiplicador = 0.1;
        int fuerza = -1;
        try {
            DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);
        }catch (FuerzaInvalidaException e){}
    }
    @Test
    public void Test08DesgasteLinealSeCreaConLaDurabilidadRecibidaPorParametroConFuerzaYMultiplicador{
        int durabilidad = 5;
        double multiplicador = 0.1;
        int fuerza = 2;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad, fuerza, multiplicador);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }

    @Test
    public void Test09DesgasteLinealSeDesgastaCorrectamente{
        int durabilidad = 5;
        double multiplicador = 0.5;
        int fuerza = 2;
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
    public void Test09DesgasteLinealSeDesgastaCorrectamentePasandoleFuerza{
        int durabilidad = 5;
        int fuerza = 2;
        DesgasteLineal desgaste = new DesgasteLineal(durabilidad);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( durabilidad-fuerza , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( durabilidad-2*fuerza , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( durabilidad-3*fuerza , desgaste.getDurabilidad());
    }
}
