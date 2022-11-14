package lotto.validation;

import java.util.regex.Pattern;

public class PredictionNumbersInputValidation {
    public void validateInputFormat(String inputPredictionNumbers) {
        Pattern pattern = Pattern.compile("^[0-9],[0-9],[0-9],[0-9],[0-9],[0-9]$");

        if (! pattern.matcher(inputPredictionNumbers).matches()) {
            throw new IllegalArgumentException("[ERROR] 쉼표를 기준으로 구분된 숫자만을 입력해 주세요.");
        }
    }
}
