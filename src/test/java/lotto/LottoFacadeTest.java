package lotto;

import lotto.application.LottoFacade;
import lotto.domain.Lotto;
import lotto.domain.LottoEnum;
import lotto.domain.LottoProcessorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

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

    @TestFactory
    @DisplayName("LottoFacade registerWinLotto Test")
    Stream<DynamicTest> lottoFacadeRegisterWinLottoTest() {
        lottoFacade = new LottoFacade();

        return Stream.of(
                DynamicTest.dynamicTest("input을 lotto로 반환한다.", () -> {
                    final String input = "1,2,3,4,5,6";
                    final List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);

                    Lotto result = lottoFacade.registerWinLotto(input);

                    assertThat(result.getNumbers()).isEqualTo(lotto);
                }),
                DynamicTest.dynamicTest("잘못된 입력의 경우 예외를 던져준다.", () -> {
                    final String input = "1,2,3,4,5,6,";

                    assertThatThrownBy(() -> lottoFacade.registerWinLotto(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("잘못된 입력값 입니다.");
                }),
                DynamicTest.dynamicTest("잘못된 입력의 경우 예외를 던져준다.", () -> {
                    final String input = "1,2,3,4,5";

                    assertThatThrownBy(() -> lottoFacade.registerWinLotto(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(LottoEnum.LOTTO.getSize() +"개의 숫자를 입력해야 합니다.");
                })

        );
    }
}
