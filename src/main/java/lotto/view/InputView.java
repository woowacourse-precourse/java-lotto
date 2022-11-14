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
     * 사용자로부터 Long 타입의 숫자를 받아온다
     *
     * @return Long 타입의 숫자
     */
    public long inputLong() {
        final String input = inputHandler.readLine();
        return InputValidator.toLong(input);
    }

    /**
     * 사용자로부터 List<Integer>에 해당하는 숫자들을 받아온다
     *
     * @return List<Integer>에 해당하는 객체
     */
    public List<Integer> inputListIntegers() {
        final String input = inputHandler.readLine();
        return InputValidator.splitToIntegers(input);
    }

    /**
     * 사용자로부터 int 타입의 정수를 받아온다
     *
     * @return 사용자에게 받은 int 타입의 정수
     */
    public int inputInt() {
        final String input = inputHandler.readLine();
        return InputValidator.toInt(input);
    }
}
