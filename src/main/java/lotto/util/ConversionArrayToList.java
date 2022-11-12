package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionArrayToList {
    public List<Integer> stringArrayToIntegerList(String[] origin) {
        List<Integer> conversion = Arrays.stream(origin)
                .map(i -> Integer.parseInt(i))
                .collect(Collectors.toList());
        return conversion;
    }
}
