package com.spring.calculator.service;

import com.spring.calculator.model.NumberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

import com.spring.calculator.model.Number;

public class NumberServiceImpl implements NumberService {

    @Autowired
    @Qualifier("NumberDAO")
    private NumberDAO numberDAO;

    @Override
    public List<Number> getAll() {
        return numberDAO.findEntities();
    }

    @Override
    public void save(Number number) {
        numberDAO.insertEntity(number);
    }

    @Override
    public Number getById(int id) {
        return numberDAO.findEntityByID(id);
    }

    @Override
    public void update(Number number) {
        numberDAO.updateEntity(number);
    }

    @Override
    public void delete(int id) {
        numberDAO.removeEntityByID(id);
    }
}
