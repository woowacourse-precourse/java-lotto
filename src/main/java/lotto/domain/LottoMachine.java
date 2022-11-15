package lotto.domain;

import lotto.setting.Setting;
import lotto.util.Input;

import java.util.List;

public class LottoMachine {

    private Money money;
    private LottoStore lottoStore;
    private WinningNumber winningNumber;
    private int[] lottoResult;

//  돈 입력 기능
    public void inputMoney() throws IllegalArgumentException {
        money = new Money(Input.input());
    }

//  구매 개수 반환 기능
    public int getLottoCount() {
        return (int)(money.getMoney() / Setting.PURCHASE_AMOUNT_UNIT);
    }

//  금액 만큼 로또 구매하기
    public void buyLottos(int lottoCount) {
        this.lottoStore = new LottoStore(lottoCount);
    }

    // 구매한 로또 반환 기능
    public List<List<Integer>> getBuyLottos() {
        return lottoStore.getLottos();
    }

    // 당첨 번호 생성 기능
    public void inputWinningNumber() throws IllegalArgumentException {
        this.winningNumber = new WinningNumber();
        winningNumber.inputWinningNumber(Input.input());
    }

    // 보너스 번호 생성 기능
    public void inputBonusNumber() throws IllegalArgumentException {
        winningNumber.inputBonusNumber(Input.input());
    }

    // 당첨 결과 반환 기능
    public int[] getLottoResult() {
        List<List<Integer>> lottos = lottoStore.getLottos();
        List<Integer> winningNumbers = winningNumber.getWinningNumber();
        int bonusNumber = winningNumber.getBonusNumber();
        this.lottoResult = createLottoResult(lottos, winningNumbers, bonusNumber);
        return lottoResult;
    }

    // 당첨 결과 생성 기능
    private int[] createLottoResult(List<List<Integer>> lottos, List<Integer> winningNumber, int bonusNumber) {
        int[] lottoMatchs = new int[WinStatus.values().length];
        for (List lotto : lottos) {
            WinStatus winStatus = getMatchCount(lotto, winningNumber, bonusNumber);
            lottoMatchs[winStatus.getIndex()] += 1;
        }
        return lottoMatchs;
    }

    // 로또 하나 당 당첨 결과 집계
    private WinStatus getMatchCount(List<Integer> lotto, List<Integer> winningNumber, int bonusNumber) {
        int matchCount = 0;
        for (int number : lotto) {
            if (winningNumber.contains(number)) {
                matchCount += 1;
            }
        }
        if (matchCount == 5 && lotto.contains(bonusNumber)) {
            return WinStatus.FIVE_BONUS_MATCH;
        }
        return WinStatus.getWinStatus(matchCount);
    }


//  당첨 수익률 반환 기능
    public double getYield() {
        long totalPrizeMoney = 0;
        for (int index = 0; index < lottoResult.length; index++) {
            totalPrizeMoney += lottoResult[index] * WinStatus.getPrizeMoney(index);
        }
        return (double)totalPrizeMoney / (double)money.getMoney() * 100;
    }
}
