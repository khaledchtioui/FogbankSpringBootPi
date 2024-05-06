package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.entities.Map;

public interface MapService {
    Map saveMap(Map map);
    Map getCoordinatesByProductId(Integer productId);

}
