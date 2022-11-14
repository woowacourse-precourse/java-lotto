package lotto.data.dto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.type.ExceptionType;
import lotto.type.PatternType;
import utils.Validator.StringValidator;

public class WinNumberDto {

    private final Set<Integer> winNumbers;

    WinNumberDto(Set<Integer> winNumbers){
        this.winNumbers = Collections.unmodifiableSet(winNumbers);
    }

    public Set<Integer> getWinNumbers() {
        return this.winNumbers;
    }

    public static WinNumberDto createWithInput(String input) {
        validate(input);
        Set<Integer> winNumbers = splitWithComma(input).stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        return new WinNumberDto(Set.copyOf(winNumbers));
    }

    private static void validate(String input) throws IllegalArgumentException {
        if(hasWrongSplitFormat(input)) {
            throw ExceptionType.FORMAT.getException();
        }

    }

    private static boolean hasWrongSplitFormat(String input) {
        return !StringValidator.matchesPattern(input, PatternType.WIN_NUMBER.getPattern());
    }

    private static List<String> splitWithComma(String input) {
        return Arrays.asList(input.split(","));
    }
}
