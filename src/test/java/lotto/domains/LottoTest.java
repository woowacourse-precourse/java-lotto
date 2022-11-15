package lotto.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final int LOTTO_SIZE = 6;

    @Nested
    @DisplayName("numbers만 존재하는 생성자는")
    class Describe_numbers_constructor {
        @Nested
        @DisplayName("올바른 번호로 생성했을 때")
        class Context_when_valid_lotto_numbers {
            private List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

            @Test
            @DisplayName("보너스 번호가 없는 로또 객체가 생성된다.")
            void It_creates_valid_lotto_object_without_bonus_number() {
                Lotto lotto = new Lotto(numbers);
                assertThat(lotto.getNumbers().size()).isEqualTo(LOTTO_SIZE);
                assertThatThrownBy(lotto::getBonusNumber)
                        .hasMessageContaining("[ERROR] 보너스 번호가 초기화 되지 않았습니다.")
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("번호의 길이가 기준보다 짧다면")
        class Context_when_under_size_lotto_numbers {
            private final List<Integer> numbers = List.of(1, 2, 3, 4, 5);

            @Test
            @DisplayName("에러를 발생시킨다.")
            void It_throw_illegal_argument_exception() {
                assertThatThrownBy(() -> new Lotto(numbers))
                        .hasMessageContaining("로또 번호의 갯수는 반드시 6개여야 합니다.")
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("번호의 길이가 기준보다 길다면")
        class Context_when_over_size_lotto_numbers {
            private final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

            @Test
            @DisplayName("에러를 발생시킨다.")
            void It_throw_illegal_argument_exception() {
                assertThatThrownBy(() -> new Lotto(numbers))
                        .hasMessageContaining("로또 번호의 갯수는 반드시 6개여야 합니다.")
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("중복되는 번호가 있다면")
        class Context_when_duplicate_lotto_numbers {
            private final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

            @Test
            @DisplayName("에러를 발생시킨다.")
            void It_throw_illegal_argument_exception() {
                assertThatThrownBy(() -> new Lotto(numbers))
                        .hasMessageContaining("로또 번호는 중복될 수 없습니다.")
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("범위에 속하지 않는 번호가 있다면")
        class Context_when_over_range_lotto_numbers {
            private final List<Integer> numbers = List.of(-1, 2, 3, 4, 5, 46);

            @Test
            @DisplayName("에러를 발생시킨다.")
            void It_throw_illegal_argument_exception() {
                assertThatThrownBy(() -> new Lotto(numbers))
                        .hasMessageContaining("로또 번호는 반드시 1과 45 사이의 숫자여야합니다.")
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("numbers와 bonusNumber가 있는 생성자는")
    class Describe_numbers_and_bonus_number_constructor {
        @Nested
        @DisplayName("올바른 번호와 보너스 번호로 생성할 때")
        class Context_when_valid_numbers_and_valid_bonus_number {
            private List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            private int bonusNumber = 7;
            @Test
            @DisplayName("보너스번호와 일반 번호를 가진 객체가 생성된다.")
            void It_creates_valid_lotto_object() {
                Lotto lotto = new Lotto(numbers, bonusNumber);

                assertThat(lotto.getNumbers().size()).isEqualTo(LOTTO_SIZE);
                assertThat(lotto.getBonusNumber()).isEqualTo(7);
            }
        }

        @Nested
        @DisplayName("올바른 번호와 겹치는 보너스 번호로 생성할 때")
        class Context_when_valid_numbers_and_duplicate_bonus_number {
            private List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            private int bonusNumber = 6;
            @Test
            @DisplayName("에러를 발생시킨다.")
            void It_creates_valid_lotto_object() {
                assertThatThrownBy(() -> new Lotto(numbers, bonusNumber))
                        .hasMessageContaining("보너스 번호는 로또 발행번호와 일치하지 않아야 합니다.")
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("올바른 번호와 범위를 벗어나는 보너스 번호로 생성할 때")
        class Context_when_valid_numbers_and_out_of_range_bonus_number {
            private List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            private int bonusNumber = 56;
            @Test
            @DisplayName("에러를 발생시킨다.")
            void It_creates_valid_lotto_object() {
                assertThatThrownBy(() -> new Lotto(numbers, bonusNumber))
                        .hasMessageContaining("[ERROR] 로또 번호는 반드시 1과 45 사이의 숫자여야합니다.")
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("getNumbers메서드는")
    class Describe_getNumbers {
        @Nested
        @DisplayName("생성된 로또 객체는")
        class Context_when_valid_lotto_object {
            private List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            private int bonusNumber = 7;
            @Test
            @DisplayName("항상 올바른 번호를 반환한다.")
            void It_always_returns_valid_numbers() {
                Lotto lotto1 = new Lotto(numbers);
                assertThat(lotto1.getNumbers()).isNotNull();

                Lotto lotto2 = new Lotto(numbers, bonusNumber);
                assertThat(lotto2.getNumbers()).isNotNull();
            }
        }
    }

    @Nested
    @DisplayName("getBonusNumber메서드는")
    class Describe_getBonusNumber {
        @Nested
        @DisplayName("보너스 번호가 포함된 로또 객체는")
        class Context_when_valid_lotto_object_include_bonus_number {
            private List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            private int bonusNumber = 7;
            @Test
            @DisplayName("항상 올바른 보너스 번호를 반환한다.")
            void It_always_returns_valid_bonus_number() {
                Lotto lotto = new Lotto(numbers, bonusNumber);
                assertThat(lotto.getNumbers()).isNotNull();
                assertThat(lotto.getBonusNumber()).isEqualTo(bonusNumber);
            }
        }
    }

    @Nested
    @DisplayName("보너스 번호가 포함되지 않은 로또 객체는")
    class Context_when_valid_lotto_object_not_include_bonus_number {
        private List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        @Test
        @DisplayName("항상 올바른 보너스 번호를 반환한다.")
        void It_always_returns_valid_bonus_number() {
            Lotto lotto = new Lotto(numbers);
            assertThatThrownBy(lotto::getBonusNumber)
                    .hasMessageContaining("[ERROR] 보너스 번호가 초기화 되지 않았습니다.")
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
