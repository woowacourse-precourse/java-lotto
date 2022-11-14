package lotto.view;

import java.util.List;

public class Output {
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String COUNT_LOTTO_MESSAGE = "%d개 구매했습니다.\n";

    public static void printInputMoney(){
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public static void printCountLotto(int countLotto){
        System.out.printf(COUNT_LOTTO_MESSAGE, countLotto);
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers){
        System.out.println(lottoNumbers);
    }
}
