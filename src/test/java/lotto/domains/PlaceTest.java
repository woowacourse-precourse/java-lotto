package lotto.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlaceTest {
    private static final String VALID_NAME = "FIRST";
    private static final String INVALID_NAME = "abcdefg";

    @Nested
    @DisplayName("valueOf 메서드는")
    class Describe_valueOf {
        @Nested
        @DisplayName("올바른 이름을 입력받으면")
        class Context_when_valid_name {
            @Test
            @DisplayName("이름과 일치하면 place를 리턴한다.")
            void It_returns_valid_enum() {
                Place place = Place.valueOf(VALID_NAME);
                assertThat(place.getCorrection()).isEqualTo(6);
                assertThat(place.getPrize()).isEqualTo(2000000000);
            }
        }

        @Nested
        @DisplayName("올바르지 않은 이름을 입력하면")
        class Context_when_invalid_name {
            @Test
            @DisplayName("에러를 발생한다.")
            void It_throws_error() {
                assertThatThrownBy(() -> Place.valueOf(INVALID_NAME))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("getPlace 메서드는")
    class Describe_getPlace {
        @Nested
        @DisplayName("올바른 범위(3~6)의 count와 false 보너스 넘버가 주어진다면")
        class Context_when_in_range_count_and_bonus_number_is_false {
            @Test
            @DisplayName("해당하는 등수를 반환한다.")
            void It_returns_valid_place() {
                Place place = Place.getPlace(3, false);
                assertThat(place.name()).isEqualTo("FIFTH");
                assertThat(place.getCorrection()).isEqualTo(3);
                assertThat(place.getPrize()).isEqualTo(5000);
            }
        }

        @Nested
        @DisplayName("올바르지 않은 범위의 count가 주어지면")
        class Context_when_out_of_range_count_and_bonus_number_is_false {
            @Test
            @DisplayName("ZERO를 반환한다.")
            void It_returns_zero_place() {
                Place place = Place.getPlace(0, false);
                assertThat(place.name()).isEqualTo("ZERO");
            }
        }
    }

}
