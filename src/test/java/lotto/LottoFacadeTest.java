package lotto;

import lotto.application.LottoFacade;
import lotto.domain.Lotto;
import lotto.domain.LottoProcessorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoFacadeTest {

    private LottoFacade lottoFacade;

    @TestFactory
    @DisplayName("LottoFacade buyLotto Test")
    Stream<DynamicTest> lottoFacadeBuyLottoTest() {
        lottoFacade = new LottoFacade();

        return Stream.of(
                DynamicTest.dynamicTest("5000원 금액의 경우 5장을 구매한다.", () -> {
                    final Integer money = 5000;

                    List<Lotto> result = lottoFacade.buyLotto(money);

                    assertThat(result.size()).isEqualTo(5);
                }),
                DynamicTest.dynamicTest("1000원 금액의 경우 1장을 구매한다.", () -> {
                    final Integer money = 1000;

                    List<Lotto> result = lottoFacade.buyLotto(money);

                    assertThat(result.size()).isEqualTo(1);
                }),
                DynamicTest.dynamicTest("3500원 금액의 경우 예외를 던져준다.", () -> {
                    final Integer money = 3500;

                    assertThatThrownBy(() -> lottoFacade.buyLotto(money))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("금액 단위를 일치시켜야 합니다.");
                })
        );
    }
}
