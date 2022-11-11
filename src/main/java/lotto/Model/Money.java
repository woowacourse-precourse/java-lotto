package lotto.Model;

import static lotto.Model.Ranking.findRanking;

public class Money {

    private static int inputMoney;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void setInputMoney(String inputMoney) {
        int temp = convertToInt(inputMoney);
        checkUnit(temp);
        Money.inputMoney = temp;
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자만 입력 가능합니다.");
        }
    }

    public static int getInputMoney() {
        return inputMoney;
    }

    private static void checkUnit(int money) {
        try {
            if(money % 1000 != 0) throw new IllegalArgumentException(ERROR_MESSAGE + "천원 단위만 입력 가능합니다.");
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printYield() {
        double sum = 0.0;
        for(int i : LottoSystem.getWinningStatics()) {
            if(i == 6) sum+= findRanking(i).getPrize();
            if(i == 7) sum+= findRanking(i).getPrize();
            if(i == 5) sum+= findRanking(i).getPrize();
            if(i == 4) sum+= findRanking(i).getPrize();
            if(i == 3) sum+= findRanking(i).getPrize();
        }
        sum /= inputMoney;
        sum *= 100;
        System.out.println("총 수익률은 " + String.format("%.1f", sum) + "%입니다.");
    }


}

