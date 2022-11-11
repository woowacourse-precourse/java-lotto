package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;

public class PlayerView {
    private static final String REQUEST_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String CHECK_PAYMENT = "개를 구매했습니다.";

    public String payMoney(){
        return "";
    }

    private void inquirePrice(){
        System.out.println(REQUEST_PAYMENT);
    }

    private String scanPrice(){
        return "";
    }

    private void validate(String price){

    }

    public void showPlayersLotto(List<Lotto> playerLotto){

    }

    private void showPlayersLottoCount(List<Lotto> playerLotto){

    }

    private void showLottoNumbers(List<Lotto> playerLotto){

    }


}
