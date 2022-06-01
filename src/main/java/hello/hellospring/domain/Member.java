package hello.hellospring.domain;

/*
* Domain이란
* 내가 개발하고자 하는 하는 영역을 분석하고 그 분석의 결과로 도출한 객체를 말한다.
* 예를 들어 쇼핑몰을 만든다고 했을 때 쇼핑몰의 주된 기능인 상품 구매에 사용되는 객체인
* Member, Product, Purchase 등을 Domain 객체라고 할 수 있다.
* */
public class Member {

    private Long id; // system이 저장하는 Id
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
