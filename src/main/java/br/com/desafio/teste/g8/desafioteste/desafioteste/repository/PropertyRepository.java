package br.com.desafio.teste.g8.desafioteste.desafioteste.repository;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyRepository implements IRepository<Property> {
    private Map<String, Property> propertiesMap = new HashMap<>();


    @Override
    public Property save(Property entity) {
        return this.propertiesMap.put(entity.getName(), entity);
    }

    @Override
    public List<Property> findAll() {
        return new ArrayList<>(this.propertiesMap.values());
    }

    @Override
    public Property findByName(String name) {
        return this.propertiesMap.get(name);
    }

    @Override
    public Property update(String name, Property entity) {
        return this.propertiesMap.put(name, entity);
    }

    @Override
    public void delete(String name) {
        this.propertiesMap.remove(name);
    }
}