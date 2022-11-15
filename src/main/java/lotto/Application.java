package lotto;

import lotto.controller.Controller;
import lotto.domain.Money;
import lotto.domain.Numbers;
import lotto.service.Service;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        controller.play();
    }
}
