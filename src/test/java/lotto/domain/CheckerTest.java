package lotto.domain;

import lotto.config.LottoStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import static lotto.config.LottoStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

class CheckerTest {

    Checker checker = new Checker();

    @BeforeEach
    void 당첨_번호_입력() {

        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
        String numbers = "1,2,3,4,5,6";

        InputStream inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);

        checker.insertWinningNumbers();

        assertThat(checker.getWinningNumbers()).isEqualTo(result);

    }

    @BeforeEach
    void 보너스_번호_입력() {

        int result = 7;
        String numbers = "7";

        InputStream inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);

        checker.insertBonusNumber();

        assertThat(checker.getBonusNumber()).isEqualTo(result);

    }

    @Test
    void 모든_당첨_순위_확인() {

        List<List<Integer>> numbers = List.of(
                List.of(1, 2, 3, 8, 9, 10),  // 3
                List.of(1, 2, 3, 4, 9, 10),  // 4
                List.of(1, 2, 3, 4, 5, 10),  // 5
                List.of(1, 2, 3, 4, 5, 7),   // 5, 1
                List.of(1, 2, 3, 4, 5, 6)    // 6
        );

        HashMap<LottoStatus, Integer> result = new HashMap<>() {{
            put(THREE, 1);
            put(FOUR, 1);
            put(FIVE, 1);
            put(SIX_WITH_BONUS, 1);
            put(SIX, 1);
        }};

        for (int i = 0; i < numbers.size(); i++) {
            checker.checkMyLotto(numbers.get(i));
        }

        assertThat(checker.getWinningStats()).isEqualTo(result);

    }

    @Test
    void 수익률_확인() {

        double result = 62.5;

        List<List<Integer>> numbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );

        for (int i = 0; i < numbers.size(); i++) {
            checker.checkMyLotto(numbers.get(i));
        }


        checker.calculateRateOfReturn(8000);
        assertThat(result).isEqualTo(checker.getReturnRate());

    }

}