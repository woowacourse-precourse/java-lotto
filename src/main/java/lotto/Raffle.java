package lotto;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Raffle {
    static List<String> winningRecord;

    public static void statistics() {
        System.out.println("당첨 통계\n--");
        lottos();
        printReward();
    }

    // check all the lottos
    public static void lottos() {
        winningRecord = new ArrayList<>();
        for (List<Integer> lotto : User.allLottos) {
            winningRecord.add((check(lotto)));
        }
    }

    // check whether lottos bought are winning
    public static String check(List<Integer> lotto) {
        List<Integer> guessResult = lotto.stream().filter(l -> User.guess.contains(l)).collect(Collectors.toList());
        String correct = String.valueOf(guessResult.size());

        // case when 5 numbers are right and also got bonus number
        if (lotto.contains(User.bonus) && Integer.valueOf(correct) == 5) {
            correct += "+";
        }
        return correct;
    }

    public static void formatReward(String poss, String reward, int dupAmount) {
        System.out.format("%s개 일치 (%s원) - %s개", poss, reward, dupAmount);
        System.out.println();
    }

    public static void formatBonusReward(String poss, String reward, int dupAmount) {
        System.out.format("5개 일치, 보너스 볼 일치 (%s원) - %s개", reward, dupAmount);
        System.out.println();
    }

    public static void printReward() {
        List<String> allPossibility = new ArrayList<>(Arrays.asList("3", "4", "5", "5+", "6"));
        int rewardTotal = 0;

        for (String poss : allPossibility) {
            int dupAmount = Collections.frequency(winningRecord, poss);

            String reward = Winning.getReward(poss);

            rewardTotal += dupAmount * Integer.valueOf(reward.replaceAll(",", ""));
            if (!poss.contains("+")) {
                formatReward(poss, reward, dupAmount);
            }
            if (poss.contains("+")) {
                formatBonusReward(poss, reward, dupAmount);
            }
        }
        System.out.format("총 수익률은 %.1f%%입니다.", 100 * rewardTotal / Float.valueOf(User.lottoPayment));
    }
}
