package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    static final String ERROR_MESSAGE_FOR_LOTTO_NUMBER_SIZE = "로또번호는 총 6개여야 합니다.";
    static final String ERROR_MESSAGE_FOR_DISTINCT_LOTTO_NUMBER = "로또번호는 중복이 없어야 합니다.";
    static final String ERROR_MESSAGE_FOR_WINNING_NUMBER = "당첨번호는 오직 숫자와 ,로 구분하여 입력하셔야 합니다.";

    private final List<Integer> numbers;

    public Lotto(String numbers){
        try {
            List<Integer> convertLottoNumber = Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validate(convertLottoNumber);
            this.numbers = convertLottoNumber;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_WINNING_NUMBER);
        }
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBER_SIZE);
        }
        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_DISTINCT_LOTTO_NUMBER);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        int i = 0;
        int iMax = numbers.size() - 1;
        while (true) {
            builder.append(numbers.get(i));
            if (i == iMax) {
                return builder.append(']').toString();
            }
            builder.append(", ");
            ++i;
        }
    }
}
