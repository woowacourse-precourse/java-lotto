package lotto;

import java.util.List;

public class Application {

    MyModel model = new MyModel();
    MyView view = new MyView(model);
    LottoController controller = new LottoController(model, view);

    public static void main(String[] args) {
    }
}
