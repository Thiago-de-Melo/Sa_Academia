
package br.com.senai.dao;

import br.com.senai.entidade.Plano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;


public class PlanoDaoImplTest {
    
    private Plano plano;
    private PlanoDao planoDao;

    public PlanoDaoImplTest() {
        planoDao = new PlanoDaoImpl();
    }
    
    //@Test
    public void testSalvar() throws Exception {
        plano = new Plano("Promoção", "pagamento realizado por quantidade de meses pagos", 60);
        // metodo da classe PerfilDaoImplTest que retorna um perfil do BD
        planoDao.salvar(plano);
        System.out.println("salvar");
    }
    
    //@Test
    public void testAlterar() throws Exception {
        buscarPlanoBD();
        plano.setPlanos("qualquer um");
        plano.setDescricao("Era só para teste");
        plano.setValorPlano(11);
        planoDao.alterar(plano);
        System.out.println("alterar");
    }
    
    //@Test
    public void testExcluir() throws Exception {
        buscarPlanoBD();
        planoDao.excluir(plano.getIdPlano());
        System.out.println("excluir");
    }
    
    public Plano buscarPlanoBD() throws Exception {
        String consulta = "SELECT * FROM Plano ";
        Connection conn = Sa_Academia_Conexao.abrirConexao();
        PreparedStatement pstm = conn.prepareStatement(consulta);
        ResultSet resultado = pstm.executeQuery();
        if (resultado.next()) {
            plano = new Plano();
            plano.setPlanos(resultado.getString("planos"));
            plano.setDescricao(resultado.getString("descricao"));
            plano.setValorPlano(resultado.getInt("valor_plano"));
            plano.setIdPlano(resultado.getInt("id_plano"));
        } else {
            testSalvar();
        }
        return plano;
    }
    
    
}
