package com.tsayun.coffemachine.service;

import com.tsayun.coffemachine.bean.DrinkInStorage;
import com.tsayun.coffemachine.service.exception.ServiceException;

import java.util.List;

public interface CoffeeMachineService {
    List<DrinkInStorage> getCatalog() throws ServiceException;
}
