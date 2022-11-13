package lotto;


public class Application {
    public static int LOTTERY_PRICE = 1000;

    public static void main(String[] args) {
        InputOutput inputOutput = new InputOutput(LOTTERY_PRICE);

        int money = inputOutput.moneyInput();


    }
}
