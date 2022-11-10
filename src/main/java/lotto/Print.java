package lotto;

import constant.LottoText;

public class Print {
    public void out(LottoText text) {
        System.out.println(text);
    }

    public <T> void out(LottoText text, T t) {
        System.out.printf(String.valueOf(text), t);
    }
}
