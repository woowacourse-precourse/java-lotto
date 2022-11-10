package lotto.controller;

import static lotto.domain.LottoBuyer.purchaseLotto;
import static lotto.domain.WinningLotto.bonusNumber;
import static lotto.domain.WinningLotto.bonusNumberInput;
import static lotto.domain.WinningLotto.winningNumber;
import static lotto.domain.WinningLotto.winningNumberInput;

import lotto.domain.Lotto;
import lotto.view.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class LottoGame {

    public void start() {
        List<Lotto> lottoList;
        lottoList = purchaseLotto();
        System.out.println(lottoList);
        winningNumberInput();
        bonusNumberInput();
        System.out.println(Arrays.toString(winningNumber.split(",")));
        validateDuplicate(winningNumber, bonusNumber);
    }

    private static void validateDuplicate(String winningNumber, String bonusNumber) {
        String[] dupliateCheck = winningNumber.split(",");
        for (String str : dupliateCheck) {
            if (str.equals(bonusNumber)) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE.getErrorMessage());
            }
        }
    }
}
