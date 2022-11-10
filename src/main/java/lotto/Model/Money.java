package lotto.Model;

public class Money {

    private static int inputMoney;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void setInputMoney(int inputMoney) {
        checkUnit(inputMoney);
        Money.inputMoney = inputMoney;
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
            if(i == 6) sum+=2000000000;
            if(i == 7) sum+=30000000;
            if(i == 5) sum+=1500000;
            if(i == 4) sum+=50000;
            if(i == 3) sum+=5000;
        }
        sum /= inputMoney;
        sum *= 100;
        System.out.println("총 수익률은 " + String.format("%.1f", sum) + "%입니다.");
    }


}
