package lotto;

public class Application {

    public static void main(String[] args) {
        try {
            LotteryShop lotteryShop = new LotteryShop();
            lotteryShop.open();
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
        }
    }
}
