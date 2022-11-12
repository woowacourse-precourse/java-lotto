package lotto;

public class Yield {
    private final Price price;
    private final Match match;

    public Yield(Price price, Match match) {
        this.price = price;
        this.match = match;
    }

    public Double getYield() {
        // 5-3. 소수점 둘째 자리에서 반올림한 수익률을 구한다.
        Integer reward = 0;
        reward += match.getMatches().get(Lanking.rank1) * 2000000000;
        reward += match.getMatches().get(Lanking.rank2) * 30000000;
        reward += match.getMatches().get(Lanking.rank3) * 1500000;
        reward += match.getMatches().get(Lanking.rank4) * 50000;
        reward += match.getMatches().get(Lanking.rank5) * 5000;
        return Math.round(((double) reward / Integer.parseInt(this.price.getPrice()))*100) / 100.0;
    }
}
