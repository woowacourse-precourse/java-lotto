package lotto;


import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.domain.Exception.*;

import lotto.domain.Buyer;

public class Application {

    public static final String ASK_AMOUT = "구입금액을 입력해주세요.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer buyer = new Buyer();
        buyer.setPurchaseAmount(askAmount());
        System.out.println(buyer.getPurchaseAmount());
    }
    public static int askAmount(){
        System.out.println(ASK_AMOUT);
        String input = readLine();

        int number = isValidAmount(input);

        return number;
    }
}
