package lotto;

import lotto.domain.*;
import lotto.ui.Input;
import lotto.ui.Output;

public class Application {
    private static Money money = new Money();
    private static Answer answer = new Answer();
    public static void main(String[] args) {
        if (!Input.buy(money)) {
            return;
        }
        Purchase purchase = new Purchase(money.getMoney());
        Output.printPurchase(purchase);
        if (!Input.answer(answer)) {
            return;
        }
        if (!Input.bonus(answer)) {
            return;
        }
        draw(purchase);
    }

    private static void draw(Purchase purchase) {
        Pick pick = new Pick(answer.getAnswer(), answer.getBonus());
        pick.drawLottoes(purchase.getLottoes());
        Output.printPick(pick);
        Output.printRateOfReturn(pick.getRateOfReturn(money.getMoney()));
    }
}
