package lotto.util;

import static lotto.constant.Constant.ERROR_MESSAGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.IllegalArgumentException;

public class ConversionArrayToList {
    public List<Integer> stringArrayToIntegerList(String[] origin) {
        validate(origin);
        List<Integer> conversion = Arrays.stream(origin)
                .map(i -> Integer.parseInt(i))
                .collect(Collectors.toList());
        return conversion;
    }

    private void validate(String[] origin) {
        for (String number : origin) {
            if (number.isEmpty()) {
                System.out.println(ERROR_MESSAGE + "로또 넘버 값이 비어있으면 안됩니다.");
                throw new IllegalArgumentException();
            }
            if (number.contains(" ")) {
                System.out.println(ERROR_MESSAGE + "로또 넘버값을 넣을때 공백이 있으면 안됩니다.");
                throw new IllegalArgumentException();
            }
        }
    }
}
