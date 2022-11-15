package lotto;

import lotto.domain.LottoService;
import lotto.ui.Ui;

public class Application {
    public static void main(String[] args) {
        Ui ui = new Ui();
        LottoService service = new LottoService();
        Game game = new Game(ui, service);

        try {
            game.start();
        } catch (IllegalArgumentException exception) {
            System.out.printf("[ERROR] %s\n", exception.getMessage());
        }
    }
}
