package model;

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

    private final double hit;
    private final int money;
    private final String message;

    public double hit(){
        return hit;
    }
    public int money(){
        return money;
    }
    public String message(){
        return message;
    }

    private static final Map<Double, Prize> BY_HIT =
            Stream.of(values()).collect(Collectors.toMap(Prize::hit, Function.identity()));

    public static Prize prizeOfHit(Double hit){
        return BY_HIT.get(hit);
    }

    Prize(double hit, int money, String message) {
        this.hit = hit;
        this.money = money;
        this.message = message;
    }
}
