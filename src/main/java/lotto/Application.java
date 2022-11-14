package lotto;

import lotto.controller.ControlLotto;

public class Application { // 패키지 분리
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ControlLotto controlLotto = new ControlLotto();

        try {
            controlLotto.runLotto();
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
