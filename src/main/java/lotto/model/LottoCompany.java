package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 당첨 번호 발표
 */
public class LottoCompany {
    private Lotto winningLotto;
    private int bonusNumber;

    public Lotto getWinningNumbers() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String inputBonusNumber) {
        validateNumeric(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void setWinningLotto(String inputWinningNumbers) {
        List<String> winningNumbers = Arrays.asList(inputWinningNumbers.split(","));
        this.winningLotto = new Lotto(winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private void validateNumeric(String bonusNumber) {
        if (!isNumeric(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validate(int bonusNumber) {
        if (bonusNumber < Constants.MINIMUM_LOTTO_NUMBER || bonusNumber > Constants.MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.");
        }
        if (this.winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 로또 번호와 다른 번호를 입력해야 합니다.");
        }
    }

    private boolean isNumeric(String number) {
        return number.matches("^[0-9]+$");
    }
}
