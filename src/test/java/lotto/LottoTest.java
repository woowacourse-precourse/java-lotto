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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 당첨 번호가 존재합니다.");
    }

    @DisplayName("1~45 외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(-11, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
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
    @DisplayName("오름차순 된 문자열을 리턴한다.")
    void returnSortedNumbers() {
        //given
        Lotto lottoTicket = new Lotto(List.of(4, 2, 31, 35, 14, 23));
        String expect = "2, 4, 14, 23, 31, 35";

        //when
        String res = lottoTicket.getSortedNumbers();

        //then
        assertThat(res).isEqualTo(expect);
    }
}
