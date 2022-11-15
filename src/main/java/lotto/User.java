package lotto;

import lotto.Message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class User {
    private Integer money;
    private Integer lottoQuantity;
    private List<Lotto> lotto;

    public Integer getMoney() {
        return money;
    }

    public Integer getLottoQuantity() {
        return lottoQuantity;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public User(String money) {
        validate(money);
        this.money = Integer.valueOf(money);
        this.lottoQuantity = Integer.valueOf(money) / 1000;
        this.lotto = new ArrayList<>();
    }

    private void validate(String money) {
        validateNumeric(money);
        validateDivided(money);
        validatePositive(money);
    }

    private void validateNumeric(String money) {
        try {
            Integer inputMoney = Integer.valueOf(money);
        } catch (NumberFormatException e) {
            ErrorMessage.printNonNumericInputErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    private void validatePositive(String money) {
        if (Integer.valueOf(money) < 0) {
            ErrorMessage.printNegativeNumberErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    private void validateDivided(String money) {
        if (Integer.valueOf(money) % 1000 != 0) {
            ErrorMessage.printMoneyInputErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public String makeLottoNumbers() {
        String lottoNumbers = "";
        for (int index = 0; index < lottoQuantity; index++) {
            lottoNumbers += lotto.get(index).getNumbers();
            lottoNumbers += "\n";
        }
        return lottoNumbers;
    }

    public void buyLotto() {
        for (int quantity = 0; quantity < lottoQuantity; quantity++) {
            Lotto lottoNumbers = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
            lotto.add(lottoNumbers);
        }
    }


}
