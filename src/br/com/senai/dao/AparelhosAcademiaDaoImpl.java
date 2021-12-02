
package br.com.senai.dao;

import br.com.senai.entidade.AparelhosAcademia;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AparelhosAcademiaDaoImpl implements AparelhosAcademiaDao {
    
    private Connection conexao;
    private PreparedStatement prepareInstrucao;
    private ResultSet resultado;

    @Override
    public void salvar(Object object) throws Exception {
        //classe recebe atributos do tipo object e converte para tipo aparelhosacademia
        AparelhosAcademia aparelhosAcademia = (AparelhosAcademia) object;
        String instrucao = "INSERT INTO Aparelhos_Academia (Id_Aparelhos, Nome_Aparelhos, Data_Compra) "
                + "VALUES (nextval('Id_Aparelhos_Academia'), ?, ?)";
        //insert para mandar dados ao banco
        try {
            //bloco código get valores set valores insert
            conexao = Sa_Academia_Conexao.abrirConexao();
            //código para mandar os valores para o insert
            prepareInstrucao = conexao.prepareStatement(instrucao, Statement.RETURN_GENERATED_KEYS);
            prepareInstrucao.setString(1, aparelhosAcademia.getNomeAparelhos());
            prepareInstrucao.setDate(2, aparelhosAcademia.getDataCompra());
            //códigos para executar os comendos acima
            prepareInstrucao.executeUpdate();
            resultado = prepareInstrucao.getGeneratedKeys();
            resultado.next();
            int id = resultado.getInt(1);
            aparelhosAcademia.setIdAparelhos(id);            
        } catch (Exception e) {
            //código para erro
            System.out.println("Aparelho não salvo na tabela Aparelhos_Academia!" + e.getMessage());
        }finally{
            conexao.close();
            prepareInstrucao.close();
        }
    }

    @Override
    public void alterar(Object object) throws Exception {
        AparelhosAcademia aparelhosAcademia = (AparelhosAcademia) object;
        String instrucao = "UPDATE Aparelhos_Academia SET Nome_Aparelhos = ?, Data_Compra = ?"
                + "WHERE Id_Aparelhos = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            prepareInstrucao = conexao.prepareStatement(instrucao);
            prepareInstrucao.setString(1, aparelhosAcademia.getNomeAparelhos());
            prepareInstrucao.setDate(2, aparelhosAcademia.getDataCompra());
            prepareInstrucao.setInt(3, aparelhosAcademia.getIdAparelhos());
            prepareInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("Aparelho não alterado na tabela Aparelhos_Academia!" + e.getMessage());
        }finally{
            conexao.close();
            prepareInstrucao.close();
        }
    }

    @Override
    public void excluir(int IdAparelhos) throws Exception {
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            prepareInstrucao = conexao.prepareStatement("DELETE FROM Aparelhos_Academia WHERE Id_Aparelhos = ?");
            prepareInstrucao.setInt(1, IdAparelhos);
            prepareInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("Aparelho não deletado na tabela Aparelhos_Academia!" + e.getMessage());
        }finally{
            conexao.close();
            prepareInstrucao.close();
        }
    }
       
    @Override
    public AparelhosAcademia pesquisaPorId(int IdAparelhos) throws Exception {
        AparelhosAcademia aparelhosAcademia = null;
        String consulta = "SELECT * FROM Aparelhos_Academia WHERE Id_Aparelhos = ?";        
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            prepareInstrucao = conexao.prepareStatement(consulta);
            prepareInstrucao.setInt(1, IdAparelhos);
            resultado = prepareInstrucao.executeQuery();
            if(resultado.next()) {
                aparelhosAcademia = new AparelhosAcademia(
                        resultado.getString("Nome_Aparelhos"), resultado.getDate("Data_Compra"));                
                aparelhosAcademia.setIdAparelhos(resultado.getInt(IdAparelhos));
            }else{
                System.out.println("Aparelho não encontrado, pesquise por Id válido");
            }
        } catch (Exception e) {
            System.out.println("sua pesquisa por Id falhou, erro na conexão!" + e.getMessage());
        }finally {
            conexao.close();
            prepareInstrucao.close();
        }
        
        return aparelhosAcademia;
    }

    @Override
    public List<AparelhosAcademia> pesquisarPorNome(String nomeAparelhos) throws Exception {
        String consulta = "SELECT * FROM Aparelhos_Academia WHERE Nome_Aparelhos LIKE ?";
        List<AparelhosAcademia> aparelhosAcademias = new ArrayList<>();
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            prepareInstrucao = conexao.prepareStatement(consulta);
            prepareInstrucao.setString(1, "%" + nomeAparelhos + "%");
            resultado = prepareInstrucao.executeQuery();
            AparelhosAcademia aparelhosAcademia;
            while (resultado.next()) {
                aparelhosAcademia = new AparelhosAcademia();
                aparelhosAcademia.setIdAparelhos(resultado.getInt("Id_Aparelhos"));
                aparelhosAcademia.setNomeAparelhos(resultado.getString("Nome_Aparelhos"));
                aparelhosAcademia.setDataCompra(resultado.getDate("Data_Compra"));
                aparelhosAcademias.add(aparelhosAcademia);                
            }
        } catch (Exception e) {
            System.out.println("sua pesquisa por nome falhou, erro na conexão!" + e.getMessage());
        }finally{
            conexao.close();
            prepareInstrucao.close();
            resultado.close();
        }
        return aparelhosAcademias;
    }
    
    public List<AparelhosAcademia> pesquisarPorId(int idAparelhos) throws SQLException {
        String consulta = "SELECT * FROM Aparelhos_Academia WHERE Id_Aparelhos = ?";
        List<AparelhosAcademia> aparelhosAcademias = new ArrayList<>();
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            prepareInstrucao = conexao.prepareStatement(consulta);
            prepareInstrucao.setString(1, "%" + idAparelhos + "%");
            resultado = prepareInstrucao.executeQuery();
            AparelhosAcademia aparelhosAcademia;
            while (resultado.next()) {
                aparelhosAcademia = new AparelhosAcademia();
                aparelhosAcademia.setIdAparelhos(resultado.getInt("Id_Aparelhos"));
                aparelhosAcademia.setNomeAparelhos(resultado.getString("Nome_Aparelhos"));
                aparelhosAcademia.setDataCompra(resultado.getDate("Data_Compra"));
                aparelhosAcademias.add(aparelhosAcademia);                
            }
        } catch (Exception e) {
            System.out.println("sua pesquisa por nome falhou, erro na conexão!" + e.getMessage());
        }finally{
            conexao.close();
            prepareInstrucao.close();
            resultado.close();
        }
        return aparelhosAcademias;
    }

}
