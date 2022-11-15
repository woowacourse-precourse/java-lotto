package lotto;

import java.util.HashMap;
import java.util.List;

public class WinManager {
    private List<Lotto> lottoList;
    private List<Integer> winNumbers;
    private int bonusNumber;
    private HashMap<String, Integer> matches = new HashMap<>(5);
    private int amount;

    public WinManager(WinLotto winLotto, List<Lotto> lottoList) {
        this.winNumbers = winLotto.getNumbers();
        this.bonusNumber = winLotto.getBonusNumber();
        this.lottoList = lottoList;
        this.amount = lottoList.size();
        initializeMatches();

        findWinningStatistics();
        printAll();
    }

    public HashMap<String, Integer> get() {
        return matches;
    }

    private void initializeMatches() {
        matches.put("3", 0);
        matches.put("4", 0);
        matches.put("5", 0);
        matches.put("5+1", 0);
        matches.put("6", 0);
    }

    private void findWinningStatistics() {
        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumbers = lottoList.get(i).getNumbers();
            String matchNumber = findMatchNumberWith(lottoNumbers);
            if (isOutOfRange(matchNumber))
                continue;

            increaseMatches(matchNumber);
            if ((matchNumber.equals("5")) && isBonusMatch(lottoNumbers))
                increaseMatches("5+1");
        }
    }

    private String findMatchNumberWith(List<Integer> lottoNumbers) {
        int count = 0;
        for (int i = 0; i < winNumbers.size(); i++) {
            if (lottoNumbers.contains(winNumbers.get(i))) {
                count++;
            }
        }
        return String.valueOf(count);
    }

    private boolean isOutOfRange(String key) {
        if(!matches.keySet().contains(key))
            return true;
        return false;
    }

    private void increaseMatches(String key) {
        Integer value = matches.get(key);
        value++;
        matches.put(key, value);
    }

    private boolean isBonusMatch(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains((bonusNumber)))
            return true;
        return false;
    }

    private void printAll() {
        System.out.println(OutputMessage.STATISTICS.get());
        System.out.println("3개 일치 (5,000원) - " + matches.get("3") + "개");
        System.out.println("4개 일치 (50,000원) - " + matches.get("4") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matches.get("5") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matches.get("5+1") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matches.get("6") + "개");
    }


}
