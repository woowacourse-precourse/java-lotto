package lotto;

import lotto.controller.Lotto;
import lotto.controller.TestController;
import lotto.service.TestService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        TestService testService = new TestService();
        TestController testController = new TestController(testService);
        testController.foo();

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }
}
