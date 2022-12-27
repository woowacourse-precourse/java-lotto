package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountNumber {
    // 당첨 확인하는 기능
    private static List<Integer> winningNumbers;
    private static int bonusNumber;
    private static List<Lotto> lottoNumbers;

    public static void compare(List<Object> inputNumbers, List<Lotto> lotto) {
        winningNumbers = (List<Integer>) inputNumbers.get(0);
        bonusNumber = (int) inputNumbers.get(1);
        lottoNumbers = lotto;
        Map<String, Integer> correctCount = correctNumberCount(winningNumbers, bonusNumber, lottoNumbers);
        // 당첨 통계 출력

    }
    // 당첨 번호와 발행 로또 번호 비교
    public static int compareLottoWinning(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (int lotto : lottoNumbers) {
            for (int number : winningNumbers) {
                if (lotto == number) {
                    count++;
                }
            }
        }
        return count;
    }

    // 보너스 번호와 발행 로또 번호 비교
    public static int compareLottoBonus(int bonusNumber, List<Integer> lottoNumbers) {
        int count = 0;
        for (int lotto : lottoNumbers) {
            if (lotto == bonusNumber) {
                count++;
            }
        }
        return count;
    }

    //

    // 일치하는 개수 확인
    public static Map<String, Integer> correctNumberCount(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottoNumbers) {
       Map<String, Integer> correctNumberCnt = new HashMap<>();

        Map<String, Integer> winnerPerRank = new HashMap<>();

        initializeHashMapWithZero(winnerPerRank);
        for (Lotto lotto : lottoNumbers) {
            List<Integer> lottos = lotto.getNumbers();
            int correctWinningCnt = compareLottoWinning(winningNumbers, lottos);

            correctNumberCnt = resultCorrectCount(winnerPerRank ,correctWinningCnt, winningNumbers, lottos, bonusNumber);

        }
        System.out.println(correctNumberCnt);
        return correctNumberCnt;
    }

    private static void initializeHashMapWithZero(Map<String, Integer> winnerPerRank) {
        winnerPerRank.put("3", 0);
        winnerPerRank.put("4", 0);
        winnerPerRank.put("5", 0);
        winnerPerRank.put("5+b", 0);
        winnerPerRank.put("6", 0);
    }

    // 일치 개수 계산
    public static Map<String, Integer> resultCorrectCount(Map<String, Integer> winnerPerRank, int correctWinningCnt, List<Integer> winningNumbers, List<Integer> lottos, int bonusNumber) {
        if (correctWinningCnt == 3) {
            int cnt = winnerPerRank.get("3");
            System.out.println("3===>" + cnt);
            winnerPerRank.put("3", cnt+1);
        }
        if (correctWinningCnt == 4) {
            int cnt = winnerPerRank.get("4");
            System.out.println("4===>" + cnt);
            winnerPerRank.put("4", cnt+1);
        }
        if (correctWinningCnt == 5) {
            int correctBonusCnt = compareLottoBonus(bonusNumber, lottos);
            System.out.println("5===>" + correctBonusCnt);
            if (correctBonusCnt == 0) {
                int cnt = winnerPerRank.get("5");
                winnerPerRank.put("5", cnt+1);
            }
            if (correctBonusCnt == 1) {
                int cnt = winnerPerRank.get("5+b");
                winnerPerRank.put("5+b", cnt+1);
            }
        }
        if (correctWinningCnt == 6) {
            int cnt = winnerPerRank.get("6");
            System.out.println("6===>" + cnt);
            winnerPerRank.put("6", cnt+1);
        }
        return winnerPerRank;
    }
}
