package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Purchase;

public class Controller {
    View view;
    Purchase purchase;

    void buyLotto(){
        System.out.println(Constant.ASK_PRICE);
        String money = Console.readLine();
        purchase.setPrice(money);
    }
}
