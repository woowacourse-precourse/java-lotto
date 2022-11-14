package lotto.service;

import lotto.model.Lotto;
import lotto.model.Player;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.model.Lotto.*;

public class LottoService {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoService() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public Player createPlayer() {
        outputView.printInputPurchaseAmount();
        Player player = new Player(inputView.inputPurchaseAmount());
        return player;
    }

    public List<Lotto> createPlayerLottoList(int ticketNumber) {
        outputView.printTicketNumber(ticketNumber);
        List<Lotto> playerLottoList = createLottoList(ticketNumber);
        outputView.printLottoList(playerLottoList);
        return playerLottoList;
    }

    public List<Lotto> createLottoList(int num) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            List<Integer> lottoNumbers = pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_LENGTH);
            Lotto lotto = new Lotto(lottoNumbers);
            lottoList.add(lotto);
        }
        return lottoList;
    }
}
