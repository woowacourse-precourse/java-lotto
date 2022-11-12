package lotto.playlotto.object;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input_output.Input;

import java.util.ArrayList;
import java.util.List;

public class User extends Input {

    private List<List<Integer>> lottery_nums = new ArrayList<>();
    private Integer lottery_count;

    private Integer money;

    public void pay_Money(){// 구입 금액 입력
        this.money = returnInt();
        this.lottery_count = money / 1000;
        create_Lottery_nums();
    }

    public void create_Lottery_nums(){ //lottery_nums에 복권 번호 저장
        for(int i = 0; i < this.lottery_count; i++){
            this.lottery_nums.add(create_nums());
        }
    }

    private List<Integer> create_nums(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public List<List<Integer>> return_lottery_nums(){
        return this.lottery_nums;
    }

    public Integer getMoney(){ return this.money; }

    public Integer getLottery_count(){ return this.lottery_count; }

    public int TestReturnSize(){
        this.lottery_count = 6;
        create_Lottery_nums();
        return this.lottery_nums.size();
    }

    public static void main(String[] args) {
        User user = new User();
        user.pay_Money();
        user.create_Lottery_nums();
        System.out.println(user.lottery_count);
        for(List<Integer> list : user.lottery_nums){
            System.out.println(list);
        }
    }


}
