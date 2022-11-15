package lotto.service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CoincideNumber {
    THREE_COINCIDE("3개 일치 (5,000원) - ",4,0,5000),
    FOUR_COINCIDE("4개 일치 (50,000원) - ",3,0,50000),
    FIVE_COINCIDE("5개 일치 (1,500,000원) - ",2,0,1500000),
    FIVE_BONUS_COINCIDE("5개 일치, 보너스 볼 일치 (30,000,000원) - ",5,0,30000000),
    SIX_COINCIDE("6개 일치 (2,000,000,000원) - ",1,0,2000000000);
    private String phrase;
    private int rank;
    private int count;
    private int money;
    CoincideNumber(String phrase, int rank,int count, int money) {
        this.phrase = phrase;
        this.rank = rank;
        this.count = count;
        this.money = money;
    }
    private int rank(){
        return rank;
    }
    public String phrase(){
        return phrase;
    }
    public int count(){
        return count;
    }
    private void plusCount(){
        this.count++;
    }
    private static final Map<Integer, CoincideNumber> BY_RANK =
            Stream.of(values()).collect(Collectors.toMap(CoincideNumber::rank, Function.identity()));
    public static void plusCountOfRank(int rank){
        BY_RANK.get(rank).plusCount();
    }
    public int calculateRevenue(){
        return (this.count * this.money);
    }

}
