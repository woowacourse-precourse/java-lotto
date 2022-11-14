package lotto.model.statistics;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class StatisticsImpl implements Statistics{

    private final BigDecimal money;
    private final List<Lotto> issuedLotto;
    private final WinningNumbers winningNumbers;
    private BigDecimal firstCount;
    private BigDecimal secondCount;
    private BigDecimal thirdCount;
    private BigDecimal fourthCount;
    private BigDecimal fifthCount;
    private final Matcher matcher;
    private BigDecimal prize;
    private BigDecimal yield;

    public StatisticsImpl(List<Lotto> issuedLotto,WinningNumbers winningNumbers, BigDecimal money){
        this.issuedLotto = issuedLotto;
        this.winningNumbers = winningNumbers;
        this.money = money;
        this.matcher = new MatcherImpl();
        this.prize = new BigDecimal(0);
        this.yield = new BigDecimal("0.00");
        this.firstCount = new BigDecimal(0);
        this.secondCount = new BigDecimal(0);
        this.thirdCount = new BigDecimal(0);
        this.fourthCount = new BigDecimal(0);
        this.fifthCount = new BigDecimal(0);
    }

    @Override
    public void calculate() {
        for (Lotto lotto : issuedLotto) {
            Integer correctMatch = matcher.getCorrectMatch(winningNumbers, lotto);
            Boolean bonusMatch = matcher.getBonusMatch(winningNumbers, lotto);
            Rank rank = Rank.of(correctMatch, bonusMatch);
            count(rank);
            addPrize(rank);
        }
        calculateYield();
    }

    @Override
    public String generateMessage() {
        return "3개 일치 (5,000원) - " + fifthCount.toString() + "개\n"
                + "4개 일치 (50,000원) - " + fourthCount.toString() + "개\n"
                + "5개 일치 (1,500,000원) - " + thirdCount.toString() + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondCount.toString() + "개\n"
                + "6개 일치 (2,000,000,000원) - " + firstCount.toString() + "개\n"
                + "총 수익률은 " + yield.toString() + "%입니다.";
    }

    private void count(Rank rank){
        if (rank.name().equals("FIRST")){
            firstCount = firstCount.add(BigDecimal.ONE);
        }
        if (rank.name().equals("SECOND")){
            secondCount = secondCount.add(BigDecimal.ONE);
        }
        if (rank.name().equals("THIRD")){
            thirdCount = thirdCount.add(BigDecimal.ONE);
        }
        if (rank.name().equals("FOURTH")){
            fourthCount = fourthCount.add(BigDecimal.ONE);
        }
        if (rank.name().equals("FIFTH")){
            fifthCount = fifthCount.add(BigDecimal.ONE);
        }
    }

    private void addPrize(Rank rank){
        prize = prize.add(new BigDecimal(rank.getPrize()));
    }

    private void calculateYield(){
        try {
            this.yield = prize.divide(money, 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
}
