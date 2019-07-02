import modelo.Desgastes.*;

import modelo.Materiales.Diamante;
import modelo.Materiales.Madera;
import modelo.Materiales.Metal;
import modelo.Materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class DesgastePorcentualTest {
    @Test (expected = DurabilidadInvalidaException.class)
    public void Test01DesgastePorcentualDaErrorConDurabilidad0(){
        int durabilidad = 0;
        float porcentajeDesgaste = 0.8f;
        int fuerza = 10;
        DesgastePorcentual desgaste = new DesgastePorcentual(durabilidad,fuerza,porcentajeDesgaste);

    }

    @Test (expected = DurabilidadInvalidaException.class)
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

    @Test
    public void Test08DesgastePorcentualDebilitaMadera(){
        Madera madera = new Madera();
        DesgastePorcentual desgaste = new DesgastePorcentual(1000,3,0.5f);
        int fuerza = desgaste.getFuerza();
        int durabilidad = madera.getDurabilidad();

        desgaste.debilitarMaterial(madera);
        desgaste.debilitarMaterial(madera);
        desgaste.debilitarMaterial(madera);

        Assert.assertEquals(durabilidad - 3 * fuerza, madera.getDurabilidad());
    }

    @Test
    public void Test09DesgastePorcentualDebilitaPiedra(){
        Piedra piedra = new Piedra();
        DesgastePorcentual desgaste = new DesgastePorcentual(1000,3,0.5f);
        int fuerza = desgaste.getFuerza();
        int durabilidad = piedra.getDurabilidad();

        desgaste.debilitarMaterial(piedra);
        desgaste.debilitarMaterial(piedra);
        desgaste.debilitarMaterial(piedra);

        Assert.assertEquals(durabilidad - 3 * fuerza, piedra.getDurabilidad());
    }

    @Test
    public void Test10DesgastePorcentualDebilitaMetal(){
        Metal metal = new Metal();
        DesgastePorcentual desgaste = new DesgastePorcentual(1000,3,0.5f);
        int fuerza = desgaste.getFuerza();
        int durabilidad = metal.getDurabilidad();

        desgaste.debilitarMaterial(metal);
        desgaste.debilitarMaterial(metal);
        desgaste.debilitarMaterial(metal);

        Assert.assertEquals(durabilidad - 3 * fuerza, metal.getDurabilidad());
    }

    @Test
    public void Test11DesgastePorcentualDebilitaDiamante(){
        Diamante diamante = new Diamante();
        DesgastePorcentual desgaste = new DesgastePorcentual(1000,3,0.5f);
        int fuerza = desgaste.getFuerza();
        int durabilidad = diamante.getDurabilidad();

        desgaste.debiliatarMaterial(diamante);
        desgaste.debiliatarMaterial(diamante);
        desgaste.debiliatarMaterial(diamante);

        Assert.assertEquals(durabilidad - 3 * fuerza, diamante.getDurabilidad());
    }

    @Test (expected = HerramientaRotaException.class)
    public void Test12DesgastePorcentualNoSePuedeUsarSinDurabilidad(){
        DesgastePorcentual desgaste = new DesgastePorcentual(1000,20,0.1f);

        for (int i = 0; i < 49; i++) {
            try {
                desgaste.usar();
            }catch (HerramientaRotaException e){
                throw new FuerzaInvalidaException();
            }
        }

        desgaste.usar();
    }
}