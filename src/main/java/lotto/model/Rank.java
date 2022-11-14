package lotto.model;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(2000000000, "6개 일치"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(1500000, "5개 일치"),
    FOURTH(50000, "4개 일치"),
    FIFTH(5000, "3개 일치"),
    NONE(0, "");

    private Integer amount;
    private String criteria;


    Rank(Integer amount, String criteria) {
        this.amount = amount;
        this.criteria = criteria;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getCriteria(){
        return criteria;
    }



}
