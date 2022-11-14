package lotto;

import java.util.*;

public class Lotto {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String LOTTO_SIZE_ERROR = ERROR_MESSAGE + " 로또 번호는 6개 이어야 합니다.";
    private static final String DUPLICATION_ERROR = ERROR_MESSAGE + " 로또 번호 6개는 서로 다른 숫자이어야 합니다.";
    private static final int LOTTO_SIZE = 6;
    private static final int RANK1 = 1;
    private static final int RANK2 = 2;
    private static final int RANK3 = 3;
    private static final int RANK4 = 4;
    private static final int RANK5 = 5;
    private static final int NOT_WIN = 0;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidation(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }

    // TODO: 추가 기능 구현
    public int lottoRanking(List<Integer> winningNumber, Integer bonusNumber) {
        int winningNumberCount = howManyWinningNumbers(winningNumber);
        boolean haveBonusNum = haveBonusNumber(bonusNumber);

        if (winningNumberCount == 6) return RANK1;
        if ((winningNumberCount == 5) && haveBonusNum) return RANK2;
        if ((winningNumberCount == 5) && !haveBonusNum) return RANK3;
        if (winningNumberCount == 4) return RANK4;
        if (winningNumberCount == 3) return RANK5;

        return NOT_WIN;
    }

    private int howManyWinningNumbers(List<Integer> winningNumber) {
        int winningNumberCount = 0;

        for (int i = 0; i < winningNumber.size(); i++)
            if (numbers.contains(winningNumber.get(i)))
                winningNumberCount++;

        return winningNumberCount;
    }

    private boolean haveBonusNumber(Integer bonusNumber) {
        if (numbers.contains(bonusNumber))
            return true;

        return false;
    }

    public void printSortedLottoNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>();

        sortedNumbers.addAll(this.numbers);
        sortedNumbers.sort(Comparator.naturalOrder());

        System.out.println(sortedNumbers);
    }

    private void duplicateValidation(List<Integer> numbers) {
        Set<Integer> duplicationCheck = new HashSet<>(numbers);
        if (duplicationCheck.size() != numbers.size())
            throw new IllegalArgumentException(DUPLICATION_ERROR);
    }
}
