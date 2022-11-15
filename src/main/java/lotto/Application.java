package lotto;

import lotto.util.LottoUtils;

import static lotto.util.LottoUtils.getLottoUtils;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoUtils lottoUtils = getLottoUtils();
            lottoUtils.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
