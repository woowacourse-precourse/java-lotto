package lotto;

import domain.Lotto;
import domain.LottoCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Nested
    class LottoCount {
        //given
        domain.LottoCount lottoCount = new domain.LottoCount();
        @DisplayName("입력받은 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
        @Test
        void isNotMultipleOf_1000() {
            //when
            int price = 6430;
            // then
            assertThatThrownBy(() -> lottoCount.returnNumber(price))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @DisplayName("입력받은 금액이 1000원으로 나누어지면 로또 개수가 출력된다.")
        @Test
        void isMultipleOf_1000() {
            //when
            int price = 6000;
            // then
            lottoCount.returnNumber(price);
            assertThat(lottoCount.getNumber()).isEqualTo(6);
        }
    }
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}
