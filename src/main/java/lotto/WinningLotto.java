package lotto;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    public List<Integer> creteWinningNumbers() {
        InputView inputView = new InputView();
        String winningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumbers = new ArrayList<>();
        List<String> winningStringNumbers = List.of(winningNumber.split(","));
        for (int i = 0; i < winningStringNumbers.size(); i++) {
            int number = Integer.parseInt(winningStringNumbers.get(i));
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    public String compareLottoNumber() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> winningNumbers = creteWinningNumbers();
        List<List<Integer>> totalLotteries = lottoMachine.sortLottoNumbers();
        String rank = "";
        for (List<Integer> lotto : totalLotteries) {
            int sameNumberCount = isContainsNumber(lotto, winningNumbers);
            rank = rankStandard(sameNumberCount);
        }
        return rank;
    }

    public int isContainsNumber(List<Integer> lotto, List<Integer> winningNumbers) {
        int sameNumberCount = 0;
        for (int number : lotto) {
            if (winningNumbers.contains(number)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    public String rankStandard(int sameNumberCount) {
        String rank = "";
        if (sameNumberCount == 3) {
            rank = LottoRank.FIFTH_PLACE.getValue();
        }
        if (sameNumberCount == 4) {
            rank = LottoRank.FOURTH_PLACE.getValue();
        }
        if (sameNumberCount == 5) {
            rank = LottoRank.THIRD_PLACE.getValue();
        }
        if (sameNumberCount == 5) {
            rank = LottoRank.SECOND_PLACE.getValue();
        }
        if (sameNumberCount == 6) {
            rank = LottoRank.FIRST_PLACE.getValue();
        }
        return rank;
    }
}