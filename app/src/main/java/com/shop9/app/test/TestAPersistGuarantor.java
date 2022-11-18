package com.shop9.app.test;

import java.util.function.Function;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;
import lombok.extern.slf4j.Slf4j;
import per.nonlone.vertebra.ddd.PersistGuarantor;

@Component
@Slf4j
public class TestAPersistGuarantor implements PersistGuarantor<TestA> {

    @Autowired
    private TransactionTemplate transactionTemplate;


    @Override
    public Function<TestA, TestA> apply(final Function<TestA, TestA> function) {
        // t 为 事务状态，实际执行数据为 k
        return k -> transactionTemplate.execute(t->function.apply(k));
    }
}
