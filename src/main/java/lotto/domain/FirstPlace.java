package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.utils.InputValidator;


public class FirstPlace {
    public static final String DIVIDE_POINT = ",";
    private final List<Integer> firstPlace;

    public FirstPlace(String firstPlace) {
        InputValidator.validateFirstPlace(firstPlace);
        this.firstPlace = Arrays.stream(firstPlace.split(DIVIDE_POINT)).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FirstPlace that = (FirstPlace) o;
        return Objects.equals(firstPlace, that.firstPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPlace);
    }
}
