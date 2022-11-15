package lotto.domain;

import static lotto.constant.Constant.ERROR_MESSAGE;
import static lotto.constant.Constant.FIRST_COUNT;
import static lotto.constant.Constant.LOTTO_COST;
import static lotto.constant.Constant.NUMBER_FORMS;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.IllegalArgumentException;

public class User {

    private static int buyAmount;
    private List<Lotto> myLotto = new ArrayList<>();

    public void setMyLotto(Lotto lotto) {
        myLotto.add(lotto);
    }

    public List<Lotto> getMyLotto() {
        return myLotto;
    }

    public void setBuyAmount(String buyAmount) {
        validate(buyAmount);
        this.buyAmount = Integer.parseInt(buyAmount);
    }

    private void validate(String buyAmount) {
        validateBuyAmountBlank(buyAmount);
        validateBuyAmountForms(buyAmount);
        validateBuyAmountFirstNumber(buyAmount);
        validateBuyAmount(buyAmount);
    }

    private void validateBuyAmountBlank(String buyAmount) {
        if (buyAmount.isEmpty()) {
            System.out.println(ERROR_MESSAGE + "금액이 비어있으면 안됩니다.");
            throw new IllegalArgumentException();
        }
        if (buyAmount.contains(" ")) {
            System.out.println(ERROR_MESSAGE + "금액에 공백이 있으면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateBuyAmountForms(String buyAmount) {
        if (!buyAmount.matches(NUMBER_FORMS)) {
            System.out.println(ERROR_MESSAGE + "금액은 숫자로만 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateBuyAmountFirstNumber(String buyAmount) {
        if (buyAmount.charAt(0) == FIRST_COUNT) {
            System.out.println(ERROR_MESSAGE + "금액의 첫자리가 0이면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateBuyAmount(String buyAmount) {
        if (Integer.parseInt(buyAmount) % LOTTO_COST != 0) {
            System.out.println(ERROR_MESSAGE + "금액은 1000원 단위로 나누어져야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public int getBuyAmount() {
        return buyAmount;
    }
}
