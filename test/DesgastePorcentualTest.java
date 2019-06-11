import fiuba.algo3.Desgastes.DesgastePorcentual;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinPorcentajeDesgasteException;

import org.junit.Assert;
import org.junit.Test;

public class DesgastePorcentualTest {
    @Test
    public void Test01DesgastePorcentualDaErrorConDurabilidad0(){
        int durabilidad = 0;
        int porcentajeDesgaste = 2;
        int fuerza = 10;
        try{
            DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad,fuerza,porcentajeDesgaste);
        } catch(NoSePuedeUsarSinDurabilidadException e){}
    }

    @Test
    public void Test02DesgastePorcentualDaErrorConDurabilidadNegativa(){
        int durabilidad = -1;
        int porcentajeDesgaste = 2;
        int fuerza= 10;
        try{
            DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad,fuerza,porcentajeDesgaste);
        } catch(NoSePuedeUsarSinDurabilidadException e){}
    }

    @Test
    public void Test03DesgastePorcentualSeCreaConLaDurabilidadRecibidaPorParametro(){
        int durabilidad = 2;
        int porcentajeDesgaste = 2;
        int fuerza = 10;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, fuerza, porcentajeDesgaste);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }
    @Test
    public void Test04DesgastePorcentualDaErrorConPorcentaje0(){
        int durabilidad = 2;
        int porcentajeDesgaste = 0;
        int fuerza = 10;
        try{
            DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad,fuerza, porcentajeDesgaste);
        } catch(NoSePuedeUsarSinPorcentajeDesgasteException e){}
    }

    @Test
    public void Test05DesgastePorcentualDaErrorConPorcentajeNegativos(){
        int durabilidad = 2;
        int porcentajeDesgaste = -1;
        int fuerza = 10;
        try{
            DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, fuerza, porcentajeDesgaste);
        } catch(NoSePuedeUsarSinPorcentajeDesgasteException e){}
    }

    @Test
    public void Test06DesgastePorcentualSeCreaConLaDurabilidadRecibidaPorParametro(){
        int durabilidad = 2;
        int porcentajeDesgaste = 1;
        int fuerza = 10;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, fuerza, porcentajeDesgaste);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }
    @Test
    public void Test07DesgastePorcentualSeReduceSegunElPorcentaje(){
        int durabilidad = 2;
        int porcentajeDesgaste = 2;
        int fuerza = 10;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, fuerza, porcentajeDesgaste);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( durabilidad*(1-porcentajeDesgaste) , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( (durabilidad*(1-porcentajeDesgaste))*(1-porcentajeDesgaste) , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( ((durabilidad*(1-porcentajeDesgaste))*(1-porcentajeDesgaste))*(1-porcentajeDesgaste) , desgaste.getDurabilidad());
    }
}