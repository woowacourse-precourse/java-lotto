package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lotto 클래스 테스트")
class LottoTest {

    @Nested
    @DisplayName("로또 번호는 주어진 형식을 만족한다.")
    class describe_condition_of_Lotto {

        @Nested
        @DisplayName("로또 번호는 6개의 숫자로 구성되어야 한다.")
        class lotto_is_consist_of_6_numbers {

            @Test
            @DisplayName("숫자가 6개를 넘는 경우 예외가 발생한다.")
            void createLottoMoreThanSixNumber() {
                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(
                        IllegalArgumentException.class);

                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 8))).isInstanceOf(
                        IllegalArgumentException.class);
            }

            @Test
            @DisplayName("숫자가 6개보다 적은 경우 예외가 발생한다.")
            void createLottoLessThanSixNumber() {
                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                        .isInstanceOf(IllegalArgumentException.class);

                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Test
        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        void createLottoByDuplicatedNumber() {
            // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또 번호 중 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
        void createLottoHasOutOfRangeNumber() {
            // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 46, 25, 6))).isInstanceOf(
                    IllegalArgumentException.class);

            assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 44, 25, 6))).isInstanceOf(
                    IllegalArgumentException.class);
        }

        @Test
        @DisplayName("모든 조건을 만족하면 Lotto 객체를 생성한다")
        void createNormalLotto() {
            new Lotto(List.of(1, 2, 3, 4, 5, 6));
            new Lotto(List.of(1, 2, 3, 4, 5, 45));
            new Lotto(List.of(45, 44, 43, 42, 41, 40));
        }
    }

    @Nested
    @DisplayName("getCountOfMatchNumber 메서드는")
    class describe_getCountOfMatchNumber {

        @Nested
        @DisplayName("다른 Lotto 객체를 인수로 받아 받아")
        class get_other_lotto_object_as_parameter {

            @Test
            @DisplayName("일치하는 숫자의 개수를 반환한다")
            void returnCountOfMatchNumber() {
                Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));

                Assertions.assertThat(lottoA.getCountOfMatchNumber(new Lotto(List.of(6, 5, 4, 3, 2, 1))))
                        .isEqualTo(6);
                Assertions.assertThat(lottoA.getCountOfMatchNumber(new Lotto(List.of(1, 3, 5, 7, 9, 11))))
                        .isEqualTo(3);
                Assertions.assertThat(lottoA.getCountOfMatchNumber(new Lotto(List.of(11, 9, 7, 5, 3, 1))))
                        .isEqualTo(3);
                Assertions.assertThat(lottoA.getCountOfMatchNumber(new Lotto(List.of(6, 7, 8, 9, 10, 11))))
                        .isEqualTo(1);
                Assertions.assertThat(lottoA.getCountOfMatchNumber(new Lotto(List.of(7, 8, 9, 10, 11, 12))))
                        .isEqualTo(0);
            }
        }
    }

    @Nested
    @DisplayName("hasBonusNumber 메서드는")
    class describe_hasBonusNumber {

        @Nested
        @DisplayName("숫자를 인수로 받아")
        class get_bonus_number_as_parameter {

            @Test
            @DisplayName("해당 숫자를 가지고 있는지 여부를 반환한다")
            void returnWhetherItHasRandomNumber() {
                Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));

                Assertions.assertThat(lottoA.hasNumber(1)).isEqualTo(true);
                Assertions.assertThat(lottoA.hasNumber(2)).isEqualTo(true);
                Assertions.assertThat(lottoA.hasNumber(3)).isEqualTo(true);
                Assertions.assertThat(lottoA.hasNumber(4)).isEqualTo(true);
                Assertions.assertThat(lottoA.hasNumber(5)).isEqualTo(true);
                Assertions.assertThat(lottoA.hasNumber(6)).isEqualTo(true);

                Assertions.assertThat(lottoA.hasNumber(10)).isEqualTo(false);
                Assertions.assertThat(lottoA.hasNumber(11)).isEqualTo(false);
            }
        }
    }

    @Nested
    @DisplayName("toString 메서드는")
    class describe_toString {

        @Test
        @DisplayName("로또 번호의 숫자 정보를 반환한다")
        void returnWhetherItHasRandomNumber() {
            Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            Assertions.assertThat(lottoA.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        }
    }
}
