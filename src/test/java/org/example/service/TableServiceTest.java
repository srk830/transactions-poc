package org.example.service;

import org.example.app.service.TableService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class TableServiceTest {

    @Autowired
    private TableService myService;

    @Test
    void save() {
        myService.save();
    }
}