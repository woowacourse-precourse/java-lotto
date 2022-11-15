package lotto.view;

public class InputView {

    private static final String ERR_INPUT_NOT_INTEGER = "[ERROR] 숫자를 입력 해야 합니다.";

    public int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERR_INPUT_NOT_INTEGER);
        }
    }
    
}
