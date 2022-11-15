package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoProperties;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class LottoFunctionTest {
    Lotto lotto;
    Lotto awardLotto;
    LottoResult lottoResult;
    @BeforeEach
    void beforeEach(){
        lotto = new Lotto(List.of(1,2,3,4,5,8));
        awardLotto = new Lotto(List.of(1,2,3,4,7,8));
        lottoResult = new LottoResult();
    }
    @DisplayName("Lotto 기능 테스트 isUnique")
    @Test
    void isUniqueTest(){
        assertThatThrownBy(() -> lotto.isUnique(List.of(1,2,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("LottoResult 기능 테스트 lotteryCheck")
    @Test
    void lotteryCheckTest(){
        assertEquals(LottoProperties.LOTTO_SECONDWINNER,lottoResult.lotteryCheck(lotto,awardLotto,8));
    }

}
