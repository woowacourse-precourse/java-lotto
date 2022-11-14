package lotto.Model;

import static lotto.Model.Ranking.findRanking;

public class Money {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String MONEY_UNIT_ERROR_MESSAGE = "천원 단위만 입력 가능합니다.";
    private static final int moneyUnit = 1000;

    private static final int COUNT_OF_FIRST = 6;
    private static final int COUNT_OF_SECOND = 7;
    private static final int COUNT_OF_THIRD = 5;
    private static final int COUNT_OF_FOURTH = 4;
    private static final int COUNT_OF_FIFTH = 3;

    private static int inputMoney;

    public Money(int amount) {
        inputMoney = amount;
    }

    public static int checkUnit(int money) {
        try {
            if (money % moneyUnit != 0) throw new IllegalArgumentException(ERROR_MESSAGE + MONEY_UNIT_ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return money;
    }

    public static int getInputMoney() {
        return inputMoney;
    }

    public static double calcYield() {
        double prizeSum = 0.0;
        for(int countOfCase : LottoSystem.getWinningStatics()) {
            if(countOfCase == COUNT_OF_FIRST) prizeSum += findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_SECOND) prizeSum += findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_THIRD) prizeSum += findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_FOURTH) prizeSum += findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_FIFTH) prizeSum += findRanking(countOfCase).getPrize();
        }
        prizeSum /= Money.getInputMoney();
        prizeSum *= 100;
        return prizeSum;
    }
}

