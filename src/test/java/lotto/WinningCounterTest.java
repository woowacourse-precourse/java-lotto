package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.WinningCounter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("WinningCounter 클래스")
@Nested
public class WinningCounterTest {
    @DisplayName("countNormalWinning 메소드는")
    @Nested
    class Describe_countNormalWinning {
        @DisplayName("구매 로또 일반 번호와 당첨 번호를 입력받아")
        @Nested
        class Context_with_Normal_Winning {
            @DisplayName("구매 로또 일반 번호가 당첨 번호에서 일치하는 개수를 반환한다.")
            @Test
            void countNormalWinningTest() {
                assertSimpleTest(() -> {
                            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 5, 7, 6);
                            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
                            WinningCounter winningCounter = new WinningCounter();
                            assertThat(winningCounter.countWinningNormal(lottoNumbers, winningNumbers))
                                    .isEqualTo(5
                                    );
                        }
                );
            }
        }
    }

    @DisplayName("countBonusWinning 메소드는")
    @Nested
    class Describe_countBonusWinning {
        @DisplayName("구매 로또 보너스 번호와 당첨 번호를 입력받아")
        @Nested
        class Context_with_Bonus_Winning {
            @DisplayName("구매 로또 보너스 번호가 당첨 번호에서 일치하는 개수를 반환한다.")
            @Test
            void countBonusWinningTest() {
                assertSimpleTest(() -> {
                            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 5, 7, 6);
                            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
                            WinningCounter winningCounter = new WinningCounter();
                            assertThat(winningCounter.countWinningBonus(lottoNumbers, winningNumbers))
                                    .isEqualTo(1
                                    );
                        }
                );
            }
        }
    }
}
