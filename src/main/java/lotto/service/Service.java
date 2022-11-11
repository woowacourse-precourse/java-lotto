package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.Utils;
import lotto.validation.Validation;
import lotto.view.InputMessage;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Service {
    private static final int LOTTO_START_NUMBER=1;
    private static final int LOTTO_LAST_NUMBER=45;
    private static final int LOTTO_LENGTH=6;
    private static final int LOTTO_LEAST_AMOUNT=1_000;
    private static final int LOTTO_MAX_AMOUNT = 100_000;

    public int getInputAmount(){
        InputMessage.inputAmount();
        int amount = Integer.parseInt(readLine().trim());
        Validation.validateMultipleNumber(amount, LOTTO_LEAST_AMOUNT);
        Validation.validateExceedNumber(amount, LOTTO_MAX_AMOUNT);
        return amount;
    }

    public Lotto generateLottoNumber(){
        List<Integer> numbers = Utils.randomUniqueNumberGenerate(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER, LOTTO_LENGTH);

        Validation.validateLengthOfList(numbers, LOTTO_LENGTH);
        Validation.validateDuplicationList(numbers);
        Validation.validateListNumberInRange(numbers, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);

        Utils.sortListNaturalOrder(numbers);
        return new Lotto(numbers);
    }
}
