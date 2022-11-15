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

    @DisplayName("일치하는 개수가 3개이다")
    @Test
    void createLottoAndCalcResultIs3() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        MatchDto matchDto = lotto.calcMatches(List.of(1, 2, 3, 7, 8, 9), 42);
        //then
        assertThat(matchDto.getMatchCount()).isEqualTo(3);
        assertThat(matchDto.isBonusState()).isEqualTo(false);
    }

    @DisplayName("일치하는 개수가 4개이다")
    @Test
    void createLottoAndCalcResultIs4() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        MatchDto matchDto = lotto.calcMatches(List.of(1, 2, 3, 4, 8, 9), 42);
        //then
        assertThat(matchDto.getMatchCount()).isEqualTo(4);
        assertThat(matchDto.isBonusState()).isEqualTo(false);
    }

    @DisplayName("일치하는 개수가 5개이다")
    @Test
    void createLottoAndCalcResultIs5() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        MatchDto matchDto = lotto.calcMatches(List.of(1, 2, 3, 4, 5, 9), 42);
        //then
        assertThat(matchDto.getMatchCount()).isEqualTo(5);
        assertThat(matchDto.isBonusState()).isEqualTo(false);
    }

    @DisplayName("일치하는 개수가 5개이고 BonusState가 true이다")
    @Test
    void createLottoAndCalcResultIs5AndBonusStateTrue() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 42));
        //when
        MatchDto matchDto = lotto.calcMatches(List.of(1, 2, 3, 4, 5, 9), 42);
        //then
        assertThat(matchDto.getMatchCount()).isEqualTo(5);
        assertThat(matchDto.isBonusState()).isEqualTo(true);
    }
    // 아래에 추가 테스트 작성 가능
}
