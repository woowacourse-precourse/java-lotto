package lotto.playlotto.object;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input_output.Input;

import java.util.ArrayList;
import java.util.List;

public class User extends Input {

    private List<List<Integer>> lottery_nums = new ArrayList<>();
    private Integer lottery_count;

    private Integer money;

    public void pay_Money()  {// 구입 금액 입력
        this.money = returnPayMoney();
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


    public Integer getLottery_count(){ return this.lottery_count; }

    public Integer getMoney(){ return this.money; }

    public List<List<Integer>> getLottery_nums() {
        return lottery_nums;
    }

    public void setLottery_nums(List<List<Integer>> lottery_nums) {
        this.lottery_nums = lottery_nums;
    }

    public void setLottery_count(Integer lottery_count) {
        this.lottery_count = lottery_count;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }





}
