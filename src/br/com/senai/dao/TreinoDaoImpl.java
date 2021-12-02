
package br.com.senai.dao;

import br.com.senai.entidade.Treino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TreinoDaoImpl implements TreinoDao{
    
    private Connection conexao;
    private PreparedStatement preparaInstrucao;
    private ResultSet resultado;
    
    @Override
    public void salvar(Object object) throws Exception {
        Treino treino = (Treino) object;
        String sql = "INSERT INTO treino(id_treino, treinos, descricao, cpf) "
                + "VALUES(nextval('sequence_treino'), ?, ?, ?)";
        
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparaInstrucao.setString(1, treino.getTreinos());
            preparaInstrucao.setString(2, treino.getDescricao());
            preparaInstrucao.setInt(3, treino.getCadastroCliente().getCpf());
            preparaInstrucao.executeUpdate();
            resultado = preparaInstrucao.getGeneratedKeys();
            resultado.next();
            treino.setIdTreino(resultado.getInt(1));
            //TODO CRIAR LUPE PARA SALVAR A LISTA DE EQUIPAMENTOS PARA TREINO NA TABELA TREINO APARELHOS
           
//            for (int i = 0; i < 10; i++) {
//                
//            }
        } catch (Exception e) {
            System.out.println("erro ao salvar treino " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }
        
    }

    @Override
    public void alterar(Object object) throws Exception {
        Treino treino = (Treino) object;
        String sql = "UPDATE treino SET treinos = ?, descricao = ? "
                + "WHERE id_treino = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql);
            preparaInstrucao.setString(1, treino.getTreinos());
            preparaInstrucao.setString(2, treino.getDescricao());            
            preparaInstrucao.setInt(3, treino.getIdTreino());
            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao alterar treino " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }
    }

    
    @Override
    public void excluir(int id_treino) throws Exception {
        String sql = "DELETE FROM treino WHERE id_treino = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql);
            preparaInstrucao.setInt(1, id_treino);
            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao excluir treino " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }
    }
    
    
    @Override
    public Treino pesuisarPorId(int id_treino) throws Exception {
        Treino treino = null;

        String consulta = "SELECT * FROM treino WHERE u.id = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(consulta);
            preparaInstrucao.setInt(1, id_treino);
            resultado = preparaInstrucao.executeQuery();
            if (resultado.next()) {
                treino = new Treino();
                treino.setIdTreino(id_treino);
                treino.setTreinos(resultado.getString("treinos"));
                treino.setDescricao(resultado.getString("descricao"));
            }
        } catch (Exception e) {
            System.out.println("erro pesquisar por id do treino " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
        return treino;
    }

    @Override
    public List<Treino> pesquisarPorNome(String treinos) throws Exception {
        Treino treino;
        List<Treino> treinos1 = new ArrayList<>();
        String consulta = "SELECT * FROM treino WHERE treinos LIKE ?"; //TODO fazer join com cliente
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(consulta);
            preparaInstrucao.setString(1, "%" + treinos + "%");
            resultado = preparaInstrucao.executeQuery();
            while (resultado.next()) {
                treino = new Treino();
                treino.setIdTreino(resultado.getInt("id_treino"));
                treino.setTreinos(resultado.getString("treinos"));
                treino.setDescricao(resultado.getString("descricao"));
                treinos1.add(treino);
            }
        } catch (Exception e) {
            System.out.println("erro pesquisar por id " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
        return treinos1;
    }
    
}
