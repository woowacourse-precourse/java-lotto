package lotto.controller;

import lotto.view.IntroduceView;
import lotto.view.View;

import java.util.regex.Pattern;

public class LottoController {
    public void showIntroduce() {
        View view = new IntroduceView();
        view.Show();
    }

    public void showMoneyInput() {
        View view = new MoneyInputView();
        view.Show();

        String response = view.getResponse();
        validateInput("^(\\d+[0][0][0])$", response);

        //TODO - 로또 번호 생성 service 호출
    }

    public static void validateInput(String regex, String input) {
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException("안내에 따라 값을 입력해주세요.");
        }
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
