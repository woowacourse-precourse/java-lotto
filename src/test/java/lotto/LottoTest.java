package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
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
    @DisplayName("입력 숫자가 1000으로 딱 나누어지는 숫자일 때, 몫 구하기")
    @Test
    void numberOfLottoAvailableCountTest() {
        assertThat(LottoUtil.numberOfLottoAvailableCount(5000)).isEqualTo(5);
        assertThat(LottoUtil.numberOfLottoAvailableCount(13000)).isEqualTo(13);
        assertThat(LottoUtil.numberOfLottoAvailableCount(7000)).isEqualTo(7);
    }

    @DisplayName("로또 번호는 오름차순이여야 한다.")
    @Test
    void createLottoAsc() {

        List<Lotto> lottos = LottoUtil.getLottos(1);

        Lotto lotto = lottos.get(0);

        for(int i = 1 ; i < lotto.getNumbers().size(); i++){
            assertThat(lotto.getNumbers().get(i) > lotto.getNumbers().get(i-1)).isTrue();
        }
    }

    @DisplayName("로또 번호 맞은 개수 출력 (보너스 제외)")
    @Test
    void createWinCount() {

        int cnt = LottoUtil.checkWin(new Lotto(List.of(1,3,5,7,9,11)), List.of(1,2,3,4,5,6));

        assertThat(cnt).isEqualTo(3);
    }
}
