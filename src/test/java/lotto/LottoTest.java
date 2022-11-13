package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랭킹 1 당첨 통계 계산 테스트")
    @Test
    void 랭킹_1_당첨_통계_계산_테스트() {
        LottoWinNumber answer = new LottoWinNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto ex = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertEquals(LottoResult.RANK_ONE,
            LottoMarker.produceWinningStatistic(answer, ex)
        );
    }

    @DisplayName("랭킹 2 당첨 통계 계산 테스트")
    @Test
    void 랭킹_2_당첨_통계_계산_테스트() {
        LottoWinNumber answer = new LottoWinNumber(List.of(1, 2, 3, 4, 5, 6), 8);
        Lotto ex = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Assertions.assertEquals(LottoResult.RANK_TWO,
            LottoMarker.produceWinningStatistic(answer, ex));
    }

    @DisplayName("랭킹 3 당첨 통계 계산 테스트")
    @Test
    void 랭킹_3_당첨_통계_계산_테스트() {
        LottoWinNumber answer = new LottoWinNumber(List.of(1, 2, 3, 4, 5, 6), 9);
        Lotto ex = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Assertions.assertEquals(LottoResult.RANK_THREE,
            LottoMarker.produceWinningStatistic(answer, ex));
    }

    @DisplayName("랭킹 4 당첨 통계 계산 테스트")
    @Test
    void 랭킹_4_당첨_통계_계산_테스트() {
        LottoWinNumber answer = new LottoWinNumber(List.of(1, 2, 3, 4, 5, 6),10);
        Lotto ex = new Lotto(List.of(1, 2, 3, 4, 9, 8));
        Assertions.assertEquals(LottoResult.RANK_FOUR,
            LottoMarker.produceWinningStatistic(answer,ex));
    }

    @DisplayName("랭킹 5 당첨 통계 계산 테스트")
    @Test
    void 랭킹_5_당첨_통계_계산_테스트() {
        LottoWinNumber answer = new LottoWinNumber(List.of(1, 2, 3, 4, 5, 6),11);
        Lotto ex = new Lotto(List.of(1, 2, 3, 10, 9, 8));
        Assertions.assertEquals(LottoResult.RANK_FIVE,
            LottoMarker.produceWinningStatistic(answer,ex));
    }


    @DisplayName("로또 번호가 1~45 범위 안에 없으면 예외가 발생한다.")
    @Test
    void createLottoNotInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
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
