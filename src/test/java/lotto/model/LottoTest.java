package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lotto Unit Test")
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
    @DisplayName("당첨 번호와 보너스 번호가 주어졌을 때, 뽑힌 로또 번호를 비교하여 순위를 매길 수 있다.")
    void testLotterRankWithWinningLottoAndBounsNumber() throws Exception {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 9, 10, 11));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bounsNumber = 7;

        //when
        LottoRank lottoRank1 = lotto1.getCorrectLottoCount(winningLotto, bounsNumber);
        LottoRank lottoRank2 = lotto2.getCorrectLottoCount(winningLotto, bounsNumber);
        LottoRank lottoRank3 = lotto3.getCorrectLottoCount(winningLotto, bounsNumber);
        LottoRank lottoRank4 = lotto4.getCorrectLottoCount(winningLotto, bounsNumber);
        LottoRank lottoRank5 = lotto5.getCorrectLottoCount(winningLotto, bounsNumber);

        //then
        assertThat(lottoRank1.name()).isEqualTo("FIRST");
        assertThat(lottoRank2.name()).isEqualTo("SECOND");
        assertThat(lottoRank3.name()).isEqualTo("THIRD");
        assertThat(lottoRank4.name()).isEqualTo("FOURTH");
        assertThat(lottoRank5.name()).isEqualTo("FIFTH");
    }
}
