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
        return Math.round(((double) reward() / Integer.parseInt(this.price.getPrice())) * 100) / 100.0;
    }

    private Integer reward() {
        Integer reward = 0;
        reward += this.match.getMatches().get(Lanking.rank1) * Lanking.rank1.getReward();
        reward += this.match.getMatches().get(Lanking.rank2) * Lanking.rank2.getReward();
        reward += this.match.getMatches().get(Lanking.rank3) * Lanking.rank3.getReward();
        reward += this.match.getMatches().get(Lanking.rank4) * Lanking.rank4.getReward();
        reward += this.match.getMatches().get(Lanking.rank5) * Lanking.rank5.getReward();
        return reward;
    }
}
