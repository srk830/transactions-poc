package org.example.app.config;


import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import org.example.app.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
public class JtaConfig {

    @Bean(name = Constants.JTA_TRANSACTION_MANAGER)
    public JtaTransactionManager transactionManager(@Autowired UserTransaction userTransaction) throws SystemException {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);

        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }

    @Bean
    public UserTransaction userTransaction() throws Throwable {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(300);
        return userTransactionImp;
    }

}
