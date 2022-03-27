package model.dao;

/**
 *
 * @author frizzocamila
 */
public class DaoFactory {

    public static TarefaDaoJpa novaTarefaDao() throws Exception {
        return new TarefaDaoJpa();
    }
}
