package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.MapRepository;
import com.fogbank.springsecurity.entities.Map;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImp implements MapService{

    @Autowired
    private MapRepository mapRepository;

    @Transactional
    public Map saveMap(Map map) {
        return mapRepository.save(map);
    }
    public Map getCoordinatesByProductId(Integer productId) {
        Map map = mapRepository.findByProductId(productId);
        if (map != null) {
            return new Map(map.getLatitude(), map.getLongitude());
        } else {
            // Gérer le cas où aucun enregistrement de carte n'est trouvé pour cet ID de produit
            return null;
        }
    }

}
