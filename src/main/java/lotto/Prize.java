package lotto;

import java.text.DecimalFormat;
import java.util.*;

public enum Prize
{
    First("6개 일치",2_000_000_000),
    Second("5개 일치, 보너스 볼 일치",30_000_000),
    Third("5개 일치",1_500_000),
    Fourth("4개 일치",50_000),
    Fifth("3개 일치",5_000);

    private static class Money
    {
        static DecimalFormat priceFormat = new DecimalFormat("###,###");
        int money;

        Money(int price)
        {
            this.money = price;
        }

        @Override
        public String toString()
        {
            return "(" + priceFormat.format(money) +"원)";
        }
    }

    private static final Integer FIRST_CORRECT_COUNT = 6;
    private static final Integer THIRD_CORRECT_COUNT = 5;
    private static final Integer FOURTH_CORRECT_COUNT = 4;
    private static final Integer FIFTH_CORRECT_COUNT = 3;
    private static final Map<Integer, Prize> PRIZE_VALUES = new HashMap<>();

    static
    {
        PRIZE_VALUES.put(FIRST_CORRECT_COUNT, First);
        PRIZE_VALUES.put(THIRD_CORRECT_COUNT, Third);
        PRIZE_VALUES.put(FOURTH_CORRECT_COUNT, Fourth);
        PRIZE_VALUES.put(FIFTH_CORRECT_COUNT, Fifth);
    }

    private final String info;
    private final Money price;

    Prize(String info,Integer price)
    {
        this.info = info;
        this.price = new Money(price);
    }

    public Integer getPrice()
    {
        return price.money;
    }

    public static Prize of(int correctCount,boolean isCorrectSpecialNumber)
    {
        if(correctCount == THIRD_CORRECT_COUNT && isCorrectSpecialNumber)
        {
            return Second;
        }

        return PRIZE_VALUES.getOrDefault(correctCount,null);
    }

    public static List<Prize> getValues()
    {
        return List.of(Fifth,Fourth,Third,Second,First);
    }

    @Override
    public String toString()
    {
        return String.join(" ",info,price.toString());
    }
}
