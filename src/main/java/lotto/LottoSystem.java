package lotto;

import java.util.List;

public class LottoSystem {
    public final int price = 1000;
    public final List<WinInfo> winInformations = List.of(
            new WinInfo(6, 0, 2000000000, 1),
            new WinInfo(5, 1, 30000000, 2),
            new WinInfo(5, 0, 1500000, 3),
            new WinInfo(4, 0, 50000, 4),
            new WinInfo(3, 0, 5000, 5)
    );

    public final WinInfo noWin = new WinInfo(-1, -1, 0, -1);


    private List<Integer> winNumbers;
    private int bonusNumbers;

    public LottoSystem() {
    }

    public void setWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public void setBonusNumbers(int bonusNumbers) {
        this.bonusNumbers = bonusNumbers;
    }




    private int getMatchedCnt(List<Integer> target) {
        int result = 0;
        for (int i = 0; i < target.size(); i++) {
            if (target.get(i) == this.winNumbers.get(i)) {
                result++;
            }
        }
        return result;
    }

    private int getBonusMatchedCnt(List<Integer> target) {
        int result = 0;
        for (int i = 0; i < target.size(); i++) {
            if (target.get(i) == this.bonusNumbers) {
                result++;
                break;
            }
        }
        return result;
    }
}
