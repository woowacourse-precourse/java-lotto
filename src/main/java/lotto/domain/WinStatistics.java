package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinStatistics {
    private static final int INIT = 0;
    private static final int CNT_NUMBER = 6;
    private static final int START_NUMBER = 3;
    private static final int RESTRICTION_NUMBER = 5;
    private static int bonusRank = 0;
    private static List<Integer> countRank = new ArrayList<>();
    private UserLotto userLotto = new UserLotto();
    private WinLotto winLotto = new WinLotto();
    private List<List> userLottoGroup;
    private List<Integer> winLottoNumbers;
    private int bonusNumber;
    private HashMap<Integer, Integer> winAmount = new HashMap<>() {{
        put(3, 5000);
        put(4, 50000);
        put(5, 1500000);
        put(6, 2000000000);
    }};

    public WinStatistics() {
    }

    public void initCountAccord() {
        for (int i = INIT; i <= CNT_NUMBER; i++) {
            countRank.add(0);
        }
    }

    public void startWinStatistics() {
        userLottoGroup = userLotto.getUserLotto();
        winLottoNumbers = winLotto.getWinningNumbers();
        bonusNumber = winLotto.getBonusNumber();
        initCountAccord();
        for (int i = INIT; i < userLottoGroup.size(); i++) {
            List<Integer> userNumbers = new ArrayList<>(userLottoGroup.get(i));
            checkLottoNumbersAccord(userNumbers, winLottoNumbers);
        }
    }

    public void checkLottoNumbersAccord(List<Integer> userNumbers, List<Integer> winLottoNumbers) {
        int count = INIT;
        for (int i = INIT; i < userNumbers.size(); i++) {
            if (userNumbers.contains(winLottoNumbers.get(i))) {
                count++;
            }
        }
        checkRank(count, userNumbers);
    }

    public void checkRank(int count, List<Integer> userNumbers) {
        if (count != RESTRICTION_NUMBER) {
            countRank.set(count, countRank.get(count) + 1);
            return;
        }
        checkBonus(userNumbers);
    }

    public void checkBonus(List<Integer> userNumbers) {
        if (userNumbers.contains(bonusNumber)) {
            bonusRank++;
            return;
        }
        countRank.set(RESTRICTION_NUMBER, countRank.get(RESTRICTION_NUMBER) + 1);
    }

    public List<Integer> getCountAccord() {
        return countRank;
    }

    public int getBonusAccord() {
        return bonusRank;
    }

    public int calculationTotalAmount() {
        int totalAmount = INIT;
        for (int i = START_NUMBER; i <= CNT_NUMBER; i++) {
            int count = countRank.get(i);
            int money = winAmount.get(i);
            totalAmount += count * money;
        }
        totalAmount += bonusRank * 30000000;
        return totalAmount;
    }
}
