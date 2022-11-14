package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataProcess {
    enum Reward_Amount{
        EQUALTHREE(5000),
        EQUALFOUL(50000),
        EUQALFIVE(1500000),
        EQUALBONUS(30000000),
        EQUALSIX(2000000000);

        private final long amount;
        Reward_Amount(long amount) {this.amount = amount; }
        public long getAmount() {return amount; }
    }
    private static final int MAXIMUM_NUMBER_OF_LOTTO = 45;
    private static final int MINIMUM_NUMBER_OF_LOTTO = 1;
    private static final int NUMBER_OF_LOTTO_NUMBER = 6;
    private static final int NUMBER_OF_WINNING_COUNT = 5;

    public static List<List<Integer>> GetLottoNumber(int count) {
        List<List<Integer>> numbers = new ArrayList<>();
        for(int i = 0; i < count; i++)
            numbers.add(Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER_OF_LOTTO, MAXIMUM_NUMBER_OF_LOTTO, NUMBER_OF_LOTTO_NUMBER));
        return numbers;
    }

    public static int[] CalculateReward(List<List<Integer>> lottoNumber, List<Integer> winningNumber, int bonusNumber, int count) {
        int[] matching_number = new int[NUMBER_OF_WINNING_COUNT];
        for(int i = 0; i < count; i++) {
            List<Integer> numbers = lottoNumber.get(i).stream()
                    .filter(old -> winningNumber.stream()
                            .anyMatch(Predicate.isEqual(old)))
                    .collect(Collectors.toList());
            int correct_number = numbers.size();
            if(correct_number > 2)
                matching_number[correct_number-3]++;
            if(correct_number == 5 && lottoNumber.get(i).contains(bonusNumber)) {
                matching_number[2]--;
                matching_number[NUMBER_OF_WINNING_COUNT-1]++;
            }
        }

        return matching_number;
    }

    public static long CalculateTotalReward(int[] matching_number){
        long totalReward = 0;
        Reward_Amount[] Reward = Reward_Amount.values();
        for(int i = 0; i < matching_number.length; i++){
            totalReward = Reward[i].amount * matching_number[i];
        }
        return totalReward;
    }

    public static float CalculateIncome(long totalReward, int count){
        float income = totalReward / count;
        income /= 10.0;
        return income;
    }
}
