package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.ui.Input;
import lotto.ui.InputMessages;
import lotto.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        Money money = input.buy();
        Purchase purchase = new Purchase(money.getMoney());
        output.printPurchase(purchase);

        Answer answer = input.answer();
        input.bonus(answer);
        Pick pick = new Pick(answer.getAnswer(), answer.getBonus());
        pick.drawLottoes(purchase.getLottoes());

        output.printPick(pick);
        output.printRateOfReturn(pick.getRateOfReturn(money.getMoney()));
    }


}
