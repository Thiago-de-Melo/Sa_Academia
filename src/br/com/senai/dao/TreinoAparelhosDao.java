
package br.com.senai.dao;

import br.com.senai.entidade.TreinoAparelhos;
import java.util.List;




public interface TreinoAparelhosDao extends BaseDao{
    
    TreinoAparelhos pesquisarPorId(int id) throws Exception;
    
    List<TreinoAparelhos> pesuisarPorNome(String nome) throws Exception;
    
}
