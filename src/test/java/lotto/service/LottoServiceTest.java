package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LuckyNumber;
import lotto.domain.Prize;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    @Test
    void 매치숫자_개수() {
        List<Integer> userNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> luckyNumber = Arrays.asList(1, 5, 10, 11, 12, 13);

        int expect = LottoService.matchN(userNumber, luckyNumber);
        assertThat(2).isEqualTo(expect);
    }

    @Test
    void 보너스개수() {
        List<Integer> userNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        int bonusNumber2 = 40;

        int expect = LottoService.matchBonusN(userNumber, bonusNumber);
        int expect2 = LottoService.matchBonusN(userNumber, bonusNumber2);

        assertThat(1).isEqualTo(expect);
        assertThat(0).isEqualTo(expect2);
    }

    @Test
    void 사용자_로또_모두_비교() {
        List<Lotto> userNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userNumber.add(new Lotto(Arrays.asList(i + 1, i + 2, i + 3, i + 4, i + 5, i + 6)));
        }


        LuckyNumber luckyNumber = new LuckyNumber();
        luckyNumber.inputBonusNumber("7");
        luckyNumber.inputLuckyNumber("4,6,1,15,19,39");

        HashMap<Prize, Integer> expect = LottoService.lottoNumberComparison(userNumber, luckyNumber);

        assertThat(2).isEqualTo(expect.get(Prize.LOSING_TICKET));
        assertThat(1).isEqualTo(expect.get(Prize.FIFTH_PLACE));
    }

    @Test
    void 토탈수익_계산() {
        List<Lotto> userNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userNumber.add(new Lotto(Arrays.asList(i + 1, i + 2, i + 3, i + 4, i + 5, i + 6)));
        }
        LuckyNumber luckyNumber = new LuckyNumber();
        luckyNumber.inputBonusNumber("7");
        luckyNumber.inputLuckyNumber("4,6,1,15,19,39");
        LinkedHashMap<Prize, Integer> history = LottoService.lottoNumberComparison(userNumber, luckyNumber);

        assertThat(5000.0f).isEqualTo(LottoService.totalCalculation(history));
    }

    @Test
    void 수익률_계산() {
        List<Lotto> userNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userNumber.add(new Lotto(Arrays.asList(i + 1, i + 2, i + 3, i + 4, i + 5, i + 6)));
        }
        LuckyNumber luckyNumber = new LuckyNumber();
        luckyNumber.inputBonusNumber("7");
        luckyNumber.inputLuckyNumber("4,6,1,15,19,39");
        HashMap<Prize, Integer> history = LottoService.lottoNumberComparison(userNumber, luckyNumber);


        assertThat("62.5").isEqualTo(LottoService.yieldCalculation(history, 8000));

    }
}