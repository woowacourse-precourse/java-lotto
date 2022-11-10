package view;

import lotto.Lotto;

import java.util.ArrayList;

public class Output {
    private static final String PRICE_MESSAGE  = "구입금액을 입력해주세요.";
    private static final String CHECK_LOTTOS_MESSAGE = "개를 구매했습니다.";

    public static void askBuyPrice(){
        System.out.println(PRICE_MESSAGE);
    }
    public void checkBuyLotto(ArrayList<Lotto> buyLottos){
        int size = buyLottos.size();
        System.out.println(size+CHECK_LOTTOS_MESSAGE);
        for(Lotto tempLotto: buyLottos){
            System.out.println(tempLotto.getNumbers());
        }
    }
}
