package lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BonusIOHandler extends IOHandler{
    public int getBonus(){
        String input = validateInput(getUserInput());
        return Integer.parseInt(input);
    }

    @Override
    public String validateInput(String input) {
        Pattern pass = Pattern.compile("^[4][0-6]|[1-3][0-9]|[1-9]$");
        Matcher matcher = pass.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 또한 1~45 사이로 입력해주세요");
        }
        return input;
    }
}
