package lotto.gameResult;

public class RateOfReturn {
    static final int FIFTH_MONEY = 5000;
    static final int FOURTH_MONEY = 50000;
    static final int THIRD_MONEY = 1500000;
    static final int SECOND_MONEY = 30000000;
    static final int FIRST_MONEY = 2000000000;
    public static final String RETURN_MESSAGE = "총 수익률은 %s%%입니다.\n";

    public static double totallReturn() {
        double totallMoney = 
            FIRST_MONEY*WinningLotto.firstClassNumber +
            SECOND_MONEY*WinningLotto.secondClassNumber +
            THIRD_MONEY*WinningLotto.thirdClassNumber +
            FOURTH_MONEY*WinningLotto.fourthClassNumber +
            FIFTH_MONEY*WinningLotto.fifthClassNumber;
        
        return totallMoney;
    }

    public static String returnRate(String money) {
        double price = Double.parseDouble(money);
        double result = RateOfReturn.totallReturn()/price;
        String rate = String.format("%.1f", result*100);

        return rate;
    }
}
