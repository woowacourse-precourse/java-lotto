package lotto.validator;

public class ValidBonusNumber implements Validator{

    @Override
    public void validate(String input) {
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45) {
            throw new IllegalArgumentException("[ERROR] 1에서 45사이 숫자를 입력해주세요.");
        }
    }
}
