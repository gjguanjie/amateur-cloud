package com.cloud.service;


import com.cloud.dao.ProcessDao;
import com.cloud.entity.ProcessEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProcessService {

    @Autowired
    private ProcessDao processDao;

    @Transactional
    public ProcessEO saveProcess(ProcessEO process){
        return processDao.save(process);
    }
}
