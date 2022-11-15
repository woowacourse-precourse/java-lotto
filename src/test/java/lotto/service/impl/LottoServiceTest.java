package lotto.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.dto.LottoStatistic;
import lotto.service.LottoService;
import lotto.type.LottoInformation;
import lotto.type.LottoStandard;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoServiceImpl();

    @Test
    public void createLottosSuccess() {
        //given
        int size = 5;

        //when
        List<Lotto> lottos = lottoService.createLottos(size);

        //then
        Assertions.assertThat(lottos.size()).isEqualTo(size);
        for (Lotto lotto : lottos) {
            lottoInformAssert(lotto);
        }
    }

    private void lottoInformAssert(Lotto lotto) {
        Assertions.assertThat(lotto.getNumbers().size()).isEqualTo(LottoInformation.SIZE.value());
        for (Integer number : lotto.getNumbers()) {
            if (number < LottoInformation.START.value() || number > LottoInformation.END.value()) {
                org.junit.jupiter.api.Assertions.fail();
            }
        }
        for (int i = 0; i < LottoInformation.SIZE.value() - 1; i++) {
            if (lotto.getNumbers().get(i) > lotto.getNumbers().get(i + 1)) {
                org.junit.jupiter.api.Assertions.fail();
            }
        }
    }

    @Test
    public void createLottoFailure() {
        //given
        int size = 0;

        //when
        //then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
            () -> lottoService.createLottos(size)
        );
    }

    @Test
    public void makeStatistic() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = i; j <= i + 5; j++) {
                numbers.add(j);
            }
            lottos.add(new Lotto(numbers));
        }
        long purchaseAmount = 6000L;
        List<Integer> winningNumbers = List.of(2, 3, 4, 5, 6, 7);
        int bonusNumber = 8;

        //when
        LottoStatistic statistic = lottoService.makeStatistic(lottos, purchaseAmount, winningNumbers,
            bonusNumber);

        //then
        Map<LottoStandard, Integer> resultMap = statistic.getResultMap();
        BigDecimal yield = statistic.getYield();
        Assertions.assertThat(resultMap.get(LottoStandard.FIRST)).isEqualTo(1);
        Assertions.assertThat(resultMap.get(LottoStandard.SECOND)).isEqualTo(1);
        Assertions.assertThat(resultMap.get(LottoStandard.THIRD)).isEqualTo(1);
        Assertions.assertThat(resultMap.get(LottoStandard.FOURTH)).isEqualTo(1);
        Assertions.assertThat(resultMap.get(LottoStandard.FIFTH)).isEqualTo(1);
        Assertions.assertThat(resultMap.get(LottoStandard.NOTHING)).isEqualTo(1);

        long totalPrize = Arrays.stream(LottoStandard.values()).mapToLong(LottoStandard::getPrize).sum();

        Assertions.assertThat(yield).isEqualTo(
            BigDecimal.valueOf(totalPrize)
                .multiply(BigDecimal.valueOf(100L))
                .divide(BigDecimal.valueOf(purchaseAmount), 1, RoundingMode.HALF_UP)
        );
    }
}