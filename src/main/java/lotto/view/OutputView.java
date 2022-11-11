package lotto.view;

import java.util.List;
public class OutputView {

    public static void purchaseAmountMsg() {
        System.out.println("로또 구입 금액을 입력해주세요.");
    }

    public static void purchaseResultMsg(List<List<Integer>> lottoNumberList, int countFromMoney) {
        System.out.println(countFromMoney+"개를 구매했습니다.");
        for (List<Integer> lottoNumber : lottoNumberList) {
            System.out.println(lottoNumber);
        }

    }
}
