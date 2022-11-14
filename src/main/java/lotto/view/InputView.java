package lotto.view;

import handler.InputHandler;

import java.util.List;

/**
 * 사용자의 입력을 inputHandler 로 부터 받는 것을 담당하는 View 클래스
 */
public final class InputView {
    private static final String NULL_MESSAGE = "InputHandler 가 null 입니다";

    private final InputHandler inputHandler;

    /**
     * 생성시에 null 이 들어오면 IEA 예외
     *
     * @param inputHandler 구체적인 입력을 담당하는 구현체
     */
    public InputView(InputHandler inputHandler) {
        validateInputHandler(inputHandler);
        this.inputHandler = inputHandler;
    }

    private void validateInputHandler(InputHandler inputHandler) {
        if (inputHandler == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    /**
     * 사용자로부터 돈을 받아온다
     *
     * @return 돈이 될 수 있는 정수값
     */
    public long inputAmount() {
        final String input = inputHandler.readLine();
        return InputValidator.toLong(input);
    }

    /**
     * 사용자로부터 로또 번호들을 받아온다
     *
     * @return 숫자들을
     */
    public List<Integer> inputLotteryNumber() {
        final String input = inputHandler.readLine();
        return InputValidator.splitToIntegers(input);
    }

    /**
     * 사용자로부터 보너스 넘버를 받아온다
     *
     * @return 보너스 넘버가 될 수 있는 숫자
     */
    public int inputBonusNumber() {
        final String input = inputHandler.readLine();
        return InputValidator.toInt(input);
    }
}
