package lotto;

import lotto.Lotto;
import lotto.LottoBuyer;

import java.util.List;
import java.math.BigInteger;
import java.util.Iterator;
import java.math.BigDecimal;
import java.util.ArrayList;

enum Rank {
    FIFTH(3, 5_000, "5,000원"),
    FOURTH(4, 50_000, "50,000원"),
    THIRD(5, 1_500_000, "1,500,000원"),
    SECOND(5,30_000_000, "30,000,000원"),
    FIRST(6, 2_000_000_000, "2,000,000,000원");

    private final int match;
    private final int prize;

    private final String printPrize;
    private int count;

    private BigInteger money;

    Rank(int match, int prize, String printPrize) {
        this.match = match;
        this.prize = prize;
        this.printPrize = printPrize;
    }

    public BigInteger getMoney(){
        return this.money;
    }

    public int getPrize(){
        return prize;
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount(){
        return count;
    }

    public int getMatch(){
        return match;
    }

    public String getPrintPrize(){
        return printPrize;
    }

}

public class LottoStatistics {
    private LottoBuyer lottoBuyer;
    private Lotto lotto;
    private List<Lotto> lottos;
    private BigInteger money;
    private Integer bonusNumber;

    /*등수별 카운트*/
    public void rankCount(List<Integer> numbers){
        if (numbers.size() == 0){
            Rank.FIRST.plusCount();
        }
        if (numbers.size() == 1 && numbers.contains(bonusNumber)){
            Rank.SECOND.plusCount();
        }
        if (numbers.size() == 1 && !numbers.contains(bonusNumber)){
            Rank.THIRD.plusCount();
        }
        if (numbers.size() == 2){
            Rank.FOURTH.plusCount();
        }
        if (numbers.size() == 3 ){
            Rank.FIFTH.plusCount();
        }
    }

}

