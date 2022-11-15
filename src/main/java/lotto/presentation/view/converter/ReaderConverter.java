package lotto.presentation.view.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderConverter {

    public static Integer convertInteger(String number) {
        return Integer.parseInt(number);
    }

    public static List<Integer> convertIntegerList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }
    
}