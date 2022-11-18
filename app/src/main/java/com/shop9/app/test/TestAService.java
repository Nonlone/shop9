package com.shop9.app.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import per.nonlone.vertebra.ddd.operate.CreateOperator;
import per.nonlone.vertebra.ddd.operate.SortOperator;
import per.nonlone.vertebra.ddd.operate.ValidateOperator;

@Component
public class TestAService {


    @Component
    @Slf4j
    public static class TestASortor extends SortOperator<TestA> {

        @Override
        public TestA apply(TestA t) {
            log.info("apply sort");
            return t;
        }
    }

    @Component
    @Slf4j
    public static class TestAValidator extends ValidateOperator<TestA> {

        @Override
        public TestA apply(TestA t) {
            log.info("apply validate");
            return t;
        }
        
    }


    @Component
    @Slf4j
    public static class TestACreateOperator extends CreateOperator<TestA> {

        @Autowired
        private TestAService testAService;

        @Autowired
        private TestAMapper testAMapper;

        private TestACreateOperator(@Autowired TestAPersistGuarantor testAPersistGuarantor) {
            super(testAPersistGuarantor);
        }

        @Override
        protected TestA doCreate(TestA t) {
            // TestA 专为 TestAPo
            TestAPo testAPo = new TestAPo();
            testAPo.setKey(t.getKey());
            testAPo.setValue(t.getValue());
            testAMapper.insert(testAPo);
            // 回写id
            t.setId(testAPo.getId());
            return t;
        }
        

    }

  
}


