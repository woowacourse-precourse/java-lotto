package lotto;

import java.util.List;

public class Game {
    private Ui ui;
    private User user;

    public Game(Ui ui, User user) {
        this.ui = ui;
        this.user = user;
    }

    public void start() {
        List<Lotto> lottos = user.buyLotto(ui.returnInputValue("구입금액을 입력해 주세요."));
        ui.printLottos(lottos);
    }
}
