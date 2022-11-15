package lotto;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;

public class Calculator {
    private Integer ticketNumber;
    private HashMap<Integer, Integer> gradeStorage = new HashMap<>();
    private Integer totalEarning;

    public Calculator() {};

    public Calculator(Integer ticketNumber) {
        HashMap<Integer, Integer> gradeStorage = new HashMap<>();
        for (int i = 0; i < Win.values().length; i++) {
            gradeStorage.put(i, 0);
        }

        this.ticketNumber = ticketNumber;
        this.gradeStorage = gradeStorage;
        this.totalEarning = 0;
    }

    public void calculate(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Win win = getWin(lotto.matchWinNumbers(), lotto.matchBonusNumber());
            storeGrade(win);
            addEarning(win);
        }
    }

    public void storeGrade(Win win) {
        this.gradeStorage.put(win.grade, this.gradeStorage.get(win.grade) + 1);
    }

    public void addEarning(Win win) {
        this.totalEarning += win.earning;
    }

    public void printStatistic() {
        Double ratio = (double) (this.totalEarning * 100) / (ticketNumber * Constant.TICKET_PRICE);

        for (Win win : Win.values()) {
            if (win.grade.equals(0)) {
                continue;
            }
            if (win.grade.equals(2)) {
                System.out.println(win.match + "개 일치, 보너스 볼 일치 (" + NumberFormat.getInstance().format(win.earning) +
                        "원) - " + this.gradeStorage.get(win.grade) + "개");
                continue;
            }
            System.out.println(win.match + "개 일치 (" + NumberFormat.getInstance().format(win.earning) +
                    "원) - " + this.gradeStorage.get(win.grade) + "개");
        }

        System.out.println("총 수익률은 " + String.format("%.1f", ratio) + "%입니다.");
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
