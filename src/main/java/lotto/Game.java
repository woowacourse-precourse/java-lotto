package lotto;

import java.util.List;

public class Game {
    private Ui ui;
    private LottoTicket lottoTicket;

    public Game(Ui ui, LottoTicket lottoTicket) {
        this.ui = ui;
        this.lottoTicket = lottoTicket;
    }

    public void start() {
        List<Lotto> lottos = lottoTicket.buyLotto(ui.returnInputValue("구입금액을 입력해 주세요."));
        ui.printLottos(lottos);

        ui.returnInputValue("당첨 번호를 입력해 주세요.");
    }
}
