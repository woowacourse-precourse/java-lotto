package UI;

import Exception.LottoNumberException;
import Exception.PriceException;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static int price() {
        Output.inputPrice();
        String price = Console.readLine();
        PriceException.checkException(price);
        return Integer.valueOf(price);
    }

    public static List<Integer> winningNumbers() {
        Output.inputWinningNumber();
        String[] numbers = Console.readLine().split(",");

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            LottoNumberException.checkException(number);
            winningNumbers.add(Integer.valueOf(number));
        }
        Lotto lotto = new Lotto(winningNumbers);

        return lotto.getNumbers();
    }

    public static int bonusNumber() {
        Output.inputBounsNumber();
        String bonusNumber = Console.readLine();
        LottoNumberException.checkException(bonusNumber);
        return Integer.valueOf(bonusNumber);
    }

}
