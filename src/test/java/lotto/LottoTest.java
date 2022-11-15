package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    //당첨 개수 구하기 테스트
    @DisplayName("당첨된 로또 번호 개수가 예상개수와 일치하지 않으면 예외가 발생한다.")
    @Test
    void checkCountWinningNumbers() {
        List<Integer> winningNums = List.of(1,23,11,19,36,13);

        Lotto lotto = new Lotto(List.of(6,13,19,23,33,39));

        int result = lotto.countMatchedNumbers(winningNums);
        assertThat(result).isEqualTo(3);
    }

    //당첨 번호 개수가 5개 일때, 보너스 점수 일치 여부 테스트


    //등수 구하는 메서드 테스트
}
