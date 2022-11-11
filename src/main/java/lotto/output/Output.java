package lotto.output;

import lotto.domain.Lotto;

import java.util.ArrayList;

public class Output {
    private static final String PRICE_MESSAGE  = "구입금액을 입력해주세요.";
    private static final String CHECK_LOTTOS_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void askBuyPrice(){
        System.out.println(PRICE_MESSAGE);
    }
    public static void checkBuyLotto(ArrayList<Lotto> buyLottos){
        int size = buyLottos.size();
        System.out.println(size+CHECK_LOTTOS_MESSAGE);
        for(Lotto tempLotto: buyLottos){
            System.out.println(tempLotto.getNumbers());
        }
    }
    public static void askWinNumber(){
        System.out.println(WIN_NUMBER_MESSAGE);
    }
    public static void askBonusNumber(){
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
