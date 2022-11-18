package lotto.exception;

import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class UIException extends IllegalArgumentException {

    public void notNumberException(String money) {
        try {
            int moneyInt = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 숫자가 아닙니다.");
        }
    }

    public void notMultipleOf1000Exception(String money) {
        int moneyInt = Integer.parseInt(money);
        if (moneyInt % 1000 != 0) throw new IllegalArgumentException("[ERROR] 돈이 1000의 배수가 아닙니다.");
    }

    public void duplicateNumberException(List<Integer> lotto) {
        Set<Integer> set = new HashSet<>(lotto);
        if (set.size() != lotto.size()) throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
    }

    public void overBoundaryException(List<Integer> lotto) {
        for (Integer e : lotto) {
            if (e > 45) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            if (e < 1) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void CheckLottoLength(List<String> lottoNumber) {
        if (lottoNumber.size() != 6) throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    public void BonusNumberException(List<Integer> lotto, int bonus) {
        if (lotto.contains(bonus)) throw new IllegalArgumentException("[ERROR] 보너스 숫자가 로또 번호와 중복됩니다.");
    }

}
