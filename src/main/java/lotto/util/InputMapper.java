package lotto.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputMapper {

    public Set<Integer> stringToSetSplitBy(String input, String regex) throws NumberFormatException {
        return Arrays.stream(input.split(regex)).map(String::trim).map(Integer::parseInt).collect(Collectors.toSet());
    }
}
