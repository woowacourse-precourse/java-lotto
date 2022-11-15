package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;

import static lotto.constants.ConsoleMessages.INPUT_PRICE;
import static lotto.constants.ConsoleMessages.PURCHASE;
import static lotto.constants.ErrorMessages.INPUT_NUMBER_ERROR;

public class BuyConsole {
    public void printInputMessage() {
        System.out.println(INPUT_PRICE);
    }

    public int inputPrice() throws IllegalArgumentException{
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR);
        }
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASE);
        for(Lotto l : lottos) {
            System.out.println(l.getNumbers());
        }
        System.out.println();
    }
}
