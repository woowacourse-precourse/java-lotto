package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;

import java.util.function.Consumer;

public class DefaultView implements View {

    private final LottoController controller;

    public DefaultView(LottoController controller) {
        this.controller = controller;
    }

    public void render() {

        System.out.println(Views.REQUEST_MONEY.render());

        request(controller::inputMoney);

    }

    private void request(Consumer<String> consumer) {
        String input = Console.readLine();
        try {
            consumer.accept(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }

    }
    
}
