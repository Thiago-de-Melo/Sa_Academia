
package br.com.senai.dao;

import br.com.senai.entidade.CadastroCliente;
import java.util.List;


public interface CadastroClienteDao extends BaseDao{

    CadastroCliente pesquisarPorId(int id) throws Exception;

    List<CadastroCliente> pesquisarPorNome(String nome) throws Exception;
    
    CadastroCliente logar(Integer cpf, String senha) throws Exception;

}
