
package br.com.senai.dao;
    
import br.com.senai.entidade.Plano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlanoDaoImpl implements PlanoDao{
    
    private Connection conexao;
    private PreparedStatement preparaInstrucao;
    private ResultSet resultado;

   
    @Override
    public void salvar(Object object) throws Exception {
        Plano plano = (Plano) object;
        String sql = "INSERT INTO Plano(Id_Plano, Planos, Descricao, Valor_Plano)"
                + " VALUES(nextval('Sequence_Plano'), ?, ?, ?)";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparaInstrucao.setString(1, plano.getPlanos());
            preparaInstrucao.setString(2, plano.getDescricao());
            preparaInstrucao.setInt(3, plano.getValorPlano());
            preparaInstrucao.executeUpdate();
            resultado = preparaInstrucao.getGeneratedKeys();
            resultado.next();
            plano.setIdPlano(resultado.getInt(1));
        } catch (Exception e) {
            System.out.println("erro ao salvar plano!" + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }
    }

    @Override
    public void alterar(Object object) throws Exception {
        Plano plano = (Plano) object;
        String sql = "UPDATE Plano SET planos = ?, descricao = ?, valor_plano = ?"
                + " WHERE Id_Plano = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql);
            preparaInstrucao.setString(1, plano.getPlanos());
            preparaInstrucao.setString(2, plano.getDescricao());
            preparaInstrucao.setInt(3, plano.getValorPlano());
            preparaInstrucao.setInt(4, plano.getIdPlano());
            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao alterar plano!" + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM Plano WHERE Id_Plano = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql);
            preparaInstrucao.setInt(1, id);
            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao excluir plano!" + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }
    }
    
     @Override
    public Plano pesquisarPorId(int id_plano) throws Exception {
        Plano plano = null;

        String consulta = "SELECT * FROM Plano WHERE id_plano = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(consulta);
            preparaInstrucao.setInt(1, id_plano);
            resultado = preparaInstrucao.executeQuery();
            if (resultado.next()) {
                plano = new Plano();
                plano.setIdPlano(id_plano);
                plano.setPlanos(resultado.getString("planos"));
                plano.setDescricao(resultado.getString("descricao"));
                plano.setValorPlano(resultado.getInt("valor_plano"));
            }
        } catch (Exception e) {
            System.out.println("erro pesquisar por id do palno!" + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
        return plano;
    }

    @Override
    public List<Plano> pesquisarPorNome(String planos) throws Exception {
        Plano plano;
        List<Plano> planosLista = new ArrayList<>();
        String consulta = "SELECT *FROM Plano WHERE planos LIKE ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(consulta);
            preparaInstrucao.setString(1, "%" + planos + "%");
            resultado = preparaInstrucao.executeQuery();
            while (resultado.next()) {
                plano = new Plano();
                plano.setIdPlano(resultado.getInt("id_plano"));
                plano.setPlanos(resultado.getString("planos"));
                plano.setDescricao(resultado.getString("descricao"));
                plano.setValorPlano(resultado.getInt("valor_plano"));
            }
        } catch (Exception e) {
            System.out.println("erro pesquisar por nome do plano!" + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
        return planosLista;
    }

    @Override
    public List<Plano> pesquisarTodo() throws Exception {
                List<Plano> planoss = new ArrayList<>();
        String consulta = "SELECT * FROM Plano";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(consulta);
            resultado = preparaInstrucao.executeQuery();
            Plano plano;
            while (resultado.next()) {
                plano = new Plano();
                plano.setIdPlano(resultado.getInt("id"));
                plano.setPlanos(resultado.getString("nome"));                
                planoss.add(plano);
            }
        } catch (Exception e) {
            System.out.println("erro pesquisar todos os perfils " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
        return planoss;
    }
    
    
    
    
    
}
