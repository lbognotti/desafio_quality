package br.com.desafio.teste.g8.desafioteste.desafioteste.repository;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.District;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DistrictRepository implements IRepository<District>{

    private  Map<String, District> districtMap = new HashMap<>();

    @Override
    public District save(District entity) {
        return this.districtMap.put(entity.getName(), entity);
    }

    @Override
    public List<District> findAll() {
        return new ArrayList<>(this.districtMap.values());
    }

    @Override
    public District findByName(String name) {
        return this.districtMap.get(name);
    }

    @Override
    public District update(String name, District entity) {
        return this.districtMap.put(name, entity);
    }

    @Override
    public void delete(String name) {
         this.districtMap.remove(name);
    }
}
