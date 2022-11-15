package lotto.domain;

import static lotto.domain.LottoMatch.calculatedLottoMapper;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoMatchTest {

    CalculatedLotto calculatedLotto;

    @BeforeEach
    void setUp(){
        calculatedLotto = new CalculatedLotto();
    }

    @Test
    void 매핑결과출력_FOUR_MATCHES() {
        for (int i = 0; i < 4; i++){
            calculatedLotto.increaseWinningLottoCount();
        }
        assertThat(calculatedLottoMapper(calculatedLotto)).isEqualTo(LottoMatch.FOUR_MATCHES);
    }

    @Test
    void 매핑결과출력_NULL_RESULT() {
        assertThat(calculatedLottoMapper(calculatedLotto)).isEqualTo(LottoMatch.NULL_RESULT);
    }

    @Test
    void 매핑결과출력_FIVE_MATCHES_PLUS_BONUS(){
        for (int i = 0; i < 5; i++){
            calculatedLotto.increaseWinningLottoCount();
        }
        calculatedLotto.switchToTrue();
        assertThat(calculatedLottoMapper(calculatedLotto)).isEqualTo(LottoMatch.FIVE_MATCHES_PLUS_BONUS);
    }
}