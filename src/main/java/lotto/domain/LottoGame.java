package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public int purchaseAmount;
    public List<Integer> winningNumber;
    public int bonusNumber;
    public List<Lotto> issuedLotto;
    public List<Integer> gameResult;
    public Input input;
    public Output output;

    public void play() {
        this.input = new Input();
        this.output = new Output();
        this.purchaseAmount = input.getPurchaseAmount();
        issueLotto();
        output.printIssuedLotto(issuedLotto);
        this.winningNumber = input.getWinningNumber();
        this.bonusNumber = input.getBonusNumber();
        getGameResult();
        output.printGameResult(this.gameResult);
        // TODO: 수익률 계산 및 출력
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public List<Lotto> issueLotto() {
        this.issuedLotto = new ArrayList<Lotto>(purchaseAmount);
        for (int i=0; i<purchaseAmount; i++) {
            List<Integer> newLottoNumbers = generateLottoNumbers();
            Lotto newLotto = new Lotto(newLottoNumbers);
            issuedLotto.add(newLotto);
        }
        return issuedLotto;
    }

    public void getGameResult() {
        this.gameResult = new ArrayList<Integer>(6); // Rank : 1~5
        for (int i=0; i<6; i++) {
            gameResult.add(0);
        }
        for (int order=0; order< issuedLotto.size(); order++) {
            Lotto lotto = issuedLotto.get(order);
            Rank rank = lotto.calculateRank(winningNumber, bonusNumber);
            // System.out.println(rank.getTitle());

            if (rank != Rank.NO_PLACE) {
                int place = rank.getPlace();
                gameResult.set(place, gameResult.get(place)+1);
            }
        }
    }
}