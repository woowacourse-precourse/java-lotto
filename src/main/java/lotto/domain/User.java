package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
        this.buyAmount = Integer.parseInt(buyAmount);
    }

    private void validate(String buyAmount) {
        validateBuyAmountForms(buyAmount);
        validateBuyAmountFirstNumber();
        validateBuyAmount();
    }

    private void validateBuyAmountForms(String buyAmount) {
        if (!buyAmount.matches("^[0-9]*$")) {
            System.out.println("[ERROR] 금액은 숫자로만 이루어져야 합니다.");
            throw new NoSuchElementException();
        }
    }

    private void validateBuyAmountFirstNumber(String buyAmount) {
        if (buyAmount.charAt(0) == '0') {
            System.out.println("[ERROR] 금액의 첫자리가 0이면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    public int getBuyAmount() {
        return buyAmount;
    }
}
