package com.shop9.app.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import per.nonlone.vertebra.ddd.domain.DomainEntity;


@Scope("prototype")
@Component
public class TestA extends DomainEntity<Integer,TestA> {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String key;

    @Getter
    @Setter
    private String value;

    public TestA(
            @Autowired TestAService.TestACreateOperator createOperator,
            @Autowired TestAService.TestASortor sortOperator,
            @Autowired TestAService.TestAValidator validateOperator
    ) {
        super(createOperator, null, null, null);
        this.sortOperator = sortOperator;
        this.validateOperator = validateOperator;
    }





    @Override
    public Integer getEntityId() {
        return getId();
    }
}
