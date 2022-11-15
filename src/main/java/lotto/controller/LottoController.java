package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LuckyNumber;
import lotto.domain.Prize;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutView;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoController {
    User user = new User();
    LuckyNumber luckyNumber = new LuckyNumber();

    public void buyLotto(){
        InputView.inputPurchaseAmount();
        user.inputPurchaseAmount(Console.readLine());
    }


}
