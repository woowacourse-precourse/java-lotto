package lotto.mvc.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.CommonIOTestSettings;
import lotto.mvc.dto.input.InputBonusNumberDto;
import lotto.mvc.dto.input.InputPurchaseAmountDto;
import lotto.mvc.dto.input.InputWinningLottoDto;
import lotto.mvc.util.LottoGameStatus;
import lotto.mvc.util.exception.WrongGameStatusException;
import lotto.mvc.util.message.InputViewMessageUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest extends CommonIOTestSettings {

    @Nested
    @DisplayName("renderPurchaseAmount 메소드는")
    class RenderPurchaseAmountMethodTest {

        @ParameterizedTest
        @ValueSource(strings = {"10000", "15000", "8000", "1000"})
        @DisplayName("만약 PURCHASE_AMOUNT를 입력받으면 플레이어의 입력을 받아 InputPurchaseAmountDto를 반환한다.")
        void success_test(String input) {
            LottoGameStatus lottoGameStatus = LottoGameStatus.PURCHASE_AMOUNT;
            setTestInput(input);

            InputPurchaseAmountDto inputPurchaseAmountDto = InputView.renderPurchaseAmount(lottoGameStatus);

            assertThat(testOut.toString())
                    .contains(InputViewMessageUtils.findMessage(lottoGameStatus));
            assertThat(inputPurchaseAmountDto.getInputPurchaseAmount()).isEqualTo(input);
        }

        @ParameterizedTest
        @EnumSource(names = {"WINNING_NUMBERS", "BONUS_NUMBER", "APPLICATION_EXIT", "APPLICATION_EXCEPTION"})
        @DisplayName("만약 PURCHASE_AMOUNT 외의 다른 LottoGameStatus가 주어지면 WrongGameStatusException 예외가 발생한다.")
        void exception_test(LottoGameStatus lottoGameStatus) {
            assertThatThrownBy(() -> InputView.renderPurchaseAmount(lottoGameStatus))
                    .isInstanceOf(WrongGameStatusException.class);
        }
    }

    @Nested
    @DisplayName("renderWinningLotto 메소드는")
    class RenderWinningLottoMethodTest {

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6", "11,12,13,14,15,16", "21,22,23,24,25,26"})
        @DisplayName("만약 WINNING_NUMBERS를 입력받으면 플레이어 입력을 받아 InputWinningLottoDto를 반환한다.")
        void success_test(String input) {
            LottoGameStatus lottoGameStatus = LottoGameStatus.WINNING_NUMBERS;
            setTestInput(input);

            InputWinningLottoDto inputWinningLottoDto = InputView.renderWinningLotto(lottoGameStatus);

            assertThat(testOut.toString())
                    .contains(InputViewMessageUtils.findMessage(lottoGameStatus));
            assertThat(inputWinningLottoDto.getInputWinningLotto()).isEqualTo(input);
        }

        @ParameterizedTest
        @EnumSource(names = {"PURCHASE_AMOUNT", "BONUS_NUMBER", "APPLICATION_EXIT", "APPLICATION_EXCEPTION"})
        @DisplayName("만약 WINNING_NUMBERS 외의 다른 LottoGameStatus가 주어지면 WrongGameStatusException 예외가 발생한다.")
        void exception_test(LottoGameStatus lottoGameStatus) {
            assertThatThrownBy(() -> InputView.renderWinningLotto(lottoGameStatus))
                    .isInstanceOf(WrongGameStatusException.class);
        }
    }

    @Nested
    @DisplayName("renderBonusNumber 메소드는")
    class RenderBonusNumberMethodTest {

        @ParameterizedTest
        @ValueSource(strings = {"1", "45"})
        @DisplayName("만약 BONUS_NUMBER가 주어지면 사용자 입력을 받아 InputBonusNumberDto를 반환한다.")
        void success_test(String input) {
            LottoGameStatus lottoGameStatus = LottoGameStatus.BONUS_NUMBER;
            setTestInput(input);

            InputBonusNumberDto inputBonusNumberDto = InputView.renderBonusNumber(lottoGameStatus);

            assertThat(testOut.toString())
                    .contains(InputViewMessageUtils.findMessage(lottoGameStatus));
            assertThat(inputBonusNumberDto.getInputBonusNumber()).isEqualTo(input);
        }

        @ParameterizedTest
        @EnumSource(names = {"PURCHASE_AMOUNT", "WINNING_NUMBERS", "APPLICATION_EXIT", "APPLICATION_EXCEPTION"})
        @DisplayName("만약 BONUS_NUMBER 외의 다른 LottoGameStatus가 주어지면 WrongGameStatusException 예외가 발생한다.")
        void exception_test(LottoGameStatus lottoGameStatus) {
            assertThatThrownBy(() -> InputView.renderBonusNumber(lottoGameStatus))
                    .isInstanceOf(WrongGameStatusException.class);
        }
    }
}