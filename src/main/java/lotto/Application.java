package lotto;

//import lotto.domain.NumberGenerator;
import lotto.ui.UI;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        UI ui = new UI();
        int x = ui.GetMoney();
        System.out.println(x);

        List<Integer> al = ui.GetLotto();
        for(var e: al) System.out.println(e);

        int y = ui.GetBonusNumber();
        System.out.println(y);

        ;
        // TODO: 프로그램 구현
    }
}
