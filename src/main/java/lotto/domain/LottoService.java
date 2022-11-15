package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.BuyingLottoList;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LottoService {

    public LottoResult checkLottoResult(BuyingLottoList buyingLottoList, WinningLotto winningLotto) {

        List<Lotto> buyingLottos = buyingLottoList.getLottoList();
        WinningRank winningRank;
        LottoResult lottoResult = new LottoResult();
        for (Lotto buyingLotto : buyingLottos) {
            winningRank = checkLottoNumbers(buyingLotto, winningLotto);
            lottoResult.refreshResult(winningRank);
        }
        float profit = calulatingProfit();
        lottoResult.setProfit(profit);

        return lottoResult;
    }

    public WinningRank checkLottoNumbers(Lotto buyingLotto, WinningLotto winningLotto) {

        Lotto winningLottoNumbers = winningLotto.getWinningLottoNumbers();
        int matchCount = 0;

        for (int winningLottoNumber : winningLottoNumbers.getNumbers()) {
            if (checkLottoNumber(buyingLotto, winningLottoNumber)) {
                matchCount++;
            }
        }

        boolean isBonusMatch = checkBonusNumber(buyingLotto, winningLotto.getBonusNumber());
        WinningRank winningRank = checkWinningRank(matchCount, isBonusMatch);

        return winningRank;
    }

    public WinningRank checkWinningRank(int matchCount, boolean isBonusMatch) {


    }

    public boolean checkBonusNumber(Lotto buyingLotto, int bonusNumber) {

        for (int buyingLottoNumber : buyingLotto.getNumbers()) {
            if (buyingLottoNumber == bonusNumber) {
                return true;
            }
        }

        return false;
    }
    public boolean checkLottoNumber(Lotto buyingLotto, int winningLottoNumber) {

        for (int buyingLottoNumber : buyingLotto.getNumbers()) {
            if (buyingLottoNumber == winningLottoNumber) {
                return true;
            }
        }

        return false;
    }

    public List<Lotto> generateLottoList(int numberOfLotto) {

        List<Lotto> lottoList = new LinkedList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = generateLotto();
            lottoList.add(lotto);
        }

        return lottoList;
    }

    public Lotto generateLotto() {

        List<Integer> lottoNumbers = generateLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);

        return lotto;
    }

    public List<Integer> generateLottoNumbers() {

        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedLottoNumbers = sortedLottoNumbers(lottoNumbers);

        return sortedLottoNumbers;
    }

    public List<Integer> sortedLottoNumbers(List<Integer> lottoNumbers) {

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
