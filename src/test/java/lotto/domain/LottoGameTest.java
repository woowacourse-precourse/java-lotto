package lotto.domain;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static lotto.domain.Rank.FIRST;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    LottoGame lottogame = new LottoGame();

    @Test
    void 입력값이_숫자가_아닐때_테스트() {
        List<String> rawMainNumber = Arrays.asList("a,b,c,d,e,f");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> lottogame.convertToNumber(rawMainNumber))
                        .isInstanceOf(NumberFormatException.class)
        );
    }

    @Test
    void 보너스번호가_메인번호에포함될때_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertSimpleTest(() ->
                assertThatThrownBy(() -> lottogame.compareMainWithBonus(winningNumbers, bonusNumber))
                                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 결과값_출력_테스트() {
        Map<Rank, Integer> result = new HashMap<>();
        result.put(FIRST,1);
        Rank rank = FIRST;

        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String reward = decimalFormat.format(2000000000);

        assertEquals(lottogame.gameResult(result, rank),"6개 일치 (" + reward + "원) - " + 1 + "개");
    }

}