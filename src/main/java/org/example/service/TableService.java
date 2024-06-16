package org.example.service;

import org.example.constants.Constants;
import org.example.persistence1.entity1.Table1;
import org.example.persistence2.entity2.Table2;
import org.example.persistence1.repository1.Table1Repository;
import org.example.persistence2.repository2.Table2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TableService {

    @Autowired
    private Table1Repository table1Repository;

    @Autowired
    private Table2Repository table2Repository;

    @Autowired
    @Qualifier(Constants.TRANSACTION_MANAGER_1)
    private PlatformTransactionManager transactionManager1;

    @Autowired
    @Qualifier(Constants.TRANSACTION_MANAGER_2)
    private PlatformTransactionManager transactionManager2;

    @Transactional(transactionManager = Constants.TRANSACTION_MANAGER_1, rollbackFor = Exception.class)
    public void save() {
        String time = String.valueOf(System.currentTimeMillis());
        Table1 table1 = new Table1();
        table1.setCol1(time);
        table1.setCol2("1");
        Table2 table2 = new Table2();
        table2.setCol1(time);
        table2.setCol2("1");

        saveTable1(table1);
        saveTable2(table2);
    }

    @Transactional(transactionManager = Constants.TRANSACTION_MANAGER_1, rollbackFor = Exception.class)
    public void saveTable1(Table1 table1) {
        table1Repository.save(table1);
    }

    @Transactional(transactionManager = Constants.TRANSACTION_MANAGER_2, rollbackFor = Exception.class)
    public void saveTable2(Table2 table2) {
        table2Repository.save(table2);
        throw new RuntimeException();
    }
}
