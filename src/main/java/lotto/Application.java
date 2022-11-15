package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        MyModel model = new MyModel();
        MyView view = new MyView(model);
        LottoController controller = new LottoController(model, view);
        controller.run();
    }
}
