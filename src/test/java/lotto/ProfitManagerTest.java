package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoRank;
import lotto.domain.ProfitManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("ProfitManager 클래스")
@Nested
public class ProfitManagerTest {
    @DisplayName("sumEarning 메소드는")
    @Nested
    class Describe_sumEarning {
        @DisplayName("당첨 횟수와 상금을 입력받아")
        @Nested
        class Context_with_WinningCount_WinningPrice {
            @DisplayName("당첨 횟수와 상금을 곱하여 총 수익을 계산한다.")
            @Test
            void sumEarningTest() {
                assertSimpleTest(() -> {
                            LottoRank lottoRank = LottoRank.FIRST;
                            lottoRank.FIRST.findMatchingRank(6); // 1등 1회
                            ProfitManager profitManager = new ProfitManager();
                            assertThat(profitManager.calculateEarning(lottoRank))
                                    .isEqualTo(2000000000
                                    );
                        }
                );
            }
        }
    }

    @DisplayName("calculate 메소드는")
    @Nested
    class Describe_calculate {
        @DisplayName("로또 구입 금액을 입력받아")
        @Nested
        class Context_with_PurchaseAmount {
            @DisplayName("총 수익을 구입 금액으로 나누어 수익률을 반환한다.")
            @Test
            void calculateTest() {
                assertSimpleTest(() -> {
                            int purchaseAmount = 100000;
                            int totalEarning = 200000;
                            ProfitManager profitManager = new ProfitManager();
                            assertThat(profitManager.calculateProfit(purchaseAmount, totalEarning))
                                    .isEqualTo(2
                                    );
                        }
                );
            }
        }
    }
}
