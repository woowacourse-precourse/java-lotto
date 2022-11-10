package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final List<Integer> rightNumbers = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> sizeOverNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
    private static final List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5);


    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.numberOf(sizeOverNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> Lotto.numberOf(duplicatedNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 입력이 들어오면, 정상적으로 객체를 생성한다.")
    @Test
    void 로또_생성_성공() {
        // given
        List<Integer> numbers = rightNumbers;
        // when
        Lotto lotto = Lotto.numberOf(numbers);
        // then
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    // 아래에 추가 테스트 작성 가능
}
