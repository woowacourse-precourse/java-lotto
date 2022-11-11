package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.exception.PaymentException;

import java.util.List;

public class PlayerView {
    private static final String REQUEST_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String CHECK_PAYMENT = "개를 구매했습니다.";

    public String payMoney(){
        inquirePrice();
        String price = scanPrice();
        validate(price);
        return price;
    }

    private void inquirePrice(){
        System.out.println(REQUEST_PAYMENT);
    }

    private String scanPrice(){
        return Console.readLine();
    }

    private void validate(String price){
        PaymentException paymentException = new PaymentException();
        paymentException.validate(price);
    }

    public void showPlayersLotto(List<Lotto> playerLotto){
        showPlayersLottoCount(playerLotto);
        showLottoNumbers(playerLotto);
    }

    private void showPlayersLottoCount(List<Lotto> playerLotto){
        System.out.println(playerLotto.size()+CHECK_PAYMENT);
    }

    private void showLottoNumbers(List<Lotto> playerLotto){
        for(Lotto lottoEach : playerLotto){
            System.out.println(lottoEach.toString());
        }
        System.out.println();
    }


}
