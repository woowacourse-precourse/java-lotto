package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoProcessor;
import lotto.domain.LottoProcessorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProcessorTest {

    private LottoProcessor lottoProcessor;

    @TestFactory
    @DisplayName("LottoProcessor MatchLottoNumber Test")
    Stream<DynamicTest> lottoProcessorMatchLottoNumberTest() {
        lottoProcessor = new LottoProcessorImpl();
        final Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        return Stream.of(
                DynamicTest.dynamicTest("모두 일치하는 경우", () -> {
                    final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

                    int result = lottoProcessor.matchLottoNumber(winLotto, lotto);

                    assertThat(result).isEqualTo(6);
                }),
                DynamicTest.dynamicTest("하나도 일치하지 않는 경우", () -> {
                    final Lotto lotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));

                    int result = lottoProcessor.matchLottoNumber(winLotto, lotto);

                    assertThat(result).isEqualTo(0);
                }),
                DynamicTest.dynamicTest("1개 일치하지 않는 경우", () -> {
                    final Lotto lotto = new Lotto(List.of(11, 12, 13, 4, 15, 16));

                    int result = lottoProcessor.matchLottoNumber(winLotto, lotto);

                    assertThat(result).isEqualTo(1);
                }),
                DynamicTest.dynamicTest("3개 일치하지 않는 경우", () -> {
                    final Lotto lotto = new Lotto(List.of(11, 2, 3, 4, 15, 16));

                    int result = lottoProcessor.matchLottoNumber(winLotto, lotto);

                    assertThat(result).isEqualTo(3);
                })
        );
    }

    @TestFactory
    @DisplayName("LottoProcessor MatchBonusNumber Test")
    Stream<DynamicTest> lottoProcessorMatchBonusNumberTest() {
        lottoProcessor = new LottoProcessorImpl();
        final int bonusNumber = 2;

        return Stream.of(
                DynamicTest.dynamicTest("일치하는 경우", () -> {
                    final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                    Boolean result = lottoProcessor.matchBonusNumber(bonusNumber, lotto);

                    assertThat(result).isEqualTo(true);
                }),
                DynamicTest.dynamicTest("일치하지 않는 경우", () -> {
                    final Lotto lotto = new Lotto(List.of(1, 3, 4, 5, 6, 7));
                    Boolean result = lottoProcessor.matchBonusNumber(bonusNumber, lotto);

                    assertThat(result).isEqualTo(false);
                })
        );
    }
}
