import fiuba.algo3.Desgastes.DesgastePorcentual;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinPorcentajeDesgasteException;

import org.junit.Assert;
import org.junit.Test;

public class DesgastePorcentualTest {
    @Test (expected = NoSePuedeUsarSinDurabilidadException.class)
    public void Test01DesgastePorcentualDaErrorConDurabilidad0(){
        int durabilidad = 0;
        float porcentajeDesgaste = 0.8f;
        int fuerza = 10;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad,fuerza,porcentajeDesgaste);

    }

    @Test (expected = NoSePuedeUsarSinDurabilidadException.class)
    public void Test02DesgastePorcentualDaErrorConDurabilidadNegativa(){
        int durabilidad = -1;
        float porcentajeDesgaste = 0.8f;
        int fuerza= 10;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad,fuerza,porcentajeDesgaste);
    }

    @Test
    public void Test03DesgastePorcentualSeCreaConLaDurabilidadRecibidaPorParametro(){
        int durabilidad = 2;
        float porcentajeDesgaste = 0.8f;
        int fuerza = 10;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, fuerza, porcentajeDesgaste);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }
    @Test ( expected = NoSePuedeUsarSinPorcentajeDesgasteException.class)
    public void Test04DesgastePorcentualDaErrorConPorcentaje0(){
        int durabilidad = 2;
        float porcentajeDesgaste = 0;
        int fuerza = 10;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad,fuerza, porcentajeDesgaste);
    }

    @Test (expected = NoSePuedeUsarSinPorcentajeDesgasteException.class)
    public void Test05DesgastePorcentualDaErrorConPorcentajeNegativos(){
        int durabilidad = 2;
        float porcentajeDesgaste = -1;
        int fuerza = 10;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, fuerza, porcentajeDesgaste);
    }

    @Test
    public void Test06DesgastePorcentualSeCreaConLaDurabilidadRecibidaPorParametro(){
        int durabilidad = 2;
        float porcentajeDesgaste = 1;
        int fuerza = 10;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, fuerza, porcentajeDesgaste);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }
    @Test
    public void Test07DesgastePorcentualSeReduceSegunElPorcentaje(){
        int durabilidad =2000;
        float porcentajeDesgaste = 0.8f;
        int fuerza = 10;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, fuerza, porcentajeDesgaste);

        int durabilidadEsperada = durabilidad;

        durabilidadEsperada -= (porcentajeDesgaste*durabilidadEsperada);
        desgaste.usar();

        durabilidadEsperada -= (porcentajeDesgaste*durabilidadEsperada);
        desgaste.usar();

        durabilidadEsperada -= (porcentajeDesgaste*durabilidadEsperada);
        desgaste.usar();

        durabilidadEsperada -= (porcentajeDesgaste*durabilidadEsperada);
        desgaste.usar();

        Assert.assertEquals( durabilidadEsperada, desgaste.getDurabilidad());


    }
}