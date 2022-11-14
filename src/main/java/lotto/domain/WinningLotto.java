package lotto.domain;

import lotto.exception.Validator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final Lotto lotto;
    private int bonusNumber;

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusNumber) {
        Validator.validateBonusNumber(lotto, bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public WinningLotto(String input) {
        Validator.validateLottoString(input);
        List<Integer> lotto = convertStringToList(input);
        Collections.sort(lotto);
        this.lotto = new Lotto(lotto);
    }

    private List<Integer> convertStringToList(String input) {
        List<String> numberValues = List.of(input.split(","));
        return numberValues.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
