package lotto;

import java.util.List;

public class OutputView {
    public static void printStartMesseage(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoNumber(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLotto(List<Lotto> lottos){
        for (Lotto lotto: lottos){
            System.out.println(lotto);
        }
    }
}
