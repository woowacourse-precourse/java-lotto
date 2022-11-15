package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Lottery {
    static ArrayList<Lotto> lottery = new ArrayList<>();
    static HashMap<String, Integer> gradeCount = new HashMap<>() {{
        put("FIFTH", 0);
        put("FOURTH", 0);
        put("THIRD", 0);
        put("SECOND", 0);
        put("FIRST", 0);
    }};

    public Lottery(int purchaseNumber) {
        for (int index = 0; index < purchaseNumber; index++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottery.add(lotto);
        }
    }

    public ArrayList<Lotto> getLottery() {
        return lottery;
    }

    public int calcWinningCount(User user, Lotto lotto) {
        List<Integer> winningNumbers = user.getWinningNumbers();
        int matchWinningCount = 0;

        for (int winningNumberIndex = 0; winningNumberIndex < 6; winningNumberIndex++) {
            if (lotto.getNumbers().contains(winningNumbers.get(winningNumberIndex))) {
                matchWinningCount++;
            }
        }

        return matchWinningCount;
    }

    public boolean isBonus(User user, Lotto lotto) {
        List<Integer> winningNumbers = user.getWinningNumbers();
        int bonusNumber = user.getBonusNumber();
        boolean isBonus = false;

        if (lotto.getNumbers().contains(bonusNumber)) {
            isBonus = true;
        }

        return isBonus;
    }

    public void calcGrade(User user) {
        int winningCount = 0;
        boolean isBonus = false;

        for (Lotto lotto : lottery) {
            winningCount = calcWinningCount(user, lotto);
            isBonus = isBonus(user, lotto);
            addGrade(winningCount, isBonus);
        }
    }

    public void addGrade(int winningCount, boolean isBonus) {
        if (winningCount == 6) {
            gradeCount.put("FIRST", 1);
        }
        if (winningCount == 5 && isBonus) {
            gradeCount.put("SECOND", 1);
        }
        if (winningCount == 5 && !isBonus) {
            gradeCount.put("THIRD", 1);
        }
        if (winningCount == 4) {
            gradeCount.put("FOURTH", 1);
        }
        if (winningCount == 3) {
            gradeCount.put("FIFTH", 1);
        }
    }

    public HashMap<String, Integer> getGradeCount() {
        return gradeCount;
    }

    public int getWinningPrice() {
        int winningPrice = 0;

        for (Grade grade : Grade.values()) {
            winningPrice += gradeCount.get(grade.toString()) * grade.getPrice();
        }

        return winningPrice;
    }
}
