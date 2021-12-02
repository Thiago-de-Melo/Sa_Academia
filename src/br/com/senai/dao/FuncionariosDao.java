
package br.com.senai.dao;

import br.com.senai.entidade.Funcionarios;
import java.util.List;


public interface FuncionariosDao extends BaseDao{
    
    Funcionarios pesquisarPorId(int id) throws Exception;
    
    List<Funcionarios> pesuisarPorNome(String nome) throws Exception;
    
}
