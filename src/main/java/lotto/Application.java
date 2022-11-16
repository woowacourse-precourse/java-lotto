package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.Dispatch;
import lotto.controller.RankController;
import lotto.controller.UserController;
import lotto.domain.user.User;
import lotto.view.RankingView;
import lotto.view.Store;

public class Application {
    public static void main(String[] args) {
        LottoConfig lottoConfig = new LottoConfig();
        Dispatch dispatch = new Dispatch(lottoConfig);
        try{
            dispatch.buyLotto();
            dispatch.drawLotto();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
