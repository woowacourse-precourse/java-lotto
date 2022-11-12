package lotto.validator;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.common.Error;

public class Validator {

    public void isValidPrice(String in) {
        isNumber(in, Error.NUMBER);
        require(Integer.parseInt(in) < 1000, Error.MINUS);
        require(Integer.parseInt(in) % 1000 != 0, Error.THOUSAND);
    }

    public void isValidWinnings(String in) {
        String[] split = in.split(",");
        for (int i = 0; i < split.length; i++) {
            isNumber(split[i], Error.NUMBER);
        }
        Set<Integer> collect = Arrays.stream(split).map(Integer::parseInt)
            .collect(Collectors.toSet());
        require(collect.size() != 6, Error.FORMAT);
        collect.stream().forEach(i -> require(i<1, Error.SIZE));
        collect.stream().forEach(i -> require(i>45, Error.SIZE));
    }

    private void require(final boolean condition, final Error error) {
        if (condition) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }

    private void isNumber(String in, Error error) {
        try {
            Integer.parseInt(in);
        } catch (Exception e) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }
}
