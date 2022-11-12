package lotto;

import lotto.user.LottoConsole;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoConsole.doLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
