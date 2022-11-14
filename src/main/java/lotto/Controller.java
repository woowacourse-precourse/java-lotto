package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.User;

import static lotto.domain.User.getUserInput;

public class Controller {


    public void playGame(){
        final Lotto Lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        final User User = new User(getUserInput());
        //GameService 불러오기
    }

    public void getResult(){

    }

}
