import modelo.Herramientas.*;
import modelo.Materiales.Diamante;
import modelo.Materiales.Madera;
import modelo.Materiales.Metal;
import modelo.Materiales.Piedra;
import org.junit.Assert;
import org.junit.Test;

public class DesgastePorUsosTest {
    @Test (expected = DurabilidadInvalidaException.class)
    public void Test01DesgastePorUsosDaErrorConDurabilidad0(){
        int durabilidad = 0;
        int usos = 2;
        int fuerza = 5;

        DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos, fuerza);
    }

    @Test (expected = DurabilidadInvalidaException.class)
    public void Test02DesgastePorUsosDaErrorConDurabilidadNegativa(){
        int durabilidad = -1;
        int usos = 2;
        int fuerza = 5;

        DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad,usos, fuerza);
    }

    @Test
    public void Test03DesgastePorUsosSeCreaConLaDurabilidadRecibidaPorParametro(){
        int durabilidad = 2;
        int usos = 2;
        int fuerza = 5;
        DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos, fuerza);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }
    @Test (expected = NoSePuedeUsarSinUsosException.class)
    public void Test04DesgastePorUsosDaErrorConUsos0(){
        int durabilidad = 2;
        int usos = 0;
        int fuerza = 5;

        DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos, fuerza);
    }

    @Test (expected = NoSePuedeUsarSinUsosException.class)
    public void Test05DesgastePorUsosDaErrorConUsosNegativos(){
        int durabilidad = 2;
        int usos = -1;
        int fuerza = 5;

        DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos, fuerza);
    }

    @Test
    public void Test06DesgastePorUsosSeCreaConLaDurabilidadRecibidaPorParametro(){
        int durabilidad = 2;
        int usos = 1;
        int fuerza = 5;
        DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos, fuerza);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
    }
    @Test
    public void Test07DesgastePorUsosSeRompeALaCantidadDeUsos(){
        int durabilidad = 2;
        int usos = 2;
        int fuerza = 5;
        DesgastePorUsos desgaste = new DesgastePorUsos(durabilidad, usos, fuerza);

        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
        desgaste.usar();
        Assert.assertEquals( durabilidad , desgaste.getDurabilidad());
        try {
            desgaste.usar();
        }catch (HerramientaRotaException e){}

        Assert.assertEquals( 0 , desgaste.getDurabilidad());
    }

    @Test
    public void Test08DesgastePorUsosDebilitaMadera(){
        Madera madera = new Madera();
        DesgastePorUsos desgaste = new DesgastePorUsos(1000,3,2);
        int fuerza = desgaste.getFuerza();
        int durabilidad = madera.getDurabilidad();

        desgaste.debilitarMaterial(madera);
        desgaste.debilitarMaterial(madera);
        desgaste.debilitarMaterial(madera);

        Assert.assertEquals(durabilidad - 3 * fuerza, madera.getDurabilidad());
    }

    @Test
    public void Test09DesgastePorUsosDebilitaPiedra(){
        Piedra piedra = new Piedra();
        DesgastePorUsos desgaste = new DesgastePorUsos(1000,3,2);
        int fuerza = desgaste.getFuerza();
        int durabilidad = piedra.getDurabilidad();

        desgaste.debilitarMaterial(piedra);
        desgaste.debilitarMaterial(piedra);
        desgaste.debilitarMaterial(piedra);

        Assert.assertEquals(durabilidad - 3 * fuerza, piedra.getDurabilidad());
    }

    @Test
    public void Test10DesgastePorUsosDebilitaMetal(){
        Metal metal = new Metal();
        DesgastePorUsos desgaste = new DesgastePorUsos(1000,3,2);
        int fuerza = desgaste.getFuerza();
        int durabilidad = metal.getDurabilidad();

        desgaste.debilitarMaterial(metal);
        desgaste.debilitarMaterial(metal);
        desgaste.debilitarMaterial(metal);

        Assert.assertEquals(durabilidad - 3 * fuerza, metal.getDurabilidad());
    }

    @Test
    public void Test11DesgastePorUsosDebilitaDiamante(){
        Diamante diamante = new Diamante();
        DesgastePorUsos desgaste = new DesgastePorUsos(1000,3,2);
        int fuerza = desgaste.getFuerza();
        int durabilidad = diamante.getDurabilidad();

        desgaste.debiliatarMaterial(diamante);
        desgaste.debiliatarMaterial(diamante);
        desgaste.debiliatarMaterial(diamante);

        Assert.assertEquals(durabilidad - 3 * fuerza, diamante.getDurabilidad());
    }
}
