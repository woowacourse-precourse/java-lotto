package lotto.input_output;

import lotto.enums.Out;
import lotto.playlotto.object.User;
import lotto.enums.Reward;

import java.util.List;

import static lotto.enums.Out.*;

public class Output {
    public void buy_lottery(){
        System.out.println(BUY_LOTTERY.getOutput());
    }
    public void print_buy_lottery(int buy){
        System.out.printf(PRINT_BUY_LOTTERY.getOutput()+"%n", buy);
    }
    public void print_lottery(User user){
        for(List<Integer> lottery : user.getLottery_nums()){
            System.out.println(lottery);
        }
    }
    public void win_lottery_number(){
        System.out.println(WIN_LOTTERY_NUMBER.getOutput());
    }
    public void bonus_lottery_number(){
        System.out.println(BONUS_LOTTERY_NUMBER.getOutput());
    }
    public void print_result(List<Integer> result) {
        for(Reward reward : Reward.values()){
            System.out.printf(reward.getReward(), result.get(reward.ordinal()));
        }
    }

    public void print_revenue(Float revenue){
        System.out.printf(YIELD.getOutput(), revenue);
    }

    public static void main(String[] args)  {
        User user = new User();
        Output out1 = new Output();
        user.pay_Money();
        user.create_Lottery_nums();
        out1.print_lottery(user);
    }



}
