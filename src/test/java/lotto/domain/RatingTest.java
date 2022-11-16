package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RatingTest {

   @DisplayName("2등올 입력 시 맞게 나오는지 확인한다.")
    @Test
    void getRatingSecond() {
       int count = 5;
       boolean bonus = true;

       Rating rating = Rating.getRating(count, bonus);

       assertThat(rating).isEqualTo(Rating.SECOND);
    }

    @DisplayName("3등올 입력 시 맞게 나오는지 확인한다.")
    @Test
    void getRatingThird() {
        int count = 5;
        boolean bonus = false;

        Rating rating = Rating.getRating(count, bonus);

        assertThat(rating).isEqualTo(Rating.THIRD);
    }

    @DisplayName("5등올 입력 시 맞게 나오는지 확인한다.")
    @Test
    void getRatingFifth() {
        int count = 3;
        boolean bonus = false;

        Rating rating = Rating.getRating(count, bonus);

        assertThat(rating).isEqualTo(Rating.FIFTH);
    }

    @DisplayName("1개 맞췄을 때 입력 시 맞게 나오는지 확인한다.")
    @Test
    void getRating() {
        int count = 1;
        boolean bonus = false;

        Rating rating = Rating.getRating(count, bonus);

        assertThat(rating).isEqualTo(Rating.NONE);
    }
}