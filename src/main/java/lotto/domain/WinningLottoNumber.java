package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validator;

public class WinningLottoNumber {
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public WinningLottoNumber(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public WinningLottoNumber(String winningNumber, String bonusNumber) {
        Validator validator = new Validator();
        String comma = ",";
        String[] splitNumber = winningNumber.split(comma);
        validator.validateWinningNumber(splitNumber);
        this.winningNumber = Arrays.asList(splitNumber).stream().map(String::trim).mapToInt(Integer::valueOf).boxed()
                .collect(Collectors.toList());
        validator.validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
