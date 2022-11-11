package lotto.domain.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("1등번호, 보너스 비교한 값을 조합하여 결과를 리턴한다. : 6개 일치")
    @Test
    void calculateLottoResultMatchSix() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        List<Integer> userLotto = List.of(8, 15, 18, 21, 36, 45);
        assertThat(lottoNumber.calculateMatch(userLotto)).isEqualTo(LottoRank.SIX_MATCHES);
    }

    @DisplayName("1등번호, 보너스 비교한 값을 조합하여 결과를 리턴한다. : 5개 + 보너스 번호 일치")
    @Test
    void calculateLottoResultMatchFiveBonus() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        List<Integer> userLotto = List.of(8, 13, 18, 21, 36, 45);
        assertThat(lottoNumber.calculateMatch(userLotto)).isEqualTo(LottoRank.FIVE_BONUS_MATCHES);
    }

    @DisplayName("1등번호, 보너스 비교한 값을 조합하여 결과를 리턴한다. : 5개 일치")
    @Test
    void calculateLottoResultMatchFive() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        List<Integer> userLotto = List.of(8, 14, 18, 21, 36, 45);
        assertThat(lottoNumber.calculateMatch(userLotto)).isEqualTo(LottoRank.FIVE_MATCHES);
    }

    @DisplayName("1등번호, 보너스 비교한 값을 조합하여 결과를 리턴한다. : 4개 일치")
    @Test
    void calculateLottoResultMatchFour() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        List<Integer> userLotto = List.of(8, 14, 19, 21, 36, 45);
        assertThat(lottoNumber.calculateMatch(userLotto)).isEqualTo(LottoRank.FOUR_MATCHES);
    }

    @DisplayName("1등번호, 보너스 비교한 값을 조합하여 결과를 리턴한다. : 3개 일치")
    @Test
    void calculateLottoResultMatchThree() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        List<Integer> userLotto = List.of(2, 14, 19, 21, 36, 45);
        assertThat(lottoNumber.calculateMatch(userLotto)).isEqualTo(LottoRank.THREE_MATCHES);
    }

    @DisplayName("1등번호, 보너스 비교한 값을 조합하여 결과를 리턴한다. : 3개 이하 일치")
    @Test
    void calculateLottoResultMatchUnderThree() {
        LottoNumber lottoNumber = new LottoNumber("8,18,21,45,15,36", "13");
        List<Integer> userLotto = List.of(2, 14, 19, 21, 36, 44);
        assertThat(lottoNumber.calculateMatch(userLotto)).isEqualTo(LottoRank.NO_MATCH);
    }
}