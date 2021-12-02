/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senai.dao;

import br.com.senai.entidade.Cargos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import org.junit.Test;
/**
 *
 * @author guilh
 */
public class CargosDaoImplTest {
    
    
    private Cargos cargos;
    private CargosDao cargosdao;
    
     public CargosDaoImplTest() throws Exception {
        cargosdao = new CargosDaoImpl();        
    }
    //@Test
    public void testSalvar() throws Exception {
        cargos = new Cargos("Gerente");
        cargosdao.salvar(cargos);
        System.out.println("Salvar");
    }
    
    //@Test
    public void testAlterar() throws Exception {
        buscarCargosBD();
        cargos.setNomeCargo("Gerente2");
        cargosdao.alterar(cargos);
        System.out.println("Alterar");
    }
    
    //@Test
    public void testExcluir() throws Exception {
        buscarCargosBD();
        System.out.println("Id_Cargos" + cargos.getIdCargo());
        cargosdao.excluir(cargos.getIdCargo());
        System.out.println("Excluir");
    }
    
    //@Test
    public void testPesquisarPorIdCArgos() throws Exception {
        buscarCargosBD();
        Cargos cargosNew = cargosdao.pesquisarPorId(cargos.getIdCargo());
        mostrarAparelhosAcademia(cargosNew);
    }
    
    @Test
    public void testePesquisarCArgosPorNome() throws Exception {
        buscarCargosBD();
        List<Cargos> cargo = cargosdao
                .pesquisarPorNome(cargos.getNomeCargo());
        for(Cargos aparelhosAcademia : cargo) {
            mostrarAparelhosAcademia(aparelhosAcademia);
        }
            System.out.println("Pesquisar por nome!");
    }
    
    private void mostrarAparelhosAcademia(Cargos ap) {
        System.out.println("Id_cargo: " + ap.getIdCargo());
        System.out.println("Nome_cargo: " + ap.getNomeCargo());

    }
    
    public Cargos buscarCargosBD() throws Exception {
        String consulta = "SELECT * FROM Cargos";
        Connection conn = Sa_Academia_Conexao.abrirConexao();
        PreparedStatement pstm = conn.prepareStatement(consulta);
        ResultSet resultado = pstm.executeQuery();
        if(resultado.next()) {
            cargos = new Cargos();
            cargos.setNomeCargo(resultado.getString("Nome_cargo"));
            cargos.setIdCargo(resultado.getInt("Id_cargo"));
        }else {
            testSalvar();
        }
        return cargos;
    }
     

     
     
}
