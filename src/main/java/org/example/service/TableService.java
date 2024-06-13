package org.example.service;
//
//import lombok.RequiredArgsConstructor;
//import org.example.constants.Constants;
//import org.example.entity1.Table1;
//import org.example.entity2.Table2;
//import org.example.repository1.Table1Repository;
//import org.example.repository2.Table2Repository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.support.DefaultTransactionDefinition;
//
//@Service
//public class Table1Service {
//    @Autowired
//    private Table1Repository table1Repository;
//
//    @Autowired
//    private Table2Repository table2Repository;
//
//    @Autowired
//    @Qualifier(Constants.TRANSACTION_MANAGER_1)
//    private PlatformTransactionManager transactionManager1;
//
//    @Autowired
//    @Qualifier(Constants.TRANSACTION_MANAGER_2)
//    private PlatformTransactionManager transactionManager2;
//
//    public void save() {
//        String time = String.valueOf(System.currentTimeMillis());
//        Table1 table1 = new Table1();
//        table1.setCol1(time);
//        table1.setCol2("1");
//        Table2 table2 = new Table2();
//        table2.setCol1(time);
//        table2.setCol2("1");
//
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        TransactionStatus status = transactionManager1.getTransaction(def);
//        try {
//            saveTable1(table1);
//            saveTable2(table2);
//        } catch (RuntimeException e) {
//            transactionManager1.rollback(status);
//            transactionManager2.rollback(status);
//            throw e;
//        }
//        transactionManager1.commit(status);
//    }
//
////    @Transactional(transactionManager = Constants.TRANSACTION_MANAGER_1, rollbackFor = Exception.class)
//    public void saveTable1(Table1 table1) {
//        table1Repository.save(table1);
//    }
//
////    @Transactional(transactionManager = Constants.TRANSACTION_MANAGER_2, rollbackFor = Exception.class)
//    public void saveTable2(Table2 table2) {
//        table2Repository.save(table2);
//        throw new RuntimeException();
//    }
//
//}


import org.example.constants.Constants;
import org.example.entity1.Table1;
import org.example.entity2.Table2;
import org.example.repository1.Table1Repository;
import org.example.repository2.Table2Repository;
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

    @Transactional(rollbackFor = Exception.class)
    public void save() {
        String time = String.valueOf(System.currentTimeMillis());
        Table1 table1 = new Table1();
        table1.setCol1(time);
        table1.setCol2("1");
        Table2 table2 = new Table2();
        table2.setCol1(time);
        table2.setCol2("1");

        try {
            saveTable1(table1);
            saveTable2(table2);
        } catch (RuntimeException e) {
            throw e;
        }
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
