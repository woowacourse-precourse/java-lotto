package lotto.controller;

import lotto.utils.GenerateLottoNumber;
import lotto.domain.Lotto;

public class LottoController {
    private final GenerateLottoNumber generateLottoNumber;
    private final Lotto awardlotto; // 당첨된 로또
    public LottoController(){
        generateLottoNumber = new GenerateLottoNumber();
        awardlotto = new Lotto(generateLottoNumber.generateLottoNumber());
    }
    public void run(){

    }
}
