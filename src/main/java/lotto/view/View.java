package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.List;

public class View {
    public static String printUserInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static void printUserLotto(List<Lotto> userLotto) {
        for(Lotto lottoPiece : userLotto){
            System.out.println(lottoPiece.getNumbers());
        }
    }

}
