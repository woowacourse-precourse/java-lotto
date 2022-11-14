package lotto.service;

import static lotto.LottoConstant.INPUT_IS_NOT_FALL_APART_ERROR_MESSAGE;
import static lotto.LottoConstant.INPUT_IS_NOT_MATCH_REGEX_ERROR_MESSAGE;
import static lotto.LottoConstant.INPUT_IS_NOT_NUMBER_ERROR_MESSAGE;
import static lotto.LottoConstant.INPUT_IS_TOO_LOW_TO_BUY_LOTTO_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {

    private static final String WINNING_NUMBER_INPUT_VALIDATE_REGEX = "^[0-9]+(,[0-9]+){5}$";

    private LottoService() {
    }

    public static int amountInputToInteger(String input) {
        if (!input.chars().allMatch((Character::isDigit))) {
            throw new IllegalStateException(INPUT_IS_NOT_NUMBER_ERROR_MESSAGE);
        }
        int amount = Integer.parseInt(input);
        if (amount < 1000) {
            throw new IllegalStateException(INPUT_IS_TOO_LOW_TO_BUY_LOTTO_ERROR_MESSAGE);
        }
        if (amount % 1000 != 0) {
            throw new IllegalStateException(INPUT_IS_NOT_FALL_APART_ERROR_MESSAGE);
        }

        return amount;
    }

    public static int getLottoPurchaseCount(int amount) {
        return amount / 1000;
    }

    public static List<Lotto> getLottoNumbers(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < purchaseCount) {
            lottos.add(generateLottoNumber());
        }
        return lottos;
    }

    private static Lotto generateLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new Lotto(numbers);
    }

    private static Lotto getWinningNumber(String input) {
        List<Integer> numbers = new ArrayList<>();
        if (input.matches(WINNING_NUMBER_INPUT_VALIDATE_REGEX)) {
            throw new IllegalStateException(INPUT_IS_NOT_MATCH_REGEX_ERROR_MESSAGE);
        }

        return new Lotto(numbers);
    }
}
