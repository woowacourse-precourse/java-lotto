package lotto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class Calculator {
    private final Lotto winningLotto;
    private final List<Lotto> lottoList;
    private final int bonusNumber;
    private final HashMap<Rank, Integer> history;

    public Calculator(Lotto winningLotto, List<Lotto> lottoList, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.lottoList = lottoList;
        this.bonusNumber = bonusNumber;
        this.history = createHistory();
    }

    public HashMap<Rank, Integer> getHistory() {
        return history;
    }

    public HashMap<Rank, Integer> createHistory() {
        HashMap<Rank, Integer> historyMap = initResultMap();
        for (Lotto purchaseLotto : lottoList) {
            int count = compareWinningLottoWithPurchaseLotto(winningLotto, purchaseLotto);
            if(count>=3){
                insertIntoHistory(count, purchaseLotto, historyMap);
            }
        }
        return historyMap;
    }

    private void insertIntoHistory(int count, Lotto purchaseLotto, HashMap<Rank, Integer> historyMap) {
        if (count == 3) {
            historyMap.put(Rank.FIFTH, historyMap.get(Rank.FIFTH) + 1);
        }
        if (count == 4) {
            historyMap.put(Rank.FOURTH, historyMap.get(Rank.FOURTH) + 1);
        }
        if (count == 5) {
            if (checkBonusNumber(purchaseLotto, bonusNumber)) {
                historyMap.put(Rank.SECOND, historyMap.get(Rank.SECOND) + 1);
                return;
            }
            historyMap.put(Rank.THIRD, historyMap.get(Rank.THIRD) + 1);
        }
        if (count == 6) {
            historyMap.put(Rank.FIRST, historyMap.get(Rank.FIRST) + 1);
        }
    }

    public HashMap<Rank, Integer> initResultMap() {
        HashMap<Rank, Integer> hashMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            hashMap.put(rank, 0);
        }
        return hashMap;
    }

    public int compareWinningLottoWithPurchaseLotto(Lotto winningLotto, Lotto purchaseLotto) {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        List<Integer> purchaseLottoNumbers = purchaseLotto.getNumbers();
        int count = 0;
        for (Integer number : purchaseLottoNumbers) {
            if (winningLottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBonusNumber(Lotto purchaseLotto, int bonusNumber) {
        List<Integer> purchaseLottoNumbers = purchaseLotto.getNumbers();
        return purchaseLottoNumbers.contains(bonusNumber);
    }

    public void printHistory() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            String price = decimalFormat.format(rank.getPrice());
            String printString = rank.getMessage() + "(" + price + "원) - " + history.get(rank) + "개";
            System.out.println(printString);
        }
    }
}
