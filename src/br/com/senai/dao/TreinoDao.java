
package br.com.senai.dao;

import br.com.senai.entidade.Treino;
import java.util.List;


public interface TreinoDao extends BaseDao{
    
    Treino pesuisarPorId(int id_treino) throws Exception;
    
    List<Treino> pesquisarPorNome(String treino) throws Exception;
    
}
