package domain;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("로또 발행 및 당첨 결과 조회 통합 테스트")
    @Test
    void getLottoResultTest1() {
        String moneyInput = "10000";
        int numberOfLotto = lottoService.getNumberOfLotto(moneyInput);
        List<Lotto> lottos = lottoService.publishLotto(numberOfLotto);
        List<Integer> winningNumbers = List.of(1, 13, 16, 28, 29, 44);
        int bonusNumber = 37;

        Map<Prize, Integer> winningDetails =
                lottoService.getWinningDetails(winningNumbers, lottos, bonusNumber);

        List<Prize> collect = Arrays.stream(Prize.values())
                .filter(prize -> prize.ranking > 0)
                .sorted(Comparator.comparing(Prize::getRanking).reversed())
                .collect(Collectors.toList());

    }


    @DisplayName("구매 개수만큼 로또 반환 테스트")
    @Test
    void publishLottoTest() {
        List<Lotto> lottos = lottoService.publishLotto(10);

        for (Lotto lotto : lottos) {
            Assertions.assertThat(lotto.getUserLottoNumbers().size()).isEqualTo(6);
        }

        Assertions.assertThat(lottos.size()).isEqualTo(10);
    }

    @DisplayName("구매한 로또 개수 반환 테스트")
    @Test
    void getNumberOfLottoTest() {
        String moneyInput = "10000";
        int numberOfLotto = lottoService.getNumberOfLotto(moneyInput);

        Assertions.assertThat(numberOfLotto).isEqualTo(10);

    }
}
