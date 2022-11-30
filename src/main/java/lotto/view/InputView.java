package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import lotto.dto.input.ReadBonusNumberDto;
import lotto.dto.input.ReadPlayerPurchaseAmountDto;
import lotto.dto.input.ReadWinningLottoDto;
import lotto.utils.message.ExceptionMessageUtil;

public class InputView {

    private static final String NUMBER_INPUT_SEPARATOR = ",";

    private static final int MIN_INPUT_NUMBER_LENGTH = 11;
    private static final int MAX_INPUT_NUMBER_LENGTH = 17;

    private InputView() {
    }

    private static class InputViewSingletonHelper {
        private static final InputView INPUT_VIEW = new InputView();
    }

    public static InputView getInstance() {
        return InputViewSingletonHelper.INPUT_VIEW;
    }

    public ReadPlayerPurchaseAmountDto readPlayerPurchaseAmount() {
        print(InputViewMessage.PURCHASE_AMOUNT.message);
        String playerPurchaseAmount = processPlayerInput();

        try {
            return new ReadPlayerPurchaseAmountDto(new BigDecimal(playerPurchaseAmount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessageUtil.WRONG_NUMBER_FORMAT.findFullMessage(), e);
        }
    }

    public ReadWinningLottoDto readWinningLotto() {
        print(InputViewMessage.WINNING_LOTTO.message);
        String winningNumbers = processPlayerInput();

        validateWinningNumbers(winningNumbers);
        return new ReadWinningLottoDto(winningNumbers);
    }

    public ReadBonusNumberDto readBonusNumber() {
        print(InputViewMessage.BONUS_NUMBER.message);
        String bonusNumber = processPlayerInput();

        try {
            return new ReadBonusNumberDto(Integer.parseInt(bonusNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessageUtil.WRONG_NUMBER_FORMAT.findFullMessage(), e);
        }
    }

    private void validateWinningNumbers(String winningNumbers) {
        validateWinningNumbersLength(winningNumbers);
        validateWinningNumbersSeparator(winningNumbers);
    }

    private void validateWinningNumbersSeparator(String winningNumbers) {
        if (!winningNumbers.contains(NUMBER_INPUT_SEPARATOR)) {
            throw new IllegalArgumentException(ExceptionMessageUtil.WRONG_SEPARATOR.findFullMessage());
        }
    }

    private void validateWinningNumbersLength(String winningNumbers) {
        int inputLength = winningNumbers.length();

        if (!isValidNumberLength(inputLength)) {
            throw new IllegalArgumentException(ExceptionMessageUtil.WRONG_NUMBER_LENGTH.findFullMessage());
        }
    }

    private boolean isValidNumberLength(int inputLength) {
        return MIN_INPUT_NUMBER_LENGTH <= inputLength && inputLength <= MAX_INPUT_NUMBER_LENGTH;
    }

    private String processPlayerInput() {
        return Console.readLine();
    }

    private void print(String message) {
        System.out.println(message);
    }

    private enum InputViewMessage {
        PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
        WINNING_LOTTO("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        InputViewMessage(String message) {
            this.message = message;
        }
    }
}
