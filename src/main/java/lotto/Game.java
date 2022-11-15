package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
public class Game {

    private static Integer setBuyLottoCount(){
        System.out.println("구입 금액을 입력해주세요.");
        String count = camp.nextstep.edu.missionutils.Console.readLine();
        int buyLottoCount = Check.convertMoneytoCount(count);
        buyLottoCount = Check.divideThousand(buyLottoCount);
        System.out.println(buyLottoCount+"개를 구매했습니다.");
        return buyLottoCount;
    }

}
