package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Test
    void 로또_당첨_테스트() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45)),
                new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)),
                new Lotto(Arrays.asList(1, 2, 42, 43, 44, 45)),
                new Lotto(Arrays.asList(1, 41, 42, 43, 44, 45)),
                new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45))

        );
        List<LottoResult> results = Arrays.asList(
                LottoResult.FIRST_PRIZE,
                LottoResult.SECOND_PRIZE,
                LottoResult.THIRD_PRIZE,
                LottoResult.FOURTH_PRIZE,
                LottoResult.FIFTH_PRIZE,
                LottoResult.NO_PRIZE,
                LottoResult.NO_PRIZE,
                LottoResult.NO_PRIZE
        );
        List<Integer> normalNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        for(int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            assertThat(lotto.getResult(normalNumbers, bonusNumber)).isEqualTo(results.get(i));
        }
    }

}
