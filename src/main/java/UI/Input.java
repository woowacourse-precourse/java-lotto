package UI;

import Exception.LottoNumberException;
import Exception.PriceException;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private static List<Integer> lotto;
    private Output output = new Output();

    public int purchaseAmount() {
        output.inputPurchaseAmount();
        String purchaseAmount = Console.readLine();
        PriceException.checkException(purchaseAmount);
        return Integer.valueOf(purchaseAmount);
    }

    public List<Integer> winningNumbers() {
        output.inputWinningNumber();
        String[] numbers = Console.readLine().split(",");

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            LottoNumberException.checkWinningNumberException(number);
            winningNumbers.add(Integer.valueOf(number));
        }
        Lotto lotto = new Lotto(winningNumbers);
        this.lotto = lotto.getNumbers();

        return this.lotto;
    }

    public int bonusNumber() {
        output.inputBounsNumber();
        String bonusNumber = Console.readLine();
        LottoNumberException.checkBonusNumberException(bonusNumber,this.lotto);
        return Integer.valueOf(bonusNumber);
    }

}
