package lotto.domain.statistics;

import static lotto.domain.place.MatchResult.FIFTH_PLACE;
import static lotto.domain.place.MatchResult.FIRST_PLACE;
import static lotto.domain.place.MatchResult.FOURTH_PLACE;
import static lotto.domain.place.MatchResult.SECOND_PLACE;
import static lotto.domain.place.MatchResult.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaceHistoryTest {

    private PlaceHistory placeHistory;

    @BeforeEach
    void setUp() {
        this.placeHistory = new PlaceHistory();

        //5등 5회, 4등 4회, 3등 3회, 2등 2회, 1등 1회
        placeHistory.updateFor(FIFTH_PLACE);
        placeHistory.updateFor(FIFTH_PLACE);
        placeHistory.updateFor(FIFTH_PLACE);
        placeHistory.updateFor(FIFTH_PLACE);
        placeHistory.updateFor(FIFTH_PLACE);

        placeHistory.updateFor(FOURTH_PLACE);
        placeHistory.updateFor(FOURTH_PLACE);
        placeHistory.updateFor(FOURTH_PLACE);
        placeHistory.updateFor(FOURTH_PLACE);

        placeHistory.updateFor(THIRD_PLACE);
        placeHistory.updateFor(THIRD_PLACE);
        placeHistory.updateFor(THIRD_PLACE);

        placeHistory.updateFor(SECOND_PLACE);
        placeHistory.updateFor(SECOND_PLACE);

        placeHistory.updateFor(FIRST_PLACE);
    }

    @Test
    void 기록_합_테스트() {
        long actual = placeHistory.amountSum();
        long expected = 2_064_725_000;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 문자열화_테스트() {
        String actual = placeHistory.toString();
        String expected = "3개 일치 (5,000원) - 5개\n"
                + "4개 일치 (50,000원) - 4개\n"
                + "5개 일치 (1,500,000원) - 3개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n"
                + "6개 일치 (2,000,000,000원) - 1개\n";

        assertThat(actual).isEqualTo(expected);
    }
}