package lotto;

public class Service {
    private static final int THOUSAND = 1000;
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

    public void isDividedByThousand(int number) {
        if(number % THOUSAND != 0) {
            exception.isMoneyUnitException();
        }
    }

    public int numberOfLottery(int money) {
        isDividedByThousand(money);
        int lotteryCount = money/THOUSAND;
        return lotteryCount;
    }


}
