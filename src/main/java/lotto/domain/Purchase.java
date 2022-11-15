package lotto.domain;

import lotto.util.Input;

import java.util.List;

import static lotto.domain.Amount.*;
import static lotto.domain.Lotto.*;
import static lotto.util.Output.*;
import static lotto.util.Input.*;

public class Purchase {

    private static Amount amount;
    private static List<Lotto> lottos;
    private static WinningNumber winningNumber;

    public static void lotto() {

        printAmountInputText();
        amount = pay(inputAmount());

        lottos = createLottos(amount.getCount());
        printLottos(lottos);

        inputNumbers();
        inputBonusNumber();

        //Result.of(lottos, winningNumber).printStatistics(amount);
    }

    /**
     * 당첨 번호를 입력받는 메서드
     */
    private static void inputNumbers() {
        printInputWinningNumber();
        winningNumber = new WinningNumber(inputWinningNumbers());
    }

    /**
     * 보너스 번호를 입력받는 메서드
     */
    private static void inputBonusNumber() {
        printInputBonusNumber();
        winningNumber.setBonusNumber(Input.inputBonusNumber(winningNumber.getNumbers()));
    }
}
