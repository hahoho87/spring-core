package com.devbaek.springcore.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

class PrototypeTest {

    @Test
    @DisplayName("프로토타입 빈 테스트")
    void prototypeBeanTest() throws Exception {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        // when
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        // then
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("Singleton Bean Init!");
        }

        @PreDestroy
        public void close() {
            System.out.println("Singleton Bean Destroyed!!1");
        }
    }

}
