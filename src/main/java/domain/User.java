package domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {

    private int inputUserMoney;

    private int totalLotto;
    private List<Lotto> totalLottoNumbers;

    public int getInputUserMoney() {
        return inputUserMoney;
    }

    public void setInputUserMoney(int inputUserMoney) {
        validateInputUserMoney(inputUserMoney);
        this.inputUserMoney = inputUserMoney;
    }

    public List<Lotto> getTotalLottoNumbers() {
        return totalLottoNumbers;
    }

    public void setTotalLottoNumbers(List<Lotto> totalLottoNumbers) {
        this.totalLottoNumbers = totalLottoNumbers;
    }

    public int getTotalLotto() {
        return totalLotto;
    }

    public void setTotalLotto(int totalLotto) {
        this.totalLotto = totalLotto;
    }

    private void validateInputUserMoney(int inputUserMoney) {
        try {
            if (inputUserMoney % 1000 != 0) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액 입력값은 1000원 단위여야 합니다");
            System.exit(0);
        }
    }
}
