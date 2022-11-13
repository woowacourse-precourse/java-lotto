package lotto;

public class Service {

    private static final int LOTTERY_PRICE = 1000;

    Exception exception = new Exception();

    public int stringToInt(String string) {
        isInteger(string);
        return Integer.parseInt(string);
    }

    public void isInteger(String string) {
        if(string.matches("[+-]?\\d*(\\.\\d+)?") == false) {
            exception.isNotIntegerException();
        }
    }

    public void isDividedByLotteryPrice(int number) {
        if(number % LOTTERY_PRICE != 0) {
            exception.isMoneyUnitException();
        }
    }

    public int numberOfLottery(int money) {
        isDividedByLotteryPrice(money);
        int lotteryCount = money/LOTTERY_PRICE;
        return lotteryCount;
    }


}
