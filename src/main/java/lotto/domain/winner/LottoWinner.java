package lotto.domain.winner;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoConstants;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.winner.Constants.LOTTO_WINNER_REGEX;

public class LottoWinner {
    private Lotto lotto;
    private Integer bonusNumber;

    public void setLotto(String input) {
        this.lotto = new Lotto(convertToList(input));
    }

    public void setBonusNumber(String input) {
        int bonusNumber = Integer.parseInt(input);
        validate(Integer.parseInt(input));
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> convertToList(String input) {
        isValidNumber(input);
        return isUnique(input);
    }

    private boolean isValidNumber(String input) {
        if (input.matches(LOTTO_WINNER_REGEX)) {
            return true;
        }

        throw new IllegalArgumentException();
    }

    private List<Integer> isUnique(String input) {
        List<Integer> lottoNumbers = covertType(input);

        if (getUniqueCount(lottoNumbers) == LottoConstants.LOTTO_SIZE.getNumber()) {
            return lottoNumbers;
        }

        throw new IllegalArgumentException();
    }

    private long getUniqueCount(List<Integer> lottoNumbers) {
        long lottoCount = lottoNumbers.stream()
                .distinct()
                .count();
        return lottoCount;
    }

    private List<Integer> covertType(String input) {
        List<String> inputNumber = new ArrayList<>(List.of(input.split(",")));
        List<Integer> lottoNumbers = new ArrayList<>();

        inputNumber.forEach(n -> lottoNumbers.add(Integer.parseInt(n)));
        return lottoNumbers;
    }


    private void validate(int bonusNumber) {
        if (isInvalidRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidRange(int bonusNumber) {
        return LottoConstants.LOTTO_MIN_VALUE.getNumber() > bonusNumber
                || bonusNumber > LottoConstants.LOTTO_MAX_VALUE.getNumber();
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
