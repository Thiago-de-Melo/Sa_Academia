
package br.com.senai.dao;


public interface BaseDao {    
    
    void salvar(Object object) throws Exception;
    
    void alterar(Object object) throws Exception;
    
    void excluir(int id) throws Exception;    
    
}
