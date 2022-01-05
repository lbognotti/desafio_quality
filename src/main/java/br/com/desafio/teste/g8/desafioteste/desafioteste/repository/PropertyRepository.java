package br.com.desafio.teste.g8.desafioteste.desafioteste.repository;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PropertyRepository implements IRepository<Property> {
    private Map<String, Property> propertiesMap = new HashMap<>();

    /**
     * @author Lucas Matos
     * @description Método que salva uma propriedade.
     * @param entity
     * @return Retorna uma propriedade
     */
    @Override
    public Property save(Property entity) {
        return this.propertiesMap.put(entity.getName(), entity);
    }

    /**
     * @author Lucas Matos
     * @description Método que busca todos as propridades
     * @param
     * @return Retorna uma lista com todas as propridades cadastradas
     */
    @Override
    public List<Property> findAll() {
        return new ArrayList<>(this.propertiesMap.values());
    }

    /**
     * @author Lucas Matos
     * @description Método que busca uma unica propriedade cadastrada
     * @param name
     * @return Retorna uma propriedade
     */
    @Override
    public Property findByName(String name) {
        return this.propertiesMap.get(name);
    }

    /**
     * @author Lucas Matos
     * @descripton Método que atualiza uma propriedade
     * @param name
     * @param entity
     * @return Retorna a propriedade que foi atualizada
     */
    @Override
    public Property update(String name, Property entity) {
        return this.propertiesMap.put(name, entity);
    }

    /**
     * @author Lucas Matos
     * @descripton Método que deleta uma propriedade
     * @param name
     * @return Retorna vazio
     */
    @Override
    public void delete(String name) {
        this.propertiesMap.remove(name);
    }
}