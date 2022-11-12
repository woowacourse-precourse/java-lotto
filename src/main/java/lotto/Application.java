package lotto;

import lotto.user.LottoConsole;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoConsole lottoConsole = new LottoConsole();
        try {
            lottoConsole.doLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
