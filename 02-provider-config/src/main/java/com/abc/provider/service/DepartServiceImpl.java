package com.abc.provider.service;

import com.abc.provider.bean.Depart;
import com.abc.provider.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository repository;

    @Override
    public boolean saveDepart(Depart depart) {
        Depart result = repository.save(depart);
        if(result != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDepartById(int id) {
        // 对于deleteById()方法，若DB中不存在该id，而执行了其删除操作，将抛出异常
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart result = repository.save(depart);
        if(result != null) {
            return true;
        }
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
        // getOne()方法：若其指定的id不存在，该方法将抛出异常
        if(repository.existsById(id)) {
            return repository.getOne(id);
        }
        Depart depart = new Depart();
        depart.setName("no this depart");
        return depart;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return repository.findAll();
    }
}
