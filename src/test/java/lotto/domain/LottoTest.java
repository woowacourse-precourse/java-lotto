package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
class LottoTest {

    @Test
    @DisplayName("로또번호가 양식에 맞게 출력된다")
    void test1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Nested
    @DisplayName("로또를 만들 때, 입력받은 숫자가")
    class LottoInputTest {
        @Test
        @DisplayName("정상")
        void test2() {
            Lotto lotto = new Lotto(List.of(3, 5, 6, 7, 34, 1));
        }

        @Test
        @DisplayName("여섯 개가 아니면 예외를 반환한다")
        void test3() {
            Assertions.assertThatThrownBy(() -> new Lotto(List.of(3, 6, 7, 34, 1)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("45보다 큰 숫자가 있으면 예외를 반환한다")
        void test4() {
            Assertions.assertThatThrownBy(() -> new Lotto(List.of(44, 3, 46, 7, 34, 1)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("1보다 작은 숫자가 있으면 예외를 반환한다")
        void test5() {
            Assertions.assertThatThrownBy(() -> new Lotto(List.of(44, 3, 0, 7, 34, 1)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @Test
        @DisplayName("중복값을 넣으면 예외를 반환한다")
        void test6() {
            Assertions.assertThatThrownBy(() -> new Lotto(List.of(44, 3, 46, 3, 34, 1)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}