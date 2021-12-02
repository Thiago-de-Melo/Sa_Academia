
package br.com.senai.dao;

import br.com.senai.entidade.AparelhosAcademia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import org.junit.Test;

public class AparelhosAcademiaDaoImplTest  {
    
    private AparelhosAcademia aparelhosAcademia;
    private AparelhosAcademiaDao aparelhosAcademiaDao;

    public AparelhosAcademiaDaoImplTest() throws Exception {
        aparelhosAcademiaDao = new AparelhosAcademiaDaoImpl();        
    }
    
    @Test
    public void testSalvar() throws Exception {
        SimpleDateFormat formatandoData = new SimpleDateFormat("dd/mm/yyyy");        
        //aparelhosAcademia = new AparelhosAcademia("Bicicleta", "10/10/2020");
        aparelhosAcademiaDao.salvar(aparelhosAcademia);
        System.out.println("Salvar");
    }
    
    //@Test
    public void testAlterar() throws Exception {
        buscarAparelhosBD();
        aparelhosAcademia.setNomeAparelhos("Alavanca");
        aparelhosAcademiaDao.alterar(aparelhosAcademia);
        System.out.println("Alterar");
    }
    
    //@Test
    public void testExcluir() throws Exception {
        buscarAparelhosBD();
        System.out.println("Id_Aparelhos" + aparelhosAcademia.getIdAparelhos());
        aparelhosAcademiaDao.excluir(aparelhosAcademia.getIdAparelhos());
        System.out.println("Excluir");
    }
    
    //@Test
    public void testPesquisarPorIdAparelhos() throws Exception {
        buscarAparelhosBD();
        AparelhosAcademia aparelhosAcademiaNew = aparelhosAcademiaDao.pesquisaPorId(aparelhosAcademia.getIdAparelhos());
        mostrarAparelhosAcademia(aparelhosAcademiaNew);
    }
    
    //@Test
    public void testePesquisarAparelhosPorNome() throws Exception {
        buscarAparelhosBD();
        List<AparelhosAcademia> aparelhosAcademias = aparelhosAcademiaDao
                .pesquisarPorNome(aparelhosAcademia.getNomeAparelhos());
        for(AparelhosAcademia aparelhosAcademia : aparelhosAcademias) {
            mostrarAparelhosAcademia(aparelhosAcademia);
        }
            System.out.println("Pesquisar por nome!");
    }
    
    private void mostrarAparelhosAcademia(AparelhosAcademia ap) {
        System.out.println("Id_Aparelhos: " + ap.getIdAparelhos());
        System.out.println("Nome_Aparelhos: " + ap.getNomeAparelhos());
        System.out.println("Data_Compra: " + ap.getDataCompra());
    }
    
    public AparelhosAcademia buscarAparelhosBD() throws Exception {
        String consulta = "SELECT * FROM Aparelhos_Academia";
        Connection conn = Sa_Academia_Conexao.abrirConexao();
        PreparedStatement pstm = conn.prepareStatement(consulta);
        ResultSet resultado = pstm.executeQuery();
        if(resultado.next()) {
            aparelhosAcademia = new AparelhosAcademia();
            aparelhosAcademia.setNomeAparelhos(resultado.getString("Nome_Aparelhos"));
            aparelhosAcademia.setDataCompra(resultado.getDate("Data_Compra"));
            aparelhosAcademia.setIdAparelhos(resultado.getInt("Id_Aparelhos"));
        }else {
            testSalvar();
        }
        return aparelhosAcademia;
    }
        
}
