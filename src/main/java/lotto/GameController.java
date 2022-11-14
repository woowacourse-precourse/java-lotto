package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Buyer;
import lotto.domain.NumbersValidator;
import lotto.domain.WinningNumber;
import lotto.view.GameView;

public class GameController {

    public void start() {
        try {
            Buyer buyer = buyLottos();
            WinningNumber winningNumber = generateWinningNumber();
            checkMatchedNumber(buyer, winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }


    private Buyer buyLottos() {
        GameView.printMoneyInputMsg();
        String input = getInput();
        NumbersValidator.isNumeric(input);
        Buyer buyer = new Buyer(Integer.parseInt(input));
        GameView.printPurchaseLotto(buyer);

        return buyer;
    }


    private WinningNumber generateWinningNumber() {
        return new WinningNumber(
                getWinningNumber(),
                getBonusNumber()
        );
    }

    private List<Integer> getWinningNumber() {
        GameView.printWinningNumInputMsg();
        String[] winningNumberInput = getInput().split(",");
        NumbersValidator.isNumerics(winningNumberInput);

        return Arrays.stream(winningNumberInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int getBonusNumber() {
        GameView.printBonusNumInputMsg();
        String bonusNumberInput = getInput();
        NumbersValidator.isNumeric(bonusNumberInput);

        return Integer.parseInt(bonusNumberInput);
    }

    private String getInput() {
        return Console.readLine().strip();
    }

    private void checkMatchedNumber(Buyer buyer, WinningNumber winningNumber) {
        buyer.checkWinningNumber(winningNumber);
        GameView.printStatistics(buyer);
    }
}
