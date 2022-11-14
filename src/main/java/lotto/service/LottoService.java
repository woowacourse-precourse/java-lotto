package lotto.service;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.model.Lotto.*;

public class LottoService {
    private final InputView inputView;
    private final OutputView outputView;
    public static int status = 0;
    public final static int ERROR_STATUS = -1;
    public final static int NORMAL_STATUS = 0;

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

    public Lotto createWinLotto() {
        outputView.printInputWinningNumber();
        WinningNumber winningNumber = new WinningNumber(inputView.inputWinningNumber());
        return new Lotto(winningNumber.getWinningNumber());
    }

    public BonusNumber createBonusNumber(List<Integer> winningNumber) {
        if(status != NORMAL_STATUS){
            return null;
        }
        outputView.printInputBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber(), winningNumber);
        return bonusNumber;
    }

    public List<LottoRank> getLottoRanks(List<Lotto> playerLottoList, Lotto winLotto, BonusNumber bonusNumber) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (Lotto myLotto : playerLottoList) {
            lottoRanks.add(judge(myLotto, winLotto, bonusNumber.getBonusNumber()));
        }
        return lottoRanks;
    }

    public LottoRank judge(Lotto myLotto, Lotto winLotto, int bonusNumber) {
        boolean bonus = false;
        int count = 0;
        List<Integer> lottoList = winLotto.getNumbers();
        for (int j = 0; j < lottoList.size(); j++) {
            if (lottoList.contains(myLotto.getNumbers().get(j))) {
                count++;
            }
            if (lottoList.contains(bonusNumber)) {
                bonus = true;
            }
        }
        return judge(count, bonus);
    }

    public LottoRank judge(int count, boolean bonus) {
        if (count == THREE) {
            return LottoRank.FIFTH;
        } else if (count == FOUR) {
            return LottoRank.FOURTH;
        } else if (count == FIVE && !bonus) {
            return LottoRank.THIRD;
        } else if (count == FIVE && bonus) {
            return LottoRank.SECOND;
        } else if (count == SIX) {
            return LottoRank.FIRST;
        }
        return LottoRank.LOSE;
    }

    public void printResult(List<LottoRank> lottoRanks) {
        LottoResult result = new LottoResult(lottoRanks);
        outputView.printResult(result);
        Profit profit = new Profit(result.getRewardAmount(), result.getPurchaseAmount());
        outputView.printProfit(profit);
    }

}
