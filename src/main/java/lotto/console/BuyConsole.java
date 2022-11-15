package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constants.ConsoleMessages.INPUT_PRICE;
import static lotto.constants.ConsoleMessages.PURCHASE;
import static lotto.constants.ErrorMessages.INPUT_NUMBER_ERROR;

public class BuyConsole {
    public void printInputMessage() {
        System.out.println(INPUT_PRICE);
    }

    public int inputPrice() {
        String input = Console.readLine();
        Pattern p = Pattern.compile("^[0-9]*$");
        if (!p.matcher(input.trim()).matches()) {
            System.out.println(INPUT_NUMBER_ERROR);
            return inputPrice();
        }
        return Integer.parseInt(input);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASE);
        for(Lotto l : lottos) {
            System.out.println(l.getNumbers());
        }
        System.out.println();
    }
}
