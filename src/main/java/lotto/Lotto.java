package lotto;

import java.util.List;

public class Lotto {
    static final int startLotto = 1;
    static final int endLotto = 45;
    static final int sizeLotto = 6;
    static final int asciiZero = 48;
    static final int asciiNine = 57;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDup(numbers);
        this.numbers = numbers;
    }

    public static List<Integer> validateInput(List<Integer> lottoAnswer, String inputAnswer) throws IllegalArgumentException {
        String[] inputSplitAnswer = inputAnswer.split(",");
        for (String inputNumber : inputSplitAnswer) {
            int number = Integer.parseInt(inputNumber);
            if ((number >= startLotto) && (number <= endLotto)) {
                lottoAnswer.add(number);
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 로또 번호는  ',' 로 구분된 1부터 45 사이의 숫자여야 합니다.");
        }
        return lottoAnswer;
    }

    public void validateCount(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != sizeLotto) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 6개를 입력해주세요.");
        }
    }

    public void validateDup(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (numbers.contains(number) && numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자입니다.");
            }
        }
    }

    public void getLottoBonusNumber(String bonusNumber) throws IllegalArgumentException {
        validateBonusNumberInput(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDup(bonusNumber);
        numbers.add(Integer.parseInt(bonusNumber));
    }

    public void validateBonusNumberInput(String bonusNumber) throws IllegalArgumentException {
        for (int i = 0; i < bonusNumber.length(); i++) {
            if (bonusNumber.charAt(i) >= asciiZero && bonusNumber.charAt(i) <= asciiNine) {
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 숫자로만 입력 해주세요");
        }
    }

    public void validateBonusNumberRange(String bonusNumber) throws IllegalArgumentException {
        int bonusNum = Integer.parseInt(bonusNumber);
        if (bonusNum >= startLotto && bonusNum <= endLotto) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1부터 45사이의 숫자입니다.");
    }

    public void validateBonusNumberDup(String bonusNumber) throws IllegalArgumentException {
        if (numbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 로또번호와 중복되지 않아야합니다.");
        }
    }

    public List<Integer> printLottoNumber() {
        return numbers;
    }

}
