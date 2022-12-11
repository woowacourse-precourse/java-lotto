package lotto.validator;

public class ValidateWinningNumber implements Validator {
    private final String WINNING_NUMBER_PATTERN = "^[0-9]+(,[0-9]+){5}$";

    @Override
    public void validate(String input) {

        if (!input.matches(WINNING_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 쉼표를 구분자로 숫자 6개를 입력해주세요.");
        }

        String[] inputArr = input.split(",");

        for (String s : inputArr) {
            if (Integer.parseInt(s) < 1 || Integer.parseInt(s) > 45) {
                throw new IllegalArgumentException("[ERROR] 1에서 45사이 숫자를 입력해주세요.");
            }
        }
    }
}
