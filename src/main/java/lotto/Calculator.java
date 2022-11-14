package lotto;

import java.util.HashMap;
import java.util.List;

public class Calculator {
    private Lotto winningLotto;
    private List<Lotto> lottoList;
    private int bonusNumber;
    private HashMap<String, Integer> history;

    public Calculator(Lotto winningLotto, List<Lotto> lottoList, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.lottoList = lottoList;
        this.bonusNumber = bonusNumber;
        this.history = createHistory();
    }

    public HashMap<String, Integer> getHistory(){
        return history;
    }

    public HashMap<String, Integer> createHistory() {
        HashMap<String, Integer> historyMap = initResultMap();
        for (Lotto purchaseLotto : lottoList) {
            int count = compareWinningLottoWithPurchaseLotto(winningLotto, purchaseLotto);
            if (count == 5 && checkBonusNumber(purchaseLotto, bonusNumber)) {
                historyMap.put("5+", historyMap.get("5+") + 1);
                continue;
            }
            if (count >= 3) {
                String key = Integer.toString(count);
                historyMap.put(key, historyMap.get(key) + 1);
            }
        }
        return historyMap;
    }

    public HashMap<String, Integer> initResultMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("3", 0);
        hashMap.put("4", 0);
        hashMap.put("5", 0);
        hashMap.put("5+", 0);
        hashMap.put("6", 0);
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
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + history.get("3") + "개");
        System.out.println("4개 일치 (50,000원) - " + history.get("4") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + history.get("5") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + history.get("5+") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + history.get("6") + "개");
    }
}
