/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senai.dao;
import br.com.senai.entidade.Cargos;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class CargosDaoImpl implements CargosDao{
    
    private Connection conexao;
    private PreparedStatement prepareInstrucao;
    private ResultSet resultado;

    @Override
    public Cargos pesquisarPorId(int idCargo) throws Exception {
        Cargos cargos = null;
        String consulta = "SELECT * FROM Cargos WHERE Id_Cargo = ?";        
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            prepareInstrucao = conexao.prepareStatement(consulta);
            prepareInstrucao.setInt(1, idCargo);
            resultado = prepareInstrucao.executeQuery();
            if(resultado.next()) {
                cargos = new Cargos(
                        resultado.getString("nome_cargo"));                
                cargos.setIdCargo(resultado.getInt("id_cargo"));
            }else{
                System.out.println("Cargo não encontrado, pesquise por Id válido");
            }
        } catch (Exception e) {
            System.out.println("sua pesquisa por Id falhou, erro na conexão!" + e.getMessage());
        }finally {
            conexao.close();
            prepareInstrucao.close();
        }
        
        return cargos;    }

    @Override
    public List<Cargos> pesquisarPorNome(String nomeCargo) throws Exception {
        String consulta = "SELECT * FROM Cargos WHERE Nome_Cargo LIKE ?";
        List<Cargos> cargos = new ArrayList<>();
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            prepareInstrucao = conexao.prepareStatement(consulta);
            prepareInstrucao.setString(1, "%" + nomeCargo + "%");
            resultado = prepareInstrucao.executeQuery();
            Cargos cargo;
            while (resultado.next()) {
                cargo = new Cargos();
                cargo.setIdCargo(resultado.getInt("Id_Cargo"));
                cargo.setNomeCargo(resultado.getString("Nome_Cargo"));
                cargos.add(cargo);                
            }
        } catch (Exception e) {
            System.out.println("sua pesquisa por nome falhou, erro na conexão!" + e.getMessage());
        }finally{
            conexao.close();
            prepareInstrucao.close();
            resultado.close();
        }
        return cargos;
    }

    @Override
    public void salvar(Object object) throws Exception {
        //classe recebe atributos do tipo object e converte para tipo aparelhosacademia
        Cargos cargos = (Cargos) object;
        String instrucao = "INSERT INTO cargos (id_cargo, nome_cargo) "
                + "VALUES (nextval('sequence_id_cargo'), ?)";
        //insert para mandar dados ao banco
        try {
            //bloco código get valores set valores insert
            conexao = Sa_Academia_Conexao.abrirConexao();
            //código para mandar os valores para o insert
            prepareInstrucao = conexao.prepareStatement(instrucao, Statement.RETURN_GENERATED_KEYS);
            prepareInstrucao.setString(1, cargos.getNomeCargo());
            //códigos para executar os comendos acima
            prepareInstrucao.executeUpdate();
            resultado = prepareInstrucao.getGeneratedKeys();
            resultado.next();
            int id = resultado.getInt(1);
            cargos.setIdCargo(id);            
        } catch (Exception e) {
            //código para erro
            System.out.println("Cargo não salvo na tabela Cargos!" + e.getMessage());
        }finally{
            conexao.close();
            prepareInstrucao.close();
        }    }

    @Override
    public void alterar(Object object) throws Exception {
        Cargos cargos = (Cargos) object;
        String instrucao = "UPDATE Cargos SET nome_cargo = ?"
                + "WHERE id_cargo = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            prepareInstrucao = conexao.prepareStatement(instrucao);
            prepareInstrucao.setString(1, cargos.getNomeCargo());
            prepareInstrucao.setInt(2, cargos.getIdCargo());
            prepareInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("Carggo não alterado na tabela Cargos!" + e.getMessage());
        }finally{
            conexao.close();
            prepareInstrucao.close();
        }    
    }

    @Override
    public void excluir( int IdCargo) throws Exception {
    try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            prepareInstrucao = conexao.prepareStatement("DELETE FROM cargos WHERE id_cargo = ?");
            prepareInstrucao.setInt(1, IdCargo);
            prepareInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("Cargo não deletado na tabela Cargos!" + e.getMessage());
        }finally{
            conexao.close();
            prepareInstrucao.close();
        }    
    }
    
    
    
    
    
    
}
