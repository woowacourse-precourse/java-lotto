package lotto;


import java.util.List;
import lotto.EnumCreate.RewardList;

public class RevenueCalculater {

    public int caculateRevenue(List<Integer> correctNumberList) {
        int revenue = 0;

        RewardList rewardList = RewardList.REWARD_LIST;
        for (int i = 0; i < correctNumberList.size(); i++) {
            int index = correctNumberList.get(i) - 3;
            if (index >= 0) {
                revenue += rewardList.getRewardList().get(index);

            }
        }
        return revenue;
    }
}
