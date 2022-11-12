package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Lotto lotto = new Lotto(controller.lottoNumber());
    }
}
