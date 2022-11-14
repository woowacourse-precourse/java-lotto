package lotto;

import java.util.List;

public class LottoSystem {
    public static final int price = 1000;
    public static final List<WinInfo> winInfomations = List.of(
            new WinInfo(6,0,2000000000),
            new WinInfo(5,1,30000000),
            new WinInfo(5,0,1500000),
            new WinInfo(4,0,50000),
            new WinInfo(3,0,5000)
    );

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
