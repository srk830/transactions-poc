package org.example.app.service;

import org.example.master.entity.Master;
import org.example.master.repository.MasterRepository;
import org.example.process.entity.Process;
import org.example.process.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TableService {

    @Autowired
    private MasterRepository masterRepository;

    @Autowired
    private ProcessRepository processRepository;

    @Transactional(transactionManager = "jtaTransactionManager", rollbackFor = Exception.class)
    public void save() {
        String time = String.valueOf(System.currentTimeMillis());
        Master table1 = new Master();
        table1.setCol1(time);
        table1.setCol2("1");
        Process table2 = new Process();
        table2.setCol1(time);
        table2.setCol2("1");

        masterRepository.save(table1);
        processRepository.save(table2);
        System.out.println("done");
//        throw new RuntimeException("error");
    }
}
