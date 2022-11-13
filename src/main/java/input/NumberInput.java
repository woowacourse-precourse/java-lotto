package input;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberInput {

    private static final String SEPARATOR = ",";

    private List<Integer> splitInputSeparator(String input) {
        return Stream.of(input.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
