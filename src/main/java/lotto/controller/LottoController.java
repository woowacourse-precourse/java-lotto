package lotto.controller;

import lotto.utils.GenerateLottoNumbers;
import lotto.domain.Lotto;

public class LottoController {
    private final GenerateLottoNumbers generateLottoNumbers;
    private final Lotto awardlotto; // 당첨된 로또
    public LottoController(){
        generateLottoNumbers = new GenerateLottoNumbers();
        awardlotto = new Lotto(generateLottoNumbers.generateLottoNumber());
    }
    public void run(){

    }
}
