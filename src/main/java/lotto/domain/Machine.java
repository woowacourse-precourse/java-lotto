package lotto.domain;

public class Machine {

    private Stats stats;

    public void compareLottoNumbers() {

    }

    public void calculateRateOfReturn() {

    }

    public enum Stats {
        THREE("3개 일치", 5000, 0),
        FORE("4개 일치", 50000, 0),
        FIVE("5개 일치", 1500000, 0),
        FIVE_AND_BONUS("5개 일치, 보너스 볼 일치", 30000000, 0),
        SIX("6개 일치", 2000000000, 0);

        private String accord;
        private int money;
        private int count;

        Stats() {}

        Stats(String accord, int money, int count) {
            this.accord = accord;
            this.money = money;
            this.count = count;
        }
    }
}
