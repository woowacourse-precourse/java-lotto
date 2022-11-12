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
        reward += match.getMatches().get("1등") * 2000000000;
        reward += match.getMatches().get("2등") * 30000000;
        reward += match.getMatches().get("3등") * 1500000;
        reward += match.getMatches().get("4등") * 50000;
        reward += match.getMatches().get("5등") * 5000;
        System.out.println("reward = " + reward);
        System.out.println("this.price.getPrice() = " + this.price.getPrice());
        return Math.round(((double) reward / Integer.parseInt(this.price.getPrice()))*100) / 100.0;
    }
}
