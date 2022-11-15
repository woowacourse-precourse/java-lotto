package lotto;

import java.util.HashMap;

public class LottoJudge {

    private static HashMap<LotteryWin, Integer> winCount;
    private int winMoney;

    static {
        winCount = new HashMap<>();
        winCount.put(LotteryWin.NOTHING,0);
        winCount.put(LotteryWin.FIFTH_GRADE,0);
        winCount.put(LotteryWin.FOURTH_GRADE,0);
        winCount.put(LotteryWin.THIRD_GRADE,0);
        winCount.put(LotteryWin.SECOND_GRADE,0);
        winCount.put(LotteryWin.FIRST_GRADE,0);

    }
    public LottoJudge() {
        winMoney = 0;
    }

    public int judgeWin(Lotto lotto, WinNumber winNumber) {
        int winNumberCount = 0;
        int winBonusNumber = 0;
        LotteryWin winResult;

        for(int i = 0; i < 6; i++) {
            if (winNumber.getLotteryWinNumber().contains(lotto.getLottoNumber().get(i))) {
                winNumberCount++;
                continue;
            }

            if (lotto.getLottoNumber().get(i).equals(winNumber.getLotteryBonusNumber())) {
                winBonusNumber++;
            }
        }
        winResult = judgeWinCount(winNumberCount, winBonusNumber);
        winCount.put(winResult, winCount.get(winResult) + 1 );
        winMoney = winMoney + winResult.getLotteryWinMoney();
        return winMoney;
    }

    public LotteryWin judgeWinCount(int winNumberCount, int winBonusNumber) {
        if (winNumberCount == 3 && winBonusNumber == 0) {
            return LotteryWin.FIFTH_GRADE;
        }
        if (winNumberCount == 4 && winBonusNumber == 0) {
            return LotteryWin.FOURTH_GRADE;
        }
        if (winNumberCount == 5 && winBonusNumber == 0) {
            return LotteryWin.THIRD_GRADE;
        }
        if (winNumberCount == 5 && winBonusNumber == 1) {
            return LotteryWin.SECOND_GRADE;
        }
        if (winNumberCount == 6 && winBonusNumber == 0) {
            return LotteryWin.FIRST_GRADE;
        }
        return LotteryWin.NOTHING;
    }

    public void lottoJudgeResult() {
        System.out.println("3개 일치 (5,000원) - "+ winCount.get(LotteryWin.FIFTH_GRADE) + "개");
        System.out.println("4개 일치 (50,000원) - "+ winCount.get(LotteryWin.FOURTH_GRADE) + "개");
        System.out.println("5개 일치 (1,500,000원) - "+ winCount.get(LotteryWin.THIRD_GRADE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ winCount.get(LotteryWin.SECOND_GRADE) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ winCount.get(LotteryWin.FIRST_GRADE) + "개");
    }

    public void calculateRateOfReturn(LottoShop lottoShop) {
        double rateOfReturn = ((double)winMoney/ (double)lottoShop.getShopMoney() * 100.0);
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }


}
