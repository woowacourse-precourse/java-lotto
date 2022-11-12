package lotto.playlotto;

import lotto.enums.Reward;
import lotto.enums.Size;
import lotto.enums.WinCondition;
import lotto.input_output.Input;
import lotto.input_output.Output;
import lotto.playlotto.object.Lotto;
import lotto.playlotto.object.User;

import java.util.ArrayList;
import java.util.List;


public class PlayLotto extends Input {

    private Lotto lotto;
    private User user;
    private final Output out;
    private List<Integer> win_count;
    private int bonus;

    public PlayLotto() {

        this.user = new User();
        this.out = new Output();
        this.win_count = new ArrayList<>(List.of(0,0,0,0,0));
    }

    public void play() { //한 사이클 실행
        buy_lottery();
        print_buy_lottery();
        print_lottery_nums();
        create_lotto();
        create_bonus();
        compare_lottery();
        print_result(win_count);
        print_yeild();

    }

    public void buy_lottery(){ //사용자에게 복권 당첨 금액 입력받기
        out.buy_lottery();
        this.user.pay_Money();
    }
    public void print_buy_lottery(){
        out.print_buy_lottery(user.getLottery_count());
    }
    public void print_lottery_nums(){
        out.print_lottery(user);
    }

    public void create_lotto(){ // 당첨 번호 입력받기
        out.win_lottery_number();
        this.lotto = new Lotto(returnList());
    }
    public void create_bonus(){ // 보너스 번호 입력받기
        out.bonus_lottery_number();
        this.bonus = returnInt();
    }

    public void compare_lottery(){
        for(List<Integer> user_lottery : user.return_lottery_nums()){ //사용자 번호와 당첨 번호 비교
            equal_count(lotto.returnNumbers(), user_lottery);
        }
    }

    public void equal_count(List<Integer> win_lottery, List<Integer> user_lottery){

        int count = 0;
        int bonus = 0;
        for(int i = 0; i < Size.LOTTERY_SIZE.getSize(); i++){

            if(check_num(win_lottery, user_lottery.get(i))){ //기본 번호 체크
                count += 1;
            }
            if(check_bonus(win_lottery, this.bonus)){  //보너스 번호 체크
                bonus += 1;
            }
        }
        check_result(count, bonus);
    }

    public Boolean check_num(List<Integer> win_lottery, Integer user_num){
        return win_lottery.contains(user_num);
    }
    public Boolean check_bonus(List<Integer> win_lottery, Integer bonus_num){
        return win_lottery.contains(bonus_num);
    }

    public Boolean check_result(int count, int bonus){
        int index = WinCondition.getIndex(count, bonus);
        if(index != -1){
            win_count.add(index, win_count.get(index)+1);
            return true;
        }
        return false;
    }

    public void print_result(List<Integer> win_count){
        out.print_result(win_count);
    }

    public void print_yeild(){
        out.print_revenue(cal_revenue());
    }

    public Float cal_revenue(){
        Float sum = 0f;
        for(Reward reward : Reward.values()){
            sum += reward.getValue() * win_count.get(reward.ordinal());
        }
        return sum / user.getMoney() * 100;
    }

    public static void main(String[] args) {
        PlayLotto playLotto = new PlayLotto();

    }



}
