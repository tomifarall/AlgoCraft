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
        boolean error=false;
        try{
            DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, porcentajeDesgaste);
        } catch(NoSePuedeUsarSinDurabilidadException e){error=true;}
        Assert.assertTrue(error);

    }

    @Test
    public void Test02DesgastePorcentualDaErrorConDurabilidadNegativa(){
        int durabilidad = -1;
        int porcentajeDesgaste = 2;
        try{
            DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad,porcentajeDesgaste);
        } catch(NoSePuedeUsarSinDurabilidadException e){}
    }

    @Test
    public void Test03DesgastePorcentualSeCreaConLaDurabilidadRecibidaPorParametro(){
        int durabilidad = 2;
        double porcentajeDesgaste = 0.2;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, porcentajeDesgaste);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }
    @Test
    public void Test04DesgastePorcentualDaErrorConPorcentaje0(){
        int durabilidad = 2;
        int porcentajeDesgaste = 0;
        try{
            DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, porcentajeDesgaste);
        } catch(NoSePuedeUsarSinPorcentajeDesgasteException e){}
    }

    @Test
    public void Test05DesgastePorcentualDaErrorConPorcentajeNegativos(){
        int durabilidad = 2;
        int porcentajeDesgaste = -1;
        try{
            DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, porcentajeDesgaste);
        } catch(NoSePuedeUsarSinPorcentajeDesgasteException e){}
    }

    @Test
    public void Test06DesgastePorcentualSeCreaConLaDurabilidadRecibidaPorParametro(){
        int durabilidad = 100;
        double porcentajeDesgaste = 0.5;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, porcentajeDesgaste);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }
    @Test
    public void Test07DesgastePorcentualSeReduceSegunElPorcentaje(){
        int durabilidad = 100;
        double porcentajeDesgaste = 0.2;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad, porcentajeDesgaste);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
        desgaste.usar();
        durabilidad-=(int) (durabilidad*porcentajeDesgaste);
        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
        desgaste.usar();
        durabilidad-=(int) (durabilidad*porcentajeDesgaste);
        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
        desgaste.usar();
        durabilidad-= (int) (durabilidad*porcentajeDesgaste);
        Assert.assertEquals( durabilidad, desgaste.getDurabilidad());

    }
}