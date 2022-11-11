package lotto.domain;

import lotto.exception.LottoError;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LotteryAnswer {
    private Lotto answer;
    private int bonusNumber;

    public Lotto getAnswer() {
        return answer;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    /**
     * 도메인 로직
     */
    public void inputAnswerLotto(String input) {
        StringTokenizer tokens = new StringTokenizer(input, ",");
        List<Integer> numbers = new ArrayList<>();

        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            validate(token);
            numbers.add(Integer.parseInt(token));
        }

        answer = new Lotto(numbers);
    }

    public void inputBonusNumber(String input) {
        validate(input);
        int bonusNumber = Integer.parseInt(input);

        if (getAnswer().getNumbers().contains(bonusNumber))
            throw new IllegalArgumentException(LottoError.DISTINCT_NUMBERS.getErrorMessage());

        this.bonusNumber = bonusNumber;
    }

    private void validate(String token) throws RuntimeException{
        int numericLength = (int) token.chars().filter(Character::isDigit).count();
        if (token.length() != numericLength)
            throw new IllegalArgumentException(LottoError.NOT_NUMERIC.getErrorMessage());

        int number = Integer.parseInt(token);
        if (number < 1 || number > 45)
            throw new IllegalArgumentException(LottoError.INVALID_NUMBER_RANGE.getErrorMessage());
    }
}
