package lotto.domain.lotto.verifier;

import lotto.domain.lotto.domain.Lotto;

import java.util.List;
import java.util.StringTokenizer;

import static lotto.global.constant.VerifierConstants.*;

public class InputNumberVerifier {

    public static void prizeNumberVerifier(List<Integer> inputPrizeNumbers) {
        isList6Size(inputPrizeNumbers);
        isDuplicatedNumberInList(inputPrizeNumbers);
        isNumberFrom1To45(inputPrizeNumbers);
    }

    private static void isList6Size(List<Integer> inputPrizeNumbers) {
        if (inputPrizeNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR + ONLY_INPUT_NUMBER_COUNT_6);
        }
    }

    private static void isDuplicatedNumberInList(List<Integer> inputPrizeNumbers) {
        boolean duplicated = inputPrizeNumbers.stream()
                .distinct()
                .count() != inputPrizeNumbers.size();

        if (duplicated) {
            throw new IllegalArgumentException(ERROR + INPUT_NUMBER_DONT_DUPLICATE);
        }
    }

    private static void isNumberFrom1To45(List<Integer> prizeLottoNumbers) {
        for (Integer prizeLottoNumber : prizeLottoNumbers) {
            if (prizeLottoNumber < 1 || prizeLottoNumber > 45) {
                throw new IllegalArgumentException(ERROR + NUMBER_BETWEEN_1_AND_5);
            }
        }
    }

    public static void bonusNumberVerifier(Lotto prizeLotto, String bonusNumber) {
        isInputBonusNumberOnly1(bonusNumber);
        isDuplicatedAlreadyExistsLottoNumber(prizeLotto, bonusNumber);
        isNumberFrom1To45(List.of(Integer.parseInt(bonusNumber)));
    }

    private static void isDuplicatedAlreadyExistsLottoNumber(Lotto prizeLotto, String bonusNumber) {
        for (int number : prizeLotto.getNumbers()) {
            if (number == Integer.parseInt(bonusNumber)) {
                throw new IllegalArgumentException(ERROR + WINNING_NUMBER_AND_BONUS_NUMBER_DONT_DUPLICATE);
            }
        }
    }

    private static void isInputBonusNumberOnly1(String bonusNumber) {
        StringTokenizer st = new StringTokenizer(bonusNumber, ",");
        if (st.countTokens() != 1) {
            throw new IllegalArgumentException(ERROR + INPUT_BONUS_NUMBER_ONLY_1);
        }
    }
}
