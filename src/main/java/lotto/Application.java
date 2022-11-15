package lotto;

import camp.nextstep.edu.missionutils.Console;
import domain.LottoFactory;
import domain.Lottos;
import dto.LottosDto;
import view.InputUtil;
import view.OutputUtil;

import java.util.ArrayList;

public class Application {
    public static void buyLottos(){
        OutputUtil.noticePurchase();
        Integer purchase = InputUtil.inputNumber();
        Lottos lottos = LottoFactory.makeLottos(purchase);
        LottosDto lottosDto = lottos.sendDto();
        OutputUtil.showPurchaseResult(lottosDto);
    }
    public static void main(String[] args) {
        buyLottos();
    }
}
