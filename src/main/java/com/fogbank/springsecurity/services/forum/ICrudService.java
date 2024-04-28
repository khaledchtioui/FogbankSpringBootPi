package com.fogbank.springsecurity.services.forum;

import java.util.List;

public interface ICrudService <T>{

    List<T> chargerTous();
    T ajouter(T t);
    void supprimer(T t);
    T modifier(T t);

}
