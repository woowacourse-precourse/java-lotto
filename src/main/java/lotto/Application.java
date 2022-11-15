package lotto;


import camp.nextstep.edu.missionutils.Console;
import static lotto.GuideMessage.*;

public class Application {
    public static int getLottoPurchaseMoney() {
        System.out.println(INPUT_REQUEST_MESSAGE.getMessage());
        String userInput = Console.readLine();
        int lottoPurchaseMoney = Integer.parseInt(userInput);
        return lottoPurchaseMoney;

    }

    public static void main(String[] args) {
        int lottoPurchaseMoney = getLottoPurchaseMoney();
    }
}