package lotto;

import java.util.List;

public class Application {

    private static DrawLotto drawLotto;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        drawLotto = new DrawLotto();
        drawLotto.init();
    }
}
