package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DefaultView implements View {

    private final LottoController controller;

    public DefaultView(LottoController controller) {
        this.controller = controller;
    }

    public void render() {

        System.out.println(Views.REQUEST_MONEY.render());
        request(controller::inputMoney);

        renderLottos();

        System.out.println(Views.REQUEST_WINNING_NUMBER.render());
        request(controller::inputWinningNumber);

        System.out.println(Views.REQUEST_BONUS_NUMBER.render());
        request(controller::inputBonusNumber);

        renderStatics();
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

    private String request(Supplier<String> supplier) {
        return supplier.get();
    }

    private void renderLottos() {
        String lottosSize = request(controller::outputLottoSize);
        System.out.println(Views.LOTTOS_COUNT.render(lottosSize));

        String lottos = request(controller::outputLottos);
        System.out.println(lottos);
    }

    private void renderStatics() {
        System.out.println(Views.STATICS.render());
        System.out.println(Views.DIVIDER.render());
        request(controller::outputStatics);
    }

}
