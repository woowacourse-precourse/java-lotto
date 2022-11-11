package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호에 1보자 작은 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutBoundNumberUnderZero() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위에 벗어나는 숫자가 있으면 예외가 발생한다. : 1보다 큰 수")
    @Test
    void createLottoByOutBoundNumberUpperFortyFive() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 오름차순으로 정렬되지 않으면 예외가 발생한다.")
    @Test
    void createLottoByNotSortedByAsc(){
        assertThatThrownBy(() -> new Lotto(List.of(9, 1, 8, 3, 5, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 6개 일치")
    @Test
    void compareLottoToLottoNumber_ResultSix() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(8, 15, 18, 21, 36, 45));
        assertThat(lotto.compareLottoNumber(lottoNumber)).isEqualTo(LottoRank.SIX_MATCHES);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 5개 + 보너스 일치")
    @Test
    void compareLottoToLottoNumber_ResultFiveBonus() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(8, 13, 18, 21, 36, 45));
        assertThat(lotto.compareLottoNumber(lottoNumber)).isEqualTo(LottoRank.FIVE_BONUS_MATCHES);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 5개 일치")
    @Test
    void compareLottoToLottoNumber_ResultFive() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(8, 14, 18, 21, 36, 45));
        assertThat(lotto.compareLottoNumber(lottoNumber)).isEqualTo(LottoRank.FIVE_MATCHES);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 4개 일치")
    @Test
    void compareLottoToLottoNumber_ResultFour() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(7, 14, 18, 21, 36, 45));
        assertThat(lotto.compareLottoNumber(lottoNumber)).isEqualTo(LottoRank.FOUR_MATCHES);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 3개 일치")
    @Test
    void compareLottoToLottoNumber_ResultThree() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(7, 14, 18, 22, 36, 45));
        assertThat(lotto.compareLottoNumber(lottoNumber)).isEqualTo(LottoRank.THREE_MATCHES);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 3개 이하 일치")
    @Test
    void compareLottoToLottoNumber_ResultUnderTree() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(7, 14, 18, 22, 33, 45));
        assertThat(lotto.compareLottoNumber(lottoNumber)).isEqualTo(LottoRank.NONE);
    }

}
