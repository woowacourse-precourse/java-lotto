package lotto;

import constant.LottoText;

import java.util.List;

public class Print {
    public void out(LottoText text) {
        System.out.println(text);
    }

    public <T> void out(LottoText text, T t) {
        System.out.printf(String.valueOf(text), t);
    }

    public void out(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
