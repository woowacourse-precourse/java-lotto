package lotto;

import java.util.List;
import lotto.controller.LottoGameController;
import lotto.domain.Lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGameController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
