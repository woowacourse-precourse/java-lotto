package lotto;


import java.util.List;
import lotto.EnumCreate.RewardList;

public class RevenueCalculater {
    private static final int ZERO = 0;
    private static final int INDEX_MAKER = 3;
    public int caculateRevenue(List<Integer> correctNumberList) {
        int revenue = ZERO;

        RewardList rewardList = RewardList.REWARD_LIST;
        for (int i = ZERO; i < correctNumberList.size(); i++) {
            int index = correctNumberList.get(i) - INDEX_MAKER;
            if (index >= ZERO) {
                revenue += rewardList.getRewardList().get(index);

            }
        }
        return revenue;
    }
}
