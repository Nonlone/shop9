package com.shop9.app.test;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestAController {

    @Autowired
    private TestAMapper testAMapper;  

    @Autowired
    private ApplicationContext applicationContext;


    @GetMapping("/testa/list")
    public Object listTestA() {
        return testAMapper.selectList(null);
    }

    @GetMapping("/testa")
    public Object getTestA(@RequestParam("id") String id) {
        TestAPo testAPo = testAMapper.selectById(id);
        if (Objects.nonNull(testAPo)) {
            log.info("TestAPo >> " + testAPo);
            return testAPo;
        }
        return "testAPo is not exist";
    }


    @PostMapping("/testa")
    public Object postTestA(@RequestBody CreateTestARequest createTestARequest) {
        // 把 Request 类转换为领域模型
        TestA testA = applicationContext.getBean(TestA.class);
        testA.setKey(createTestARequest.getKey());
        testA.setValue(createTestARequest.getValue());
        // 领域动作
        testA = testA.create();
        return testA;
    }
    
}
