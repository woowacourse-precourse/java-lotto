package lotto;

import java.util.List;

public class LottoSystem {
    public static final int price = 1000;
    public static final List<WinInfo> winInformations = List.of(
            new WinInfo(6, 0, 2000000000, 1),
            new WinInfo(5, 1, 30000000, 2),
            new WinInfo(5, 0, 1500000, 3),
            new WinInfo(4, 0, 50000, 4),
            new WinInfo(3, 0, 5000, 5)
    );

    public static final WinInfo noWin = new WinInfo(-1,-1,0,-1);


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


}
