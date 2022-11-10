package lotto.domain.model;

import static lotto.domain.model.ErrorMessage.BONUS_NUMBER_DUPLICATION;
import static lotto.domain.model.ErrorMessage.COMMON_MESSAGE;
import static lotto.utils.Advice.LottoValidator.checkConsistOfOnlyCommas;
import static lotto.utils.Advice.LottoValidator.checkDuplication;
import static lotto.utils.Advice.LottoValidator.checkRange;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class FirstPlace {
    private static final String DIVIDE_POINT = ",";
    private final List<Integer> firstPlace;

    public FirstPlace(String firstPlace) {
        validate(firstPlace);
        this.firstPlace = Arrays.stream(firstPlace.split(DIVIDE_POINT)).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validate(String firstPlace) {
        checkConsistOfOnlyCommas(firstPlace);
        List<Integer> firstPlaceNumbers = Arrays.stream(firstPlace.split(DIVIDE_POINT)).map(Integer::parseInt)
                .collect(Collectors.toList());
        checkRange(firstPlaceNumbers);
        checkDuplication(firstPlaceNumbers);
    }

    public void duplicateCheckBonusNumber(String bonus) {
        if (this.firstPlace.contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }

    public LottoRank calculateMatch(List<Integer> numbers) {
        int matchPoint = (int) numbers.stream().filter(firstPlace::contains).count();
        return LottoRank.find(String.valueOf(matchPoint));
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
