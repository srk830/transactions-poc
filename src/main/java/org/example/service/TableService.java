package org.example.service;

import org.example.persistence1.entity1.Table1;
import org.example.persistence1.repository1.Table1Repository;
import org.example.persistence2.entity2.Table2;
import org.example.persistence2.repository2.Table2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TableService {

    @Autowired
    private Table1Repository table1Repository;

    @Autowired
    private Table2Repository table2Repository;

    @Transactional(transactionManager = "jtaTransactionManager", rollbackFor = Exception.class)
    public void save() {
        String time = String.valueOf(System.currentTimeMillis());
        Table1 table1 = new Table1();
        table1.setCol1(time);
        table1.setCol2("1");
        Table2 table2 = new Table2();
        table2.setCol1(time);
        table2.setCol2("1");

        table1Repository.save(table1);
        table2Repository.save(table2);
        System.out.println("done");
//        throw new RuntimeException("error");
    }
}
