package br.com.desafio.teste.g8.desafioteste.desafioteste.repository;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.District;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wolsen
 * @description Classe para repositório (deixa guardado) de Districts (bairros)
 */
@Component
public class DistrictRepository implements IRepository<District>{

    private  Map<String, District> districtMap = new HashMap<>();

    /**
     * @author Wolsen
     * @description Salvar um district no respositorio
     * @param entity instancia a ser salva no repository
     * @return retorna o district que foi salvo
     */
    @Override
    public District save(District entity) {
        this.districtMap.put(entity.getName(), entity);
        return this.districtMap.get(entity.getName());
    }

    /**
     * @author Wolsen
     * @description Salvar um district no respositorio
     * @param entity instancia a ser salva no repository
     * @return retorna o district que foi salvo
     */
    @Override
    public List<District> findAll() {
        return new ArrayList<>(this.districtMap.values());
    }

    /**
     * @author Wolsen
     * @description Procura um district
     * @param entity procura um
     * @return retorna o district que foi salvo
     */
    @Override
    public District findByName(String name) {
        return this.districtMap.get(name);
    }


    /**
     * @author Wolsen
     * @description Atualiza os dados de um district. Parte do tratamento precisa acontecer no controlller para adicionar erradamente
     * @param name nome do bairro a ser atualizado
     * @param entity instancia que tem os dados a substituirem o district atual
     * @return retorna o bairro atualizado
     */
    @Override
    public District update(String name, District entity) {
        this.districtMap.put(name, entity);
        return this.districtMap.get(entity.getName());
    }

    /**
     * @author Wolsen
     * @description deleta um district com base em seu nome como chave de busca
     * @param name nome que sera usado como chave para realizar a busca e deletar
     * @return void, nao há retorno
     */
    @Override
    public void delete(String name) {
         this.districtMap.remove(name);
    }
}
