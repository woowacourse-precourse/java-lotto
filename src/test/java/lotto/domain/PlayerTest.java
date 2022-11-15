package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.exception.Exception.*;


import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사용자 입력 유효성 검사 테스트")
class PlayerTest extends NsTest {
    private final Player player = new Player();

    @DisplayName("입력한 금액만큼 로또가 생성되는지 확인한다.")
    @Test
    void generateLottoByPurchasedAmount() {
        player.purchaseCost = 5000;
        player.purchaseLotto();

        assertThat(player.getLottos()).hasSize(5);
    }

    @Nested
    @DisplayName("구입금액 유효성 검사 테스트")
    class PlayerPurchaseInputTest {
        @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
        @Test
        void purchaseByNonNumeric() {
            assertSimpleTest(() -> {
                runException("asd123");
                assertThat(output()).contains(NOT_NUMBER.getMessage());
            });
        }

        @DisplayName("구입 금액이 정수가 아니면 예외가 발생한다.")
        @Test
        void purchaseByNonInteger() {
            assertSimpleTest(() -> {
                runException("2000.5");
                assertThat(output()).contains(NOT_NUMBER.getMessage());
            });
        }

        @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
        @Test
        void purchaseWithChange() {
            assertSimpleTest(() -> {
                runException("1234");
                assertThat(output()).contains(WRONG_PURCHASE_COST.getMessage());
            });
        }

        @DisplayName("구입 금액이 1000 이하일 경우 예외가 발생한다.")
        @Test
        void purchaseWithInsufficient() {
            assertSimpleTest(() -> {
                runException("500");
                assertThat(output()).contains(WRONG_PURCHASE_COST.getMessage());
            });
        }
    }

    @Nested
    @DisplayName("당첨 번호 입력 유효성 검사 테스트")
    class WinningNumberInputTest {
        @DisplayName("당첨 번호가 쉼표로 구분되어있지 않을 때 예외가 발생한다.")
        @Test
        void inputWinningNumberWithNoComma() {
            assertSimpleTest(() -> {
                runException("3000", "1,2,3,4,5#6");
                assertThat(output()).contains(WRONG_DELIMITER.getMessage());
            });
        }

        @DisplayName("당첨 번호 중 숫자가 아닌 값이 있으면 예외가 발생한다.")
        @Test
        void inputWinningNumberWithNonNumeric() {
            assertSimpleTest(() -> {
                runException("3000", "1,2,e,3,45,kk");
                assertThat(output()).contains(NOT_NUMBER.getMessage());
            });
        }
    }

    @Nested
    @DisplayName("보너스 번호 입력 유효성 검사 테스트")
    class BonusNumberInputTest {
        @DisplayName("보너스 번호가 숫자가 아닐 때 예외가 발생한다.")
        @Test
        void inputBonusNumberWithNonNumeric() {
            assertSimpleTest(() -> {
                runException("3000", "1,2,3,4,5,6", "woowacourse");
                assertThat(output()).contains(NOT_NUMBER.getMessage());
            });
        }

        @DisplayName("보너스 번호가 범위를 벗어날 때 예외가 발생한다.")
        @Test
        void inputBonusNumberOutOfRange() {
            assertSimpleTest(() -> {
                runException("3000", "1,2,3,4,5,6", "58");
                assertThat(output()).contains(OUT_OF_RANGE.getMessage());
            });
        }

        @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외가 발생한다.")
        @Test
        void inputBonusNumberDuplicated() {
            assertSimpleTest(() -> {
                runException("3000", "1,11,13,24,35,41", "35");
                assertThat(output()).contains(BONUS_DUPLICATE.getMessage());
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
