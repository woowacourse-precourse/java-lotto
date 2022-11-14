package lotto;

import java.util.List;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;
    private final List<Integer> numbers;

    private final Exception exception = new Exception();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        exception.checkLottoNumbers(numbers);
    }

    public int getRank(String[] winningNumbers, String bonusNumber) {
        if (isFirst(winningNumbers)) {
            return 0;
        } else if (isSecond(winningNumbers, bonusNumber)) {
            return 1;
        } else if (isThird(winningNumbers)) {
            return 2;
        } else if (isFourth(winningNumbers)) {
            return 3;
        } else if (isFifth(winningNumbers)) {
            return 4;
        }

        return -1;
    }

    private boolean isFirst(String[] winningNumbers) {
        int sameCount = getSameCount(winningNumbers);

        return sameCount == 6;
    }

    private boolean isSecond(String[] winningNumbers, String bonusNumber) {
        int sameCount = getSameCount(winningNumbers);
        int bonusCount = getBonusCount(bonusNumber);

        return sameCount == 5 && bonusCount == 1;
    }

    private boolean isThird(String[] winningNumbers) {
        int sameCount = getSameCount(winningNumbers);

        return sameCount == 5;
    }

    private boolean isFourth(String[] winningNumbers) {
        int sameCount = getSameCount(winningNumbers);

        return sameCount == 4;
    }

    private boolean isFifth(String[] winningNumbers) {
        int sameCount = getSameCount(winningNumbers);

        return sameCount == 3;
    }

    private int getSameCount(String[] winningNumbers) {
        int sameCount = 0;

        for (String number : winningNumbers) {
            int winningNumber = Integer.parseInt(number);
            if (numbers.contains(winningNumber)) {
                sameCount++;
            }
        }
        return sameCount;
    }

    private int getBonusCount(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        if (numbers.contains(number)) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
