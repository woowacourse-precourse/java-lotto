package lotto;

import static lotto.Validator.validateLottoPrice;

public class LottoService {
    private final LottoConsole lottoConsole;
    private final UserLottoInfo userLottoInfo;

    public LottoService(LottoConsole lottoConsole, UserLottoInfo userLottoInfo){
        this.lottoConsole = lottoConsole;
        this.userLottoInfo = userLottoInfo;
    }

    public String inputLottoPrice(){
        String lottoPrice = lottoConsole.inputLottoPrice();
        validateLottoPrice(lottoPrice);

        return lottoPrice;
    }

    public void storeLottoPrice(String lottoPrice){
        userLottoInfo.setLottoPrice(Integer.parseInt(lottoPrice));
    }


}
