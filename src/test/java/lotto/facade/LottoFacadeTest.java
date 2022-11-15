package lotto.facade;

import lotto.application.LottoFacade;
import lotto.application.LottoFacadeImpl;
import lotto.domain.Lotto;
import lotto.domain.enummodel.RankEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoFacadeTest {

    private LottoFacade lottoFacade;

    @TestFactory
    @DisplayName("LottoFacade buyLotto Test")
    Stream<DynamicTest> lottoFacadeBuyLottoTest() {
        lottoFacade = new LottoFacadeImpl();

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
        lottoFacade = new LottoFacadeImpl();

        return Stream.of(
                DynamicTest.dynamicTest("input을 lotto로 반환한다.", () -> {
                    final String input = "1,2,3,4,5,6";
                    final List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);

                    Lotto result = lottoFacade.registerWinLotto(input);

                    assertThat(result.getNumbers()).isEqualTo(lotto);
                }),
                DynamicTest.dynamicTest("잘못된 입력의 경우 예외를 던져준다.", () -> {
                    final String input = "1,2,3,4,e,5";

                    assertThatThrownBy(() -> lottoFacade.registerWinLotto(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("잘못된 입력값 입니다.");
                }),
                DynamicTest.dynamicTest("잘못된 입력 길이의 경우 예외를 던져준다.", () -> {
                    final String input = "1,2,3,4,5";

                    assertThatThrownBy(() -> lottoFacade.registerWinLotto(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력 길이가 다릅니다.");
                })
        );
    }

    @TestFactory
    @DisplayName("LottoFacade getMargin Test")
    Stream<DynamicTest> getMarginTest() {
        lottoFacade = new LottoFacadeImpl();

        return Stream.of(
                DynamicTest.dynamicTest("투자 8000원, 수익 5000원인 경우", () -> {
                    final Integer money = 8000;
                    final Integer after = 5000;
                    String result = lottoFacade.getMargin(money, after);

                    assertThat(result).isEqualTo("62.5");
                })
        );
    }

    @TestFactory
    @DisplayName("LottoFacade checkWinning Test")
    Stream<DynamicTest> checkWinningTest() {
        lottoFacade = new LottoFacadeImpl();

        return Stream.of(
                DynamicTest.dynamicTest("각 로또의 당첨점수를 구한다. Case 1등 2등 3등", () -> {
                    final Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                    final List<Lotto> clientLotto = new ArrayList<>(
                            List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                    new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                    new Lotto(List.of(1, 2, 3, 4, 5 ,8)))
                    );
                    final int bonus = 7;

                    List<Integer> result = lottoFacade.checkWinning(winLotto, clientLotto, bonus);

                    assertThat(result).contains(RankEnum.FIRST.getMatchNumber(),RankEnum.SECOND.getMatchNumber(),RankEnum.THIRD.getMatchNumber());
                    assertThat(result.size()).isEqualTo(3);
                }),
                DynamicTest.dynamicTest("각 로또의 당첨점수를 구한다. Case 2등 2등 5등", () -> {
                    final Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                    final List<Lotto> clientLotto = new ArrayList<>(
                            List.of(new Lotto(List.of(1, 2, 3, 4, 6, 7)),
                                    new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                    new Lotto(List.of(4, 5, 6, 7, 8 ,9)))
                    );
                    final int bonus = 7;

                    List<Integer> result = lottoFacade.checkWinning(winLotto, clientLotto, bonus);

                    assertThat(result).contains(RankEnum.SECOND.getMatchNumber(),RankEnum.FIFTH.getMatchNumber());
                    assertThat(result.size()).isEqualTo(3);
                })
        );
    }

    @TestFactory
    @DisplayName("LottoFacade calculateMoney Test")
    Stream<DynamicTest> calculateMoneyTest() {
        lottoFacade = new LottoFacadeImpl();

        return Stream.of(
                DynamicTest.dynamicTest("총 당첨금액을 구하는 테스트 Case 2등 3등 5등 5등", () -> {
                    final List<Integer> winningCount = List.of(5,6,3,3);
                    Integer result = lottoFacade.calculateMoney(winningCount);

                    assertThat(result)
                            .isEqualTo(RankEnum.SECOND.getWinnings()
                                    +RankEnum.THIRD.getWinnings()
                                    +RankEnum.FIFTH.getWinnings()
                                    +RankEnum.FIFTH.getWinnings());
                }),
                DynamicTest.dynamicTest("총 당첨금액을 구하는 테스트 Case 1등 4등 4등", () -> {
                    final List<Integer> winningCount = List.of(7,4,4,2,1);
                    Integer result = lottoFacade.calculateMoney(winningCount);

                    assertThat(result)
                            .isEqualTo(RankEnum.FIRST.getWinnings()
                                    +RankEnum.FOURTH.getWinnings()
                                    +RankEnum.FOURTH.getWinnings());
                })
        );
    }
}
