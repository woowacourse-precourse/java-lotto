package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class OutputUi {

    private static final String INSERT_MONEY_INFO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT_INFO_MESSAGE_FORMAT = "\n%d개를 구매했습니다.";

    public static void printInsertMoneyInfoMessage(){
        System.out.println(INSERT_MONEY_INFO_MESSAGE);
    }

    public static void printPurchasedLottos(List<Lotto> lottos){

        System.out.println(String.format(PURCHASED_LOTTO_COUNT_INFO_MESSAGE_FORMAT, lottos.size()));

        for(Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
    }
}
