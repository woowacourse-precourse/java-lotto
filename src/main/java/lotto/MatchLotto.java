package lotto;

import java.text.DecimalFormat;
import java.util.List;


public class MatchLotto {
    private static List<List<Integer>> Lotto_Random_arr;
    private static List<Integer> numbers;
    private static int bonusNum;

    private static int sum;
    private static int[] countMatch = {0, 0, 0, 0, 0};

    public MatchLotto(List<List<Integer>> Lotto_Random_arr, List<Integer> numbers, int bonusNum) {
        this.Lotto_Random_arr = Lotto_Random_arr;
        this.numbers = numbers;
        this.bonusNum = bonusNum;
        Matching();
        showStatistics();

    }

    private static void Matching() {
        for (List<Integer> Lotto_Random_one : Lotto_Random_arr) {
            int count = countNumber(Lotto_Random_one);
            boolean bonus = containBonus(Lotto_Random_one);

            if (count >= 3) {
                MatchMoney matchMoney = insertMoney(Lotto_Random_one, count, bonus);
            }
        }
    }

    private static MatchMoney insertMoney(List<Integer> Lotto_Random_one, int count, boolean bonus) {
        MatchMoney matchMoney = MatchMoney.Matching(count);
        if (count == 5) {
            matchMoney = matchMoney.countFive(bonus);
        }
        countMatch[matchMoney.ordinal()] += 1;
        return matchMoney;
    }

    private static int countNumber(List<Integer> Lotto_Random_one) {
        int count = 0;

        for (int number : numbers) {
            if (Lotto_Random_one.contains(number)) {
                count += 1;
            }
        }

        return count;
    }

    private static boolean containBonus(List<Integer> Lotto_Random_one) {
        boolean bonus = false;
        if (Lotto_Random_one.contains(bonusNum)) {
            bonus = true;
        }
        return bonus;
    }

    private static void showStatistics() {
            for (MatchMoney matches : MatchMoney.values()) {
                sum += matches.getMoney()*countMatch[matches.ordinal()];
                DecimalFormat df = new DecimalFormat("###,###");
                String money = df.format(matches.getMoney());
                if (matches == MatchMoney.TWO) {
                    System.out.println(matches.getMatchCount() + "개 일치, 보너스 볼 일치 ("+ money+"원) - "+countMatch[matches.ordinal()]+"개");
                    continue;
                }
                System.out.println(matches.getMatchCount() + "개 일치 ("+ money+"원) - "+countMatch[matches.ordinal()]+"개");
            }
    }
    public static void calculateOutput(int buyNum) {
        double output = ((double)sum/(double)buyNum)*100;
        DecimalFormat df = new DecimalFormat("#.#");
        String result = df.format(output);
        System.out.println("총 수익률은 " + result+"%입니다.");
    }

}




