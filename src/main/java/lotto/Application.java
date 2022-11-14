package lotto;

//import lotto.domain.NumberGenerator;
import lotto.ui.UI;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UI ui = new UI();

        System.out.println(ui.GetMoney());
        System.out.println(ui.GetLottoNumber().toString());
        System.out.println(ui.GetBonusNumber());

        // TODO: 프로그램 구현
    }
}
