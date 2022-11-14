package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchasedAmount;
import lotto.domain.WinningLotto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.constant.ConstValue.WINNING_NUMBER_INPUT_PATTERN;
import static lotto.constant.Message.*;

public class InputView {
    public WinningLotto inputWinningLottoNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String lottoNumbers = Console.readLine();

        validatePattern(lottoNumbers);
        List<Integer> lotto = StringToList(lottoNumbers);

        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();

        return new WinningLotto(lotto, bonusNumber);
    }

    private List<Integer> StringToList(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validatePattern(String lottoNumbers) {
        if (!Pattern.matches(WINNING_NUMBER_INPUT_PATTERN, lottoNumbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_WINNING_LOTTO_INPUT_FORMAT_MESSAGE);
        }
    }

    public PurchasedAmount inputPurchasedAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        String purchasedAmount = Console.readLine();

        return new PurchasedAmount(purchasedAmount);
    }
}
