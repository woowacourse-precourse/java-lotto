package lotto.domain;

import static lotto.domain.ErrorMessage.BONUS_NUMBER_DUPLICATION;
import static lotto.domain.ErrorMessage.COMMON_MESSAGE;
import static lotto.utils.LottoValidator.validateFirstPlace;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class FirstPlace {
    public static final String DIVIDE_POINT = ",";
    private final List<Integer> firstPlace;

    public FirstPlace(String firstPlace) {
        validateFirstPlace(firstPlace);
        this.firstPlace = Arrays.stream(firstPlace.split(DIVIDE_POINT)).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void duplicateCheckBonusNumber(String bonus) {
        if (this.firstPlace.contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + BONUS_NUMBER_DUPLICATION.getMessage());
        }
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
