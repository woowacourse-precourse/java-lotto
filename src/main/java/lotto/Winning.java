package lotto;

import java.util.List;

public enum Winning {
    EqualThree("3개 일치 (5,000원) - ", 5000),
    EqualFour("4개 일치 (50,000원) - ", 50000),
    EqualFive("5개 일치 (1,500,000원) - ", 1500000),
    EqualFiveAndBonus("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    EqualSix("6개 일치 (2,000,000,000원) - ", 2000000000);

    private String message;
    private int cash;

    Winning(String message, int prizeMoney) {
        this.message = message;
        this.cash = prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public int getCash() {
        return cash;
    }

    public static Winning getWinning(int equalNumber, boolean bonus) {
        if(equalNumber == 3) {
            return EqualThree;
        }
        if(equalNumber == 4) {
            return EqualFour;
        }
        if(equalNumber == 5 && !bonus) {
            return EqualFive;
        }
        if(equalNumber == 5 && bonus) {
            return EqualFiveAndBonus;
        }
        if(equalNumber == 6) {
            return EqualSix;
        }

        return null;
    }

    public static List<Winning> getValues() {
        return List.of(EqualThree, EqualFour, EqualFive, EqualFiveAndBonus, EqualSix);
    }
}
