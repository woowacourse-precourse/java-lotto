package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistics {
    private List<Integer> same_count;
    private List<Integer>[] user_lotterys;
    private List<Integer> winning_lottery_number;
    private int bonus_number;
    private int purchase_amount;
    private int Purchase_count;

    public WinningStatistics(List<Integer>[] user_lotterys, List<Integer> winning_lottery_number, int bonus_number,int purchase_amount) {
        this.user_lotterys = user_lotterys;
        this.winning_lottery_number = winning_lottery_number;
        this.bonus_number = bonus_number;
        this.purchase_amount=purchase_amount;
        this.Purchase_count=purchase_amount/1000;
        setSameCount();
        statisticsLottery();
        PrintWinningStatistics();
    }

    private void setSameCount() {
        same_count = new ArrayList<>();
        for (int i = 0; i < LottoRange.WINING_RANK.getValue(); i++) {
            same_count.add(0);
        }
    }

    private void statisticsLottery() {
        boolean is_bonus;
        for (int i = 0; i < Purchase_count; i++) {
            is_bonus = compareLotteryBonus(user_lotterys[i]);
            winningCount(compareLottery(winning_lottery_number, user_lotterys[i]), is_bonus);
        }
    }

    private boolean compareLotteryBonus(List<Integer> user_lottery_number) {
        for (int i = 0; i < LottoRange.LOTTERY_MAX.getValue(); i++) {
            if (bonus_number == user_lottery_number.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int compareLottery(List<Integer> winning, List<Integer> user) {
        List<Integer> winning_clone = new ArrayList<>(winning);
        winning_clone.removeAll(user);
        return winning_clone.size();
    }

    private void winningCount(int counting, boolean is_bonus) {
        if (counting == WinningRank.FIRST_COUNT.getValue()) sameCounting(WinningRank.FIRST_RANK.getValue());
        if (counting == WinningRank.SECOND_COUNT.getValue() && is_bonus) sameCounting(WinningRank.SECOND_RANK.getValue());
        if (counting == WinningRank.THIRD_COUNT.getValue() && !is_bonus) sameCounting(WinningRank.THIRD_RANK.getValue());
        if (counting == WinningRank.FOURTH_COUNT.getValue()) sameCounting(WinningRank.FOURTH_RANK.getValue());
        if (counting == WinningRank.FIFTH_COUNT.getValue()) sameCounting(WinningRank.FIFTH_RANK.getValue());
    }

    private void sameCounting(int rank) {
        List<Integer> _same_count = new ArrayList<>(same_count);
        _same_count.set(rank, _same_count.get(rank) + 1);
        same_count = _same_count;
    }

    private void PrintWinningStatistics() {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "+same_count.get(WinningRank.FIFTH_RANK.getValue())+"개");
        System.out.println("4개 일치 (50,000원) - "+same_count.get(WinningRank.FOURTH_RANK.getValue())+"개");
        System.out.println("5개 일치 (1,500,000원) - "+same_count.get(WinningRank.THIRD_RANK.getValue())+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+same_count.get(WinningRank.SECOND_RANK.getValue())+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+same_count.get(WinningRank.FIRST_RANK.getValue())+"개");
        System.out.println("총 수익률은 "+String.format("%.1f",getYield())+"%입니다.");
    }

    private double getYield(){
        int total_reward=0;
        total_reward+=same_count.get(WinningRank.FIRST_RANK.getValue())*WinningRank.FIRST_RANK_REWARD.getValue();
        total_reward+=same_count.get(WinningRank.SECOND_RANK.getValue())*WinningRank.SECOND_RANK_REWARD.getValue();
        total_reward+=same_count.get(WinningRank.THIRD_RANK.getValue())*WinningRank.THIRD_RANK_REWARD.getValue();
        total_reward+=same_count.get(WinningRank.FOURTH_RANK.getValue())*WinningRank.FOURTH_RANK_REWARD.getValue();
        total_reward+=same_count.get(WinningRank.FIFTH_RANK.getValue())*WinningRank.FIFTH_RANK_REWARD.getValue();
        return (double)total_reward/purchase_amount*100.0;
    }
}
