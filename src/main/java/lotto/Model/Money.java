package lotto.Model;

import static lotto.Model.Ranking.findRanking;

public class Money {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String MONEY_CHAR_ERROR_MESSAGE = " 숫자만 입력 가능합니다.";
    private static final String MONEY_UNIT_ERROR_MESSAGE = "천원 단위만 입력 가능합니다.";
    private static final int moneyUnit = 1000;

    private static final int COUNT_OF_FIRST = 6;
    private static final int COUNT_OF_SECOND = 7;
    private static final int COUNT_OF_THIRD = 5;
    private static final int COUNT_OF_FOURTH = 4;
    private static final int COUNT_OF_FIFTH = 3;

    private static int inputMoney;

    public static void setInputMoney(String inputMoney) {
        int tempMoney = convertToInt(inputMoney);
        checkUnit(tempMoney);
        Money.inputMoney = tempMoney;
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + MONEY_CHAR_ERROR_MESSAGE);
        }
    }

    private static void checkUnit(int money) {
        try {
            if(money % moneyUnit != 0) throw new IllegalArgumentException(ERROR_MESSAGE + MONEY_UNIT_ERROR_MESSAGE);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getInputMoney() {
        return inputMoney;
    }

    public static double calcYield() {
        double sum = 0.0;
        for(int countOfCase : LottoSystem.getWinningStatics()) {
            if(countOfCase == COUNT_OF_FIRST) sum+= findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_SECOND) sum+= findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_THIRD) sum+= findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_FOURTH) sum+= findRanking(countOfCase).getPrize();
            if(countOfCase == COUNT_OF_FIFTH) sum+= findRanking(countOfCase).getPrize();
        }
        sum /= getInputMoney();
        sum *= 100;
        return sum;
    }

}

