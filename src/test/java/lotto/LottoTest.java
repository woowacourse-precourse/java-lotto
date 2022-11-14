package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // 당첨 번호 중복 확인
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("순위 체크 함수(Enum)")
    @Test
    void getLottoRankingEnum(){
        List<Integer> lotto = List.of(1,2,3,4,5,6);

        //1등 테스트
        assertThat(LottoRanking.caculateRanking(lotto, 7, List.of(1,2,3,4,5,6)))
                .isEqualTo(LottoRanking.FIRST);

        // 2등 테스트
        assertThat(LottoRanking.caculateRanking(lotto, 7, List.of(2,3,4,5,7,6)))
                .isEqualTo(LottoRanking.SECOND);

        // 3등 테스트
        assertThat(LottoRanking.caculateRanking(lotto, 7, List.of(2,3,4,5,6,8)))
                .isEqualTo(LottoRanking.THIRD);

        // 4등 테스트
        assertThat(LottoRanking.caculateRanking(lotto, 7, List.of(2,3,4,5,9,8)))
                .isEqualTo(LottoRanking.FORTH);

        // 5등 테스트
        assertThat(LottoRanking.caculateRanking(lotto, 7, List.of(2,3,4,10,8,9)))
                .isEqualTo(LottoRanking.FIFTH);
    }

    @DisplayName("순위 체크 함수(Lotto class)")
    @Test
    void getLottoRanking(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6),7);
        //1등 테스트
        assertThat(lotto.caculateRanking(List.of(1,2,3,4,5,6)))
                .isEqualTo(LottoRanking.FIRST);

        // 2등 테스트
        assertThat(lotto.caculateRanking(List.of(2,3,4,5,7,6)))
                .isEqualTo(LottoRanking.SECOND);

        // 3등 테스트
        assertThat(lotto.caculateRanking(List.of(2,3,4,5,6,8)))
                .isEqualTo(LottoRanking.THIRD);

        // 4등 테스트
        assertThat(lotto.caculateRanking(List.of(2,3,4,5,9,8)))
                .isEqualTo(LottoRanking.FORTH);

        // 5등 테스트
        assertThat(lotto.caculateRanking(List.of(2,3,4,10,8,9)))
                .isEqualTo(LottoRanking.FIFTH);
    }
}
