package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchasedAmount;
import lotto.domain.Validator;
import lotto.domain.WinningLotto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.constant.ConstValue.WINNING_NUMBER_INPUT_PATTERN;
import static lotto.constant.Message.*;

public class InputView {
    private final Validator validator = new Validator();

    public WinningLotto inputWinningLottoNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String lottoNumbers = Console.readLine();

        validator.validateWinningLottoPattern(lottoNumbers);

        List<Integer> lotto = StringToList(lottoNumbers);

        validator.validateWinningLotto(lotto);

        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();

        validator.validateBonusNumber(lotto, bonusNumber);

        return new WinningLotto(lotto, Integer.parseInt(bonusNumber));
    }

    private List<Integer> StringToList(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    public PurchasedAmount inputPurchasedAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        String purchasedAmount = Console.readLine();

        validator.validatePurchasedAmount(purchasedAmount);

        return new PurchasedAmount(Integer.parseInt(purchasedAmount));
    }
}
