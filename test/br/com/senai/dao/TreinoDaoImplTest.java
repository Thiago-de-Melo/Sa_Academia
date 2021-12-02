
package br.com.senai.dao;

import br.com.senai.entidade.Treino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;


public class TreinoDaoImplTest {
    
    private Treino treino;
    private TreinoDao treinoDao;

    public TreinoDaoImplTest() {
        treinoDao = new TreinoDaoImpl();
    }
    
    @Test
    public void testSalvar() throws Exception {
        treino = new Treino("May Thai", "Luta Tailandesa");
        treinoDao.salvar(treino);
        System.out.println("salvar");
    }
    
    //@Test
    public void testAlterar() throws Exception {
        buscarTreinoBD();
        treino.setTreinos("Treino Alterado");
        treino.setDescricao("Descricâo Alterada");
        treinoDao.alterar(treino);
        System.out.println("alterar");
    }
    
    @Test
    public void testExcluir() throws Exception {
        buscarTreinoBD();
        treinoDao.excluir(treino.getIdTreino());
        System.out.println("excluir");
    }
    
    public Treino buscarTreinoBD() throws Exception {
        String consulta = "SELECT * FROM treino";
        Connection conn = Sa_Academia_Conexao.abrirConexao();
        PreparedStatement pstm = conn.prepareStatement(consulta);
        ResultSet resultado = pstm.executeQuery();
        if (resultado.next()) {
            treino = new Treino();
            treino.setTreinos(resultado.getString("treinos"));
            treino.setDescricao(resultado.getString("descricao"));
            treino.setIdTreino(resultado.getInt("id_treino"));
        } else {
            testSalvar();
        }
        return treino;
    }
    
}
