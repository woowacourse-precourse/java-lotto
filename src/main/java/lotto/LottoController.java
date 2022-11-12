package lotto;

import static lotto.Validator.validateLottoPrice;

public class LottoController {
    private final LottoConsole lottoConsole;

    private UserLottoInfo userLottoInfo;

    public LottoController() {
        lottoConsole = new LottoConsole();
        userLottoInfo = new UserLottoInfo();
    }

    public void executeGame(){
        // 입력 받아서 검증 로직
        String lottoPrice = lottoConsole.inputLottoPrice();
        validateLottoPrice(lottoPrice);

        // userLottoInfo에 저장
        userLottoInfo.setLottoPrice(Integer.parseInt(lottoPrice));
    }
}
