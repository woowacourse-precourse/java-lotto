package lotto.ui;

import java.util.Arrays;

public final class Constants {
    public static final int LOTTO_SIZE = 6;
    public static final int PRINT_SIZE = 5;

    public static final String[] printTable = {"3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ", "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "6개 일치 (2,000,000,000원) - "
    };

    public static final Integer[] winningMoney = {5000, 50000, 1500000,
            30000000, 2000000000};

    public enum winningMoneys {
        THREE(3, 5000), FOUR(4, 50000),
        FIVE(5, 1500000), FIVE_BONUS(15, 30000000),
        SIX(6, 2000000000);
        private final int gotMoney;
        private final int correctNumber;

        winningMoneys(int gotMoney, int correctNumber) {
            this.gotMoney = gotMoney;
            this.correctNumber = correctNumber;
        }

        public winningMoneys getRank(int count) {
            return Arrays.stream(values())
                    .filter(statistic -> statistic.correctNumber == count)
                    .findFirst()
                    .orElseThrow();

        }
    }
}
