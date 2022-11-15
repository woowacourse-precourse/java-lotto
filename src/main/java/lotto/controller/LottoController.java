package lotto.controller;

import lotto.model.LottoResult;
import lotto.model.User;

public class LottoController {
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final LottoCompare lottoCompare = new LottoCompare();
    private final LottoStatistics lottoStatistics = new LottoStatistics();
    private User user;
    private LottoResult lottoResult;

    public void controlLotto(){
        try{
            user = lottoPurchase.controlLottoPurchase();
            lottoResult = lottoCompare.controlLottoCompare(user);
            lottoStatistics.controlLottoResults(user, lottoResult);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
