package lotto.input_output;

import lotto.enums.Out;
import lotto.playlotto.object.User;
import lotto.enums.Reward;

import java.util.List;

/*
- [x] 구입 금액 메시지 출력<br>
  ex) 구입금액을 입력해 주세요.
- [x] 복권 구입 갯수 출력<br>
ex) 8개를 구매했습니다.
- [ ] 발행된 복권 출력<br>
ex) [8, 21, 23, 41, 42, 43]
- [x] 당첨 번호 입력 메시지 출력<br>
ex) 당첨 번호를 입력해 주세요.
- [x] 보너스 번호 입력 메시지 출력<br>
ex) 보너스 번호를 입력해 주세요.
- [ ] 당첨 결과 출력<br>
ex)<br>
당첨 통계<br>
"---"<br>
3개 일치 (5,000원) - 1개<br>
4개 일치 (50,000원) - 0개<br>
5개 일치 (1,500,000원) - 0개<br>
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개<br>
6개 일치 (2,000,000,000원) - 0개<br>
- [ ] 수익률 출력 출력<br>
ex) 총 수익률은 62.5%입니다.
- [ ] 오류 메시지 출력(다수)<br>
ex) [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 한다.

 */
public class Output {
    public void buy_lottery(){

        System.out.println(Out.BUY_LOTTERY.getOutput());
    }
    public void print_buy_lottery(int buy){
        System.out.printf(Out.PRINT_BUY_LOTTERY.getOutput()+"%n", buy);
    }
    public void print_lottery(User user){ //TODO: 복권 갯수 마다 출력
        for(List<Integer> lottery : user.return_lottery_nums()){
            System.out.println(lottery);
        }
    }
    public void win_lottery_number(){
        System.out.println(Out.WIN_LOTTERY_NUMBER.getOutput());
    }
    public void bonus_lottery_number(){
        System.out.println(Out.BONUS_LOTTERY_NUMBER.getOutput());
    }
    public void print_result(List<Integer> result) {
        for(Reward reward : Reward.values()){
            System.out.printf(reward.getReward(), result.get(reward.ordinal()));
        }
    }

    public void print_revenue(Float revenue){
        System.out.printf(Out.YIELD.getOutput(), revenue);
    }

    public static void main(String[] args) {
        User user = new User();
        Output out1 = new Output();
        user.pay_Money();
        user.create_Lottery_nums();
        out1.print_lottery(user);
    }



}
