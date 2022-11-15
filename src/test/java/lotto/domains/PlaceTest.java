package lotto.domains;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlaceTest {
    private static final String VALID_NAME = "FIRST";
    private static final String INVALID_NAME = "abcdefg";

    @Nested
    class Describe_valueOf {
        @Nested
        class Context_when_valid_name {
            @Test
            void It_returns_valid_enum() {
                Place place = Place.valueOf(VALID_NAME);
                assertThat(place.getCorrection()).isEqualTo(6);
                assertThat(place.getPrize()).isEqualTo(2000000000);
            }
        }

        @Nested
        class Context_when_invalid_name {
            @Test
            void It_throws_error() {
                assertThatThrownBy(() -> Place.valueOf(INVALID_NAME))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    class Describe_getPlace {
        @Nested
        class Context_when_in_range_count_and_bonus_number_is_false {
            @Test
            void It_returns_valid_place() {
                Place place = Place.getPlace(3, false);
                assertThat(place.name()).isEqualTo("FIFTH");
                assertThat(place.getCorrection()).isEqualTo(3);
                assertThat(place.getPrize()).isEqualTo(5000);
            }
        }

        @Nested
        class Context_when_out_of_range_count_and_bonus_number_is_false {
            @Test
            void It_returns_zero_place() {
                Place place = Place.getPlace(0, false);
                assertThat(place.name()).isEqualTo("ZERO");
            }
        }
    }

}
