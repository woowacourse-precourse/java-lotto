package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.Regex;
import lotto.utils.Validation;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(String inputNumbers){
        this.numbers=validate(inputNumbers);
    }

    private List<Integer> validate(String inputNumbers) {
        if(isCorrectLottoNumbers(inputNumbers)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_WINNING_NUMBERS_FORMAT);
        }
        List<Integer> numbers=makeNumbers(inputNumbers);
        if(!Validation.isCorrectSize(numbers)){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_IS_NOT_SIX);
        }
        if(!Validation.isUniqueNumber(numbers)){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_DUPLICATED);
        }
        return numbers;
    }

    private boolean isCorrectLottoNumbers(String inputNumbers){
        return inputNumbers.matches(Regex.LOTTO_NUMBERS);
    }

    private List<Integer> makeNumbers(String inputNumbers){ // 문자열로 주어진 숫자들을 정수 리스트로 만들어 반환하는 함수
        String[] splitResult=inputNumbers.split(",");
        List<Integer> numbers=new ArrayList<>();
        for (String i: splitResult){
            String number=i.trim();
            if(Validation.isInteger(number)){
                numbers.add(Integer.parseInt(number));
            }
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
