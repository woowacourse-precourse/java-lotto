package lotto;

import util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int LOTTO_LENGTH = 6;
    private Lotto lotto;
    private final int bonusNumber;
    private final List<Integer> winningNumbers;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


    public WinningNumbers(String winningNumbers, String bonusNumber) {
        List<String> winningNumberSplit = Arrays.asList(winningNumbers.split(","));
        validate(convertStringToList(winningNumberSplit),bonusNumber);
        this.winningNumbers = convertStringToList(winningNumberSplit);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public Ranking calculateRanking(Lotto otherLotto) {
        int cnt = calculateSameCount(winningNumbers,otherLotto);
        return Ranking.getRanking(cnt, otherLotto.contains(bonusNumber));
    }
    private void validate(List<Integer> winningNumbers,String bonusNumber) {
        Validator validator = new Validator();
        validator.validateLength(winningNumbers,LOTTO_LENGTH);
        validator.validateRange(winningNumbers);
        validator.validateDuplicate(winningNumbers);
        validator.validateBonusNumber(winningNumbers, bonusNumber);
    }

    private List<Integer> convertStringToList(List<String> winningNumbers) {
        return winningNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
    public int calculateSameCount(List<Integer> winningNumbers, Lotto otherLotto) {
        return otherLotto.compareLottoNumbers(winningNumbers);
    }

}
