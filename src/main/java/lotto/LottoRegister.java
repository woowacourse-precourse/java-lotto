package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoRegister {
    Application.LotteryWon lotteryWon;
    HashMap<Application.LotteryWon, Integer> history;
    int totalIncome;
    float rateOfReturn;

    public LottoRegister() {
        history = initializeHistory();
        totalIncome = 0;
    }

    public float getRateOfReturn(final int MONEY) {
        rateOfReturn = (float) totalIncome / MONEY * 100;
        return rateOfReturn;
    }

    public int calculateTotalGain(List<Lotto> boughtLottos, List<Integer> pickedNumbers, List<Integer> bonusNum) {
        for (int i = 0; i < boughtLottos.size(); i++) {
            int matchCount = countMatchedNumber(boughtLottos.get(i), pickedNumbers);
            int bonusCount = countMatchedNumber(boughtLottos.get(i), bonusNum);

            totalIncome += calculateByCase(matchCount, bonusCount);
        }
        printHistory(history);

        return totalIncome;
    }

    private int calculateByCase(int matchCount, int bonusCount) {
        lotteryWon = selectLotteryWonType(matchCount, bonusCount);
        history = updateHistory(history, lotteryWon);

        return lotteryWon.calculateIncome(1);
    }

    public void printHistory(HashMap<Application.LotteryWon, Integer> history) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + history.get(Application.LotteryWon.FifthPlace) + "개");
        System.out.println("4개 일치 (50,000원) - " + history.get(Application.LotteryWon.FourthPlace) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + history.get(Application.LotteryWon.ThirdPlace) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + history.get(Application.LotteryWon.SecondPlace) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + history.get(Application.LotteryWon.FirstPlace) + "개");
    }

    public int countMatchedNumber(Lotto lotto, List<Integer> pickedNumbers) {
        int count = 0;

        for (int i = 0; i < pickedNumbers.size(); i++) {
            int number = pickedNumbers.get(i);
            count += lotto.matchNumber(number);
        }

        return count;
    }

    public HashMap<Application.LotteryWon, Integer> updateHistory(HashMap<Application.LotteryWon,
            Integer> history, Application.LotteryWon income) {
        history.replace(income, history.get(income) + 1);
        return history;
    }

    public HashMap<Application.LotteryWon, Integer> initializeHistory() {
        HashMap<Application.LotteryWon, Integer> history = new HashMap<Application.LotteryWon, Integer>();
        history.put(Application.LotteryWon.FirstPlace, 0);
        history.put(Application.LotteryWon.SecondPlace, 0);
        history.put(Application.LotteryWon.ThirdPlace, 0);
        history.put(Application.LotteryWon.FourthPlace, 0);
        history.put(Application.LotteryWon.FifthPlace, 0);
        history.put(Application.LotteryWon.Nothing, 0);

        return history;
    }

    public Application.LotteryWon selectLotteryWonType(int matchCount, int bonusCount) {
        Application.LotteryWon result;
        if (matchCount == 6) {
            result = Application.LotteryWon.FirstPlace;
            return result;
        } else if (matchCount == 5 && bonusCount == 1) {
            result = Application.LotteryWon.SecondPlace;
            return result;
        } else if (matchCount == 5) {
            result = Application.LotteryWon.ThirdPlace;
            return result;
        } else if (matchCount == 4) {
            result = Application.LotteryWon.FourthPlace;
            return result;
        } else if (matchCount == 3) {
            result = Application.LotteryWon.FifthPlace;
            return result;
        }

        return Application.LotteryWon.Nothing;
    }

}
