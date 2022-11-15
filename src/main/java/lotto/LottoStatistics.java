package lotto;

import java.util.List;
import java.math.BigInteger;
import java.util.Iterator;
import java.math.BigDecimal;
import java.util.ArrayList;

enum Rank {
    FIFTH(3, 5_000, "5,000원"),
    FOURTH(4, 50_000, "50,000원"),
    THIRD(5, 1_500_000, "1,500,000원"),
    SECOND(5, 30_000_000, "30,000,000원"),
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

    public BigInteger getMoney() {
        return this.money;
    }

    public int getPrize() {
        return prize;
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public int getMatch() {
        return match;
    }

    public String getPrintPrize() {
        return printPrize;
    }

}

public class LottoStatistics {
    private Lotto lotto;
    private List<Lotto> lottos;
    private BigInteger money;
    private Integer bonusNumber;
    private LottoBuyer lottoBuyer;

    public LottoStatistics() {

    }

    public void setStatistics() throws IllegalArgumentException {
        try {
            lottoBuyer = new LottoBuyer();
            lottoBuyer.setBuyer();
            lotto = lottoBuyer.getLotto();
            lottos = lottoBuyer.getLottos();
            money = lottoBuyer.getMoney();
            bonusNumber = lottoBuyer.getBonusNumber();
        } catch (IllegalArgumentException iae) {
            throw iae;
        }
    }

    public void start() {
        winTheLottery();
        printResult();
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setMoney(BigInteger money) {
        this.money = money;
    }

    public void winTheLottery() {
        Iterator<Lotto> lottoIter = lottos.iterator();

        while (lottoIter.hasNext()) {
            Lotto tmpLotto = lottoIter.next();
            List<Integer> tmpNumbers = new ArrayList<>(tmpLotto.getLottoNumbers());
            tmpNumbers.removeAll(lotto.getLottoNumbers());
            rankCount(tmpNumbers);
        }
    }

    //등수별 카운트
    public void rankCount(List<Integer> numbers) {
        if (numbers.size() == 0) {
            Rank.FIRST.plusCount();
        }
        if (numbers.size() == 2 && numbers.contains(bonusNumber)) {
            Rank.SECOND.plusCount();
        }
        if (numbers.size() == 1) {
            Rank.THIRD.plusCount();
        }
        if (numbers.size() == 2 && !numbers.contains(bonusNumber)) {
            Rank.FOURTH.plusCount();
        }
        if (numbers.size() == 3) {
            Rank.FIFTH.plusCount();
        }
    }

    public BigInteger getTotalPrize() {
        BigInteger totalPrize = new BigInteger("0");

        for (Rank rank : Rank.values()) {
            for (int index = 0; index < rank.getCount(); index++) {
                BigInteger tmpPrize = BigInteger.valueOf(rank.getPrize());
                totalPrize = totalPrize.add(tmpPrize);
            }
        }
        return totalPrize;
    }

    public BigDecimal getRateOfReturn() {
        BigInteger totalPrize = getTotalPrize();
        BigDecimal buyerMoney = new BigDecimal(this.money);
        BigDecimal spentMoney = new BigDecimal(totalPrize);
        BigDecimal divMoney = spentMoney.divide(buyerMoney);
        BigDecimal rateOfReturn = divMoney.multiply(new BigDecimal(100));

        return rateOfReturn;
    }

    public void printCountByRank() {
        for (Rank rank : Rank.values()) {
            int matchCount = rank.getMatch();
            int countByRank = rank.getCount();

            if (rank == Rank.SECOND) {
                System.out.println(matchCount + "개 일치, 보너스 볼 일치 (" + rank.getPrintPrize() + ")"
                        + " - " + countByRank + "개");
                continue;
            }

            System.out.println(matchCount + "개 일치 (" + rank.getPrintPrize() + ")"
                    + " - " + countByRank + "개");
        }
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        printCountByRank();
        BigDecimal rateOfReturn = getRateOfReturn();
        System.out.println("총 수익률은 " + rateOfReturn.setScale(1) + "%입니다.");
    }

}

