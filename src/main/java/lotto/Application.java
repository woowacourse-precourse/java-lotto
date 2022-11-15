package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int count = DataInput.PurchaseAmount();
        List<List<Integer>> lottoNumber = new ArrayList<>(DataProcess.GetLottoNumber(count));
        List<Integer> winningNumber = new ArrayList<>(DataInput.WinningNumber());
        int bonusNumber = DataInput.BonusNumber(winningNumber);
        int[] matching_number = DataProcess.CalculateReward(lottoNumber, winningNumber, bonusNumber, count);
        long totalReward = DataProcess.CalculateTotalReward(matching_number);
        double income = DataProcess.CalculateIncome(totalReward, count);

        DataOutput.count(count);
        DataOutput.LottoNumber(lottoNumber, count);
        DataOutput.Reward(matching_number);
        DataOutput.income(income);
    }
}
