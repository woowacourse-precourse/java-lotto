package lotto;

import java.util.List;

public class Lotto {
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
            if (number >= 0 && number <= 45) {
                lottoAnswer.add(number);
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 범위 외의 값 입력");
        }
        return lottoAnswer;
    }

    private void validateCount(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개 이하 수 입력");
        }
    }

    private void validateDup(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (numbers.contains(number) && numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                throw new IllegalArgumentException("[ERROR] 중복 입력 불가");
            }
        }
    }

    public void getLottoBonusNumber(String bonusNumber) throws IllegalArgumentException {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDup(bonusNumber);
        numbers.add(Integer.parseInt(bonusNumber));
    }

    private void validateBonusNumberRange(String bonusNumber) throws IllegalArgumentException {
        for (int i = 0; i < bonusNumber.length(); i++) {
            if (bonusNumber.charAt(i) >= 48 && bonusNumber.charAt(i) <= 57) {
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값 숫자로만 입력");
        }
    }

    private void validateBonusNumberDup(String bonusNumber) throws IllegalArgumentException {
        if (numbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값 로또 번호 중복");
        }
    }

    public List<Integer> printLottoNumber() {
        return numbers;
    }

}
