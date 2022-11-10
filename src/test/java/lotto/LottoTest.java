package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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

    @Test
    @DisplayName("로또 생성 성공")
    void createLottoSuccess() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //when then
        assertThatNoException()
                .isThrownBy(() -> new Lotto(numbers));
    }

    @Test
    void 오름차순_된_문자열을_리턴한다() {
        //given
        Lotto lottoTicket = new Lotto(List.of(4, 2, 31, 35, 14, 23));
        String expect = "2, 4, 14, 23, 31, 35";

        //when
        String res = lottoTicket.toString();

        //then
        assertThat(res).isEqualTo(expect);
    }
}
