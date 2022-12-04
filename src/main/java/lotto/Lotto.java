package lotto;

import util.ExceptionPharse;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        LottoException.checkListOutOfRangeExceptioin(numbers);
        LottoException.checkNoDuplicateWinnningLotto(numbers);

        this.numbers = sortedDeepCopy(numbers);;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionPharse.OUT_OF_LOTTO_SIZE.getExceptionMsg());
        }
    }

    // TODO: 추가 기능 구현

    /**
     * Random Test환경에서 실행시 UnsupportedOperationError가 났다
     * 따라서 Test값을 따로 넘겨줘서 정렬하고 사용
     * @param numbers
     * @return
     */
    public List<Integer> sortedDeepCopy(List<Integer> numbers) {
        List<Integer> numbersCopy = new ArrayList<>();
        for (Integer number : numbers) {
            numbersCopy.add(number);
        }
        numbersCopy.sort(Comparator.naturalOrder());
        return numbersCopy;
    }


    @Override
    public String toString() {
        return numbers.toString();
    }

    public static List<Integer> getIntNumbers(List<String> userInput) {
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



    public String numbersToString() {
        List<String> numberList = getStringNumbers();
        return String.join(", ", numberList);
    }

    private List<String> getStringNumbers() {
        return numbers.stream().map(String::valueOf).collect(Collectors.toList());
    }


}
