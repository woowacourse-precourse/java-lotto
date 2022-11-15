package lotto.service;

import lotto.model.Lotto;
import lotto.util.ArgumentExceptionMessage;
import lotto.util.LottoConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/14
 */
public class LottoService {
    public int toPurchaseAmount(String input) {
        validPurchaseAmount(input);
        return divideLottoPrice(toInteger(input));
    }

    public Lotto toLotto(String input) {
        validLottoNumbers(input);
        return new Lotto(toIntegerList(input));
    }

    public int toBonusNumber(String input, Lotto lotto) {
        validBonusNumber(input, lotto);
        return toInteger(input);
    }

    private List<Integer> toIntegerList(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        Arrays.stream(input.split(","))
                .forEach(s -> winningNumbers.add(toInteger(s)));
        return winningNumbers;
    }

    private void validPurchaseAmount(String input) {
        checkNumeric(input);
    }

    private void validLottoNumbers(String input) {
        checkForm(input);
    }

    private void validBonusNumber(String input, Lotto lotto) {
        checkNumeric(input);
        checkRange(toInteger(input));
        checkOverlap(toInteger(input), lotto);
    }

    private int toInteger(String input) {
        return Integer.parseInt(input);
    }

    private int divideLottoPrice(int purchaseAmount) {
        checkDivideLottoPrice(purchaseAmount);
        return purchaseAmount / LottoConstant.LOTTO_PRICE.getValue();
    }

    private void checkDivideLottoPrice(int purchaseAmount) {
        if (purchaseAmount % LottoConstant.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_PURCHASE_AMOUNT_UNCONFORMABLE_VALUE.getMessage());   // 구매 금액이 1000원 단위가 아닌 경우
        }
    }

    private void checkNumeric(String input) {
        if (!input.matches("[1-9]+[0-9]*")) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_NOT_INTEGER.getMessage());   // 입력받은 값이 정수로 표현되지 않는 경우
        }
    }

    private void checkRange(int bonusNumber) {
        if (bonusNumber < LottoConstant.LOTTO_RANGE_MIN.getValue() || bonusNumber > LottoConstant.LOTTO_RANGE_MAX.getValue()) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_LOTTO_UNCONFORMABLE_NUMBER_RANGE.getMessage());   // 입력받은 값이 로또 번호의 범위를 초과한 경우
        }
    }

    private void checkOverlap(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_LOTTO_NUMBER_OVERLAP.getMessage());   // 입력받은 값이 당첨 번호와 중복되는 경우
        }
    }

    private void checkForm(String input) {
        if (!input.matches("[[1-9]+[0-9]*,]+[1-9]+[0-9]*")) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_LOTTO_UNCONFORMABLE_FROM.getMessage());   // 입력받은 값이 숫자와 ,로 이루어지지 않은 경우
        }
    }
}
