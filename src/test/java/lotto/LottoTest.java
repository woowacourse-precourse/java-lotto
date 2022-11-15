package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPrinter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("중복되지 않은 번호 6개를 만든다.")
    @Test
    void 중복되지_않은_번호_6개를_생성_확인() {
        List<Integer> numbers = LottoPrinter.makeUniqueNumbers();
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        assertThat(numbers.size() == 6);
        assertThat(numbers.size() == uniqueNumbers.size());
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("1 ~ 45 범위의 번호만을 생성한다.")
    @Test
    void 알맞은_범위의_번호_생성_확인() {
        List<Integer> numbers = LottoPrinter.makeUniqueNumbers();

        for (Integer number : numbers) {
            assertThat(number > 0 && number < 46);
        }
    }
}
