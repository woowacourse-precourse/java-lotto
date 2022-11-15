package lotto;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;

public class Calculator {
    private Integer ticketNumber;
    private HashMap<Integer, Integer> gradeStorage = new HashMap();
    private Integer totalEarning;

    public Calculator() {};

    public Calculator(Integer ticketNumber, List<Lotto> lottos) {
        this.ticketNumber = ticketNumber;

        for (Lotto lotto : lottos) {
            storeGrade(lotto);
        }
    }

    public void storeGrade(Lotto lotto) {
        Win win = getWin(lotto.matchWinNumbers(), lotto.matchBonusNumber());

        this.gradeStorage.put(win.grade, this.gradeStorage.get(win.grade) + 1);
        addEarning(win);
    }

    public void addEarning(Win win) {
        this.totalEarning += win.earning;
    }

    public void printStatistic() {
        for (Win win : Win.values()) {
            System.out.println(win.match + "개 일치 (" + NumberFormat.getInstance().format(win.earning) +
                    "원) - " + numberForMatches + "개");
        }

        System.out.println("총 수익률은 " + null + "%입니다.");
    }

    public Win getWin(Integer match, Boolean bonus) {
        if (match.equals(6)) {
            return Win.FIRST_PLACE;
        }

        if (match.equals(5)) {
            if (bonus) {
                return Win.SECOND_PLACE;
            }
            return Win.THIRD_PLACE;
        }

        if (match.equals(4)) {
            return Win.FORTH_PLACE;
        }
        if (match.equals(3)) {
            return Win.FIFTH_PLACE;
        }
        return Win.LOSE;
    }
}
