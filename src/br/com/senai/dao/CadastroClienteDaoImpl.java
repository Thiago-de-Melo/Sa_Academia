
package br.com.senai.dao;

import br.com.senai.entidade.AparelhosAcademia;
import br.com.senai.entidade.CadastroCliente;
import br.com.senai.entidade.Plano;
import br.com.senai.entidade.Treino;
import br.com.senai.entidade.TreinoAparelhos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CadastroClienteDaoImpl implements CadastroClienteDao{
    
    private Connection conexao;
    private PreparedStatement preparaInstrucao;
    private ResultSet resultado;
    

    @Override
    public void salvar(Object object) throws Exception {
        CadastroCliente cadastroCliente = (CadastroCliente) object;
        String instrucao = "insert into Cadastro_Cliente ("
                + "CPF, Nome, Rua, Bairro, Telefone, Data_Nascimento, Senha, Sobrenome, Id_Plano, Whatsapp, Id_Treino) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(instrucao, Statement.RETURN_GENERATED_KEYS);
            preparaInstrucao.setInt(1, cadastroCliente.getCpf());
            preparaInstrucao.setString(2, cadastroCliente.getNome());
            preparaInstrucao.setString(3, cadastroCliente.getRua());
            preparaInstrucao.setString(4, cadastroCliente.getBairro());
            preparaInstrucao.setInt(5, cadastroCliente.getTelefone());
            preparaInstrucao.setString(6, cadastroCliente.getDataNascimento());
            preparaInstrucao.setString(7, cadastroCliente.getSenha());
            preparaInstrucao.setString(8, cadastroCliente.getSobrenome());
            preparaInstrucao.setInt(9, cadastroCliente.getPlano().getIdPlano());
            preparaInstrucao.setInt(10, cadastroCliente.getTreino().getIdTreino());
            /** linha que manda os valores para o insert */
            preparaInstrucao.executeUpdate();
            resultado = preparaInstrucao.getGeneratedKeys();
            resultado.next();
            int CPF = resultado.getInt(1);
            cadastroCliente.setCpf(CPF);
        } catch (Exception e) {
            /** linha para executar mensagens de erro de conexção com o banco */
            System.out.println("Erro ao salvar cadastro cliente! " + e.getMessage());
        } finally {
            /** codigo para que quando de erro feche a conexção com o banco */
            conexao.close();
            preparaInstrucao.close();
        }                
    }

    @Override
    public void alterar(Object object) throws Exception {
        CadastroCliente cadastroCliente = (CadastroCliente) object;
        String sql = "UPDATE Cadastro_Cliente SET "
                + "nome = ?, rua = ?, bairro = ?, telefone = ?, data_nascimento = ?, "
                + "senha = ?, sobrenome = ?, id_Plano = ?, whatsapp = ?, id_Treino = ? WHERE CPF = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql);
            preparaInstrucao.setString(1, cadastroCliente.getNome());
            preparaInstrucao.setString(2, cadastroCliente.getRua());
            preparaInstrucao.setString(3, cadastroCliente.getBairro());
            preparaInstrucao.setInt(4, cadastroCliente.getTelefone());
            preparaInstrucao.setString(5, cadastroCliente.getDataNascimento());
            preparaInstrucao.setString(6, cadastroCliente.getSenha());
            preparaInstrucao.setString(7, cadastroCliente.getSobrenome());
            preparaInstrucao.setInt(8, cadastroCliente.getPlano().getIdPlano());
            preparaInstrucao.setInt(9, cadastroCliente.getWhatsapp());
            preparaInstrucao.setInt(10, cadastroCliente.getTreino().getIdTreino());
            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao alterar cadastro cliente! " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        } 
    }

    @Override
    public void excluir(int id) throws Exception {
            String sql = "DELETE FROM Cadastro_Cliente WHERE id = ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql);
            preparaInstrucao.setInt(1, id);
            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao excluir Cdastro do cliente " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }
    }
    
    @Override
    public CadastroCliente pesquisarPorId(int id) throws Exception {
        CadastroCliente cadastroCliente = null;
        String consulta = "select * from Vw_Plano where cpf = ?;";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(consulta);
            preparaInstrucao.setInt(1, cadastroCliente.getCpf());
            resultado = preparaInstrucao.executeQuery();
            if (resultado.next()) {
                cadastroCliente = new CadastroCliente();
                Plano plano = new Plano();
                cadastroCliente.setCpf(resultado.getInt("cc.cpf"));
                plano.setIdPlano(resultado.getInt("pl.id_plano"));
                plano.setValorPlano(resultado.getInt("pl.valor_plano"));
                cadastroCliente.setNome(resultado.getString("cc.nome"));
                cadastroCliente.setSobrenome(resultado.getString("cc.sobrenome"));
                cadastroCliente.setDataNascimento(resultado.getString("cc.data_nascimento"));
                cadastroCliente.setPlano(plano);
            }
        } catch (Exception e) {
            System.out.println("erro ao pesquisar por CPF cliente " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
        return cadastroCliente;
    }
    
    @Override
    public List<CadastroCliente> pesquisarPorNome(String nome) throws Exception {
        List<CadastroCliente> cadastroClientes = new ArrayList<>();
        String consulta = "SELECT cc.cpf, cc.nome, tr.id_treino, aa.nome_aparelhos, tr.treinos, aa.id_aparelhos"
                + "from Treino_Aparelhos ta"
                + "join Aparelhos_Academia aa on aa.id_aparelhos = ta.id_aparelho"
                + "join Treino tr on tr.id_treino = ta.id_treino"
                + "inner join Cadastro_Cliente cc on cc.id_treino = tr.id_treino"
                + "WHERE cc.nome LIKE ?";
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(consulta);
            preparaInstrucao.setString(1, "%" + nome + "%");
            resultado = preparaInstrucao.executeQuery();
            CadastroCliente cadastroCliente;
            Treino treino;
            TreinoAparelhos treinoAparelhos;
            AparelhosAcademia aparelhosAcademia;
            while (resultado.next()) {
                cadastroCliente = new CadastroCliente();
                treino = new Treino();
                treinoAparelhos = new TreinoAparelhos();
                aparelhosAcademia = new AparelhosAcademia();
                cadastroCliente.setCpf(resultado.getInt("cc.cpf"));
                cadastroCliente.setNome(resultado.getString("cc.nome"));
                treino.setIdTreino(resultado.getInt("tr.id_treino"));
                aparelhosAcademia.setNomeAparelhos(resultado.getString("aa.nome_aparelhos"));
                treino.setTreinos(resultado.getString("tr.treinos"));
                aparelhosAcademia.setIdAparelhos(resultado.getInt("aa.id_aparelhos"));
                cadastroCliente.setTreino(treino);
                cadastroCliente.setAparelhosAcademia(aparelhosAcademia);
                cadastroCliente.setTreinoAparelhos(treinoAparelhos);
                cadastroClientes.add(cadastroCliente);
            }
        } catch (Exception e) {
            System.out.println("erro pesquisar Clientes por nome!" + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
        return cadastroClientes;
    }

    @Override
    public CadastroCliente logar(Integer cpf, String senha) throws Exception {
                String consulta = "SELECT * FROM Cadastro_Cliente WHERE cpf = ? and senha = ?";
        CadastroCliente cadastroCliente = null;
        try {
            conexao = Sa_Academia_Conexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(consulta);
            preparaInstrucao.setInt(1, cpf);
            preparaInstrucao.setString(2, senha);
            resultado = preparaInstrucao.executeQuery();
            if (resultado.next()) {
                cadastroCliente = new CadastroCliente();
                cadastroCliente.setCpf(resultado.getInt("cpf"));
                cadastroCliente.setSenha(resultado.getString("senha"));
                cadastroCliente.setCpf(cpf);
                cadastroCliente.setSenha(senha);
            }
        } catch (Exception e) {
            System.out.println("erro ao logar cadastro do cliente!" + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
        return cadastroCliente;
    }
    
}
