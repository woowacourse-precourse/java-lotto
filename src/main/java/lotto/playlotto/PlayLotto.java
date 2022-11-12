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

/*
### PlayLotto
- [x] 사용자에게 복권 당첨 금액 입력받기
- [x] 발행된 복권 메시지 그리고 번호 출력
- [ ] 당첨 번호 입력받기
- [ ] 보너스 번호 입력받기
- [ ] 사용자 번호와 당첨 번호 비교
- [ ] 3개 ~ 6개 결과 출력(당첨 통계)
- [ ] 수익률 출력 단 소숫점 2째 자리 반올림
 */
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
    /*
- [x] 당첨 번호 입력받기
- [x] 보너스 번호 입력받기
- [x] 사용자 번호와 당첨 번호 비교
- [x] 3개 ~ 6개 결과 출력(당첨 통계)
- [ ] 수익률 출력 단 소숫점 2째 자리 반올림
     */
    public void create_lotto(){ // 당첨 번호 입력받기
        out.win_lottery_number();
        this.lotto = new Lotto(returnList());
    }
    public void create_bonus(){ // 보너스 번호 입력받기
        out.bonus_lottery_number();
        this.bonus = returnInt();
    }