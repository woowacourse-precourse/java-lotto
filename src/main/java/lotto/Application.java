package lotto;

import lotto.controller.Controller;
import lotto.domain.Money;
import lotto.domain.Numbers;
import lotto.service.Service;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            Controller controller = new Controller();
            controller.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
