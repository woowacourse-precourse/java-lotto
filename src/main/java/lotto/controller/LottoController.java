package lotto.controller;

import lotto.service.LottoService;
import lotto.view.*;
import lotto.vo.Lotto;
import lotto.type.PlaceType;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class LottoController {
    public void showIntroduce() {
        View view = new IntroduceView();
        view.show();
    }

    public String showMoneyInput() {
        View view = new MoneyInputView();
        view.show();

        String response = view.getResponse();
        validateInput("^(\\d+[0][0][0]){4,}$", response);

        return response;
    }

    public void showLottoPurchaseNumbers(String input) {
        LottoService service = new LottoService();
        List<Lotto> purchaseLotteries = service.buyLotteriesAs(parseInt(input));
        View view = new LottoPurchaseNumberView(purchaseLotteries);
        view.show();
    }

    public void showLottoNumberInput() {
        View view = new LottoNumberInputView();
        view.show();

        String response = view.getResponse();
        validateInput("^([1-9,])$", response);

        //TODO - 당첨번호 저장 Service 호출

    }

    public void showBonusNumberInput() {
        View view = new BonusNumberInputView();
        view.show();

        String response = view.getResponse();
        validateInput("^([1-9]{1-2})$", response);

        //TODO - 보너스번호 저장 Service 호출

    }

    public void showLottoStatistic() {
        //TODO - 당첨 통계 Service 호출
        Map<PlaceType, Integer> statistic = Map.of(PlaceType.THIRD_PLACE, 1); // mockup
        int numberOfPurchases = 1;

        View view = new LottoStatisticView(statistic, numberOfPurchases);
        view.show();
    }

    public static void validateInput(String regex, String input) {
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException("안내에 따라 값을 입력해주세요.");
        }
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
