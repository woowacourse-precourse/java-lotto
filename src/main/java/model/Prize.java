package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {
    First(6,2000000000,"6개 일치 (2,000,000,000원) - 개"),
    Second(5.5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - 개"),
    Third(5, 1500000, "5개 일치 (1,500,000원) - 개"),
    Fourth(4, 50000, "4개 일치 (50,000원) - 개"),
    Fifth(3, 5000, "3개 일치 (5,000원) - 개");

    private final double HIT;
    private final int MONEY;
    private final String MESSAGE;

    public double HIT(){
        return HIT;
    }
    public int MONEY(){return MONEY;}
    public String MESSAGE(){
        return MESSAGE;
    }

    private static final Map<Double, Prize> BY_HIT =
            Stream.of(values()).collect(Collectors.toMap(Prize::HIT, Function.identity()));

    public static Prize prizeOfHit(Double hit){
        return BY_HIT.get(hit);
    }

    public List<String> getPrizeMessages(){
        List<String> messages = new ArrayList<String>();
        for(Prize prize: Prize.values()){
            messages.add(prize.MESSAGE());
        }

        return messages;
    }

    Prize(double hit, int money, String message) {
        this.HIT = hit;
        this.MONEY = money;
        this.MESSAGE = message;
    }
}
