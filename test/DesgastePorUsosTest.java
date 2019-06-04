import fiuba.algo3.Desgastes.DesgastePorUsos;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinDurabilidadException;
import fiuba.algo3.Desgastes.NoSePuedeUsarSinUsosException;

import org.junit.Assert;
import org.junit.Test;

public class DesgastePorUsosTest {
    @Test
    public void Test01DesgastePorUsosDaErrorConDurabilidad0{
        int durabilidad = 0;
        int usos = 2;
        try{
            DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos);
        } catch(NoSePuedeUsarSinDurabilidadException e){}
    }

    @Test
    public void Test02DesgastePorUsosDaErrorConDurabilidadNegativa{
        int durabilidad = -1;
        int usos = 2;
        try{
            DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad,usos);
        } catch(NoSePuedeUsarSinDurabilidadException e){}
    }

    @Test
    public void Test03DesgastePorUsosSeCreaConLaDurabilidadRecibidaPorParametro{
        int durabilidad = 2;
        int usos = 2;
        DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }
    @Test
    public void Test04DesgastePorUsosDaErrorConUsos0{
        int durabilidad = 2;
        int usos = 0;
        try{
            DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos);
        } catch(NoSePuedeUsarSinUsosException e){}
    }

    @Test
    public void Test05DesgastePorUsosDaErrorConUsosNegativos{
        int durabilidad = 2;
        int usos = -1;
        try{
            DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos);
        } catch(NoSePuedeUsarSinDurabilidadException e){}
    }

    @Test
    public void Test06DesgastePorUsosSeCreaConLaDurabilidadRecibidaPorParametro{
        int durabilidad = 2;
        int usos = 1;
        DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }
    @Test
    public void Test07DesgastePorUsosSeRompeALaCantidadDeUsos{
        int durabilidad = 2;
        int usos = 2;
        DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( 0 , desgaste.getDurabilidad());
    }
}
