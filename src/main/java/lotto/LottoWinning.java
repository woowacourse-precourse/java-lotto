package lotto;

import java.util.List;

public class LottoWinning {

    private final List<Integer> numbers;
    private final Integer bonus;

    public LottoWinning(List<Integer> lotto, Integer bonus, List<List<Integer>> winning, Integer money) {
        this.numbers = lotto;
        this.bonus = bonus;
        if (numbers.contains(bonus))
            throw new IllegalArgumentException("보너스 번호와 당첨 번호는 일치할 수 없습니다.");
    }

    public static double getBenefit(int[] count, Integer inputMoney) {
        int[] money = {5000,50000,1500000,2000000000,30000000};
        long benefit = 0;
        for (int i = 0; i < 5; i++) {
            benefit += money[i]*count[i];
        }
        return (double) (benefit * 100) / inputMoney;
    }

    public static int[] compareEqaulsLotto(List<List<Integer>> lottosList) {
        int[] count = new int[5];
        for (int i = 0; i < lottosList.size(); i++) {
            int[] tmp = getEqulasCount(lottosList.get(i));
            if (tmp[0] == 5 && tmp[1] == 1)
                count[4] += 1;
            else if (tmp[0] >= 3) {
                count[tmp[0]-3] += 1;
            }
        }
        return count;
    }

    public static int[] getEqulasCount(List<Integer> lottoList) {
        int[] count = new int[2];
        for (int i = 0; i < 6; i++) {
            if (this.numbers.contains(lottoList.get(i)))
                count[0]+=1;
            else if (this.bonus == lottoList.get(i))
                count[1]=1;
        }
        return count;
    }

}