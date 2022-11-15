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

        List<Lotto> buyingLottoNumbers = buyingLottoList.getLottoList();
        WinningRank winningRank;
        LottoResult lottoResult = new LottoResult();
        for (Lotto buyingLotto : buyingLottoNumbers) {
            winningRank = checkLottoNumbers(buyingLotto, winningLotto);
            lottoResult.refreshResult(winningRank);
        }
        double profit = calculateProfit(lottoResult, buyingLottoList.getNumberOfLotto());
        lottoResult.setProfit(profit);

        return lottoResult;
    }

    public double calculateProfit(LottoResult lottoResult, int numberOfLotto) {

        double gain = 0;
        double buyMoney = numberOfLotto * 1000;

        gain += lottoResult.getFifthCount() * WinningRank.FIFTH.getPrice();
        gain += lottoResult.getFourthCount() * WinningRank.FOURTH.getPrice();
        gain += lottoResult.getThirdCount() * WinningRank.THIRD.getPrice();
        gain += lottoResult.getSecondCount() * WinningRank.SECOND.getPrice();
        gain += lottoResult.getFirstCount() * WinningRank.FIRST.getPrice();

        double profitPercentage = gain / buyMoney * 100;

        return Math.round(profitPercentage * 10) / 10.0;
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

        if (matchCount == 6) {
            return WinningRank.FIRST;
        } else if (matchCount == 5 && isBonusMatch) {
            return WinningRank.SECOND;
        } else if (matchCount == 5) {
            return WinningRank.THIRD;
        } else if (matchCount == 4) {
            return WinningRank.FOURTH;
        } else if (matchCount == 3) {
            return WinningRank.FIFTH;
        }

        return WinningRank.NOTHING;
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
        List<Integer> copyLottoNumbers = cloneList(lottoNumbers);

        List<Integer> sortedLottoNumbers = sortedLottoNumbers(copyLottoNumbers);

        return sortedLottoNumbers;

    }

    public List<Integer> cloneList(List<Integer> lottoNumbers) {

        List<Integer> clone = new LinkedList<>();
        for (int lottoNumber : lottoNumbers) {
            clone.add(lottoNumber);
        }

        return clone;
    }

    public List<Integer> sortedLottoNumbers(List<Integer> lottoNumbers) {

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
