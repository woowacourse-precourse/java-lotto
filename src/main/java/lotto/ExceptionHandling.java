package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class ExceptionHandling {

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String LOTTO_NUMBER_REGEX = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";

    public void notDivide(long amount) {
        if (amount % 1000 != 0 || amount <= 0) {
            throw new IllegalArgumentException(ShowErrorMessage.showNotDivide());
        }
    }

    public void isNumeric(String value) {
        if (!Pattern.matches(NUMBER_REGEX, value) || value.equals("")) { // 숫자가 아니라면
            throw new IllegalArgumentException(ShowErrorMessage.showOutRangeLottoNumber());
        }
    }

    public void outRangeLottoNumber(String value) {
        if (!Pattern.matches(LOTTO_NUMBER_REGEX, value) || value.equals("")) { // 로또 번호의 범위가 아니라면
            throw new IllegalArgumentException(ShowErrorMessage.showOutRangeLottoNumber());
        }
    }

    public void removeDuplicateNumber(List<Integer> winNumber) {
        Set<Integer> winNumberSet = new HashSet<>(winNumber);
        if (winNumberSet.size() != winNumber.size()) {
            throw new IllegalArgumentException(ShowErrorMessage.showDuplicateLottoNumber());
        }
    }

    public void containsBonusNumber(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ShowErrorMessage.showContainsBonusNumber());
        }
    }

}
