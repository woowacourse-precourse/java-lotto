package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.DealerValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.Message.*;

public class Dealer {

    private Lotto lotto;
    private int bonusNumber;

    public void start() {
        inputAnswerNumbers();
        inputBonusNumber();
    }

    public void inputAnswerNumbers() {
        System.out.print(INPUT_WIN_LOTTO_NUMBER.getMessage());
        String numbers = Console.readLine();
        DealerValidator.validAnswerNumber(numbers);
        List<Integer> lottoNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        lotto = new Lotto(lottoNumbers);
    }

    public void inputBonusNumber() {
        System.out.print(INPUT_BONUS_LOTTO_NUMBER.getMessage());
        String number = Console.readLine();
        DealerValidator.validNumber(number);
        bonusNumber = Integer.parseInt(number);
        DealerValidator.validLottoContainsNumber(lotto.getNumbers(), bonusNumber);
        DealerValidator.validBetween1And45(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
