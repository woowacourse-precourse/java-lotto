package lotto;

import Info.InputException;
import Info.PrintGameInfo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_MAX_NUMBER = 45; // 로또 최대 숫자
    public static final int LOTTO_MIN_NUMBER = 1; // 로또 최소 숫자
    public static final int LOTTO_NUMBER_COUNT = 6; // 로또 숫자 갯수
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        outOfRangeExceptioin(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(PrintGameInfo.OVER_LOTTO_COUNT);
        }
    }

    // TODO: 추가 기능 구현
    public static boolean isOutOfRange(Integer number) {
        return number > LOTTO_MAX_NUMBER || number < LOTTO_MIN_NUMBER;
    }

    private static List<Integer> getIntNumbers(List<String> userInput) {
        return userInput.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    /**
     * 사용자 입력에 대해 로또 클래스로 반환해주는 함수
     * @param userInput
     * @return
     */
    public static Lotto stringListToLotto(List<String> userInput) {
        return new Lotto(getIntNumbers(userInput));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void outOfRangeExceptioin(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(isOutOfRange(number)) {
                throw new IllegalArgumentException(PrintGameInfo.getOutOfRange());
            }
        }
    }

    public String numbersToString() {
        List<String> numberList = getStringNumbers();
        return String.join(", ", numberList);
    }

    private List<String> getStringNumbers() {
        return numbers.stream().map(String::valueOf).collect(Collectors.toList());
    }


}
