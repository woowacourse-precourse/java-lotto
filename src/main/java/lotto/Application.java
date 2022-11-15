package lotto;

public class Application {

    public static void main(String[] args) {

        Input input = new Input();
        input.userBuy();
        input.userBuyCheck();
        input.shuffle();

        input.userNumber();
        input.bonusNum();
        input.compare();


    }
}
