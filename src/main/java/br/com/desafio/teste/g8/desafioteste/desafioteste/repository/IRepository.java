package br.com.desafio.teste.g8.desafioteste.desafioteste.repository;

import java.util.List;

/**
 * @author Ronaldd Pinho
 * @interface Interface de repositório que define os métodos de interação com o
 * armazenamento de dados, como inserção, busca, deleção, etc.
 * @param <E> Tipo da entidade
 */
public interface IRepository<E> {

    /**
     * @author Ronaldd Pinho
     * @description Armazena uma nova entidade no repositório.
     * @param entity Objeto da classe de entidade
     * @return Objeto criado na base de dados
     */
    E save(E entity);

    /**
     * @author Ronaldd Pinho
     * @description Retorna a lista de todas as entidades armazenadas no repositório.
     * @return Lista de objetos da entidade do tipo E.
     */
    List<E> findAll();

    /**
     * @author Ronaldd Pinho
     * @description Retorna um objeto da entidade buscando pelo seu nome (String).
     * @param name Nome para efetuar a busca
     * @return Objeto da entidade E.
     */
    E findByName(String name);

    /**
     * @author Ronaldd Pinho
     * @description Atualiza um registro no repositório buscando por seu nome.
     * @param name Nome relaciona ao objeto registrado.
     * @param entity Novo objeto da entidade.
     * @return O objeto da entidade atualizado.
     */
    E update(String name, E entity);

    /**
     * @author Ronaldd Pinho
     * @description Deleta um registro do repositório a partir do seu nome.
     * @param name Nome para buscar o registro.
     */
    void delete(String name);
}
