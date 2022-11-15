package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class LottoNumberOutput {

    private final List<Lotto> lottoNumber;

    public LottoNumberOutput(List<Lotto> lottoNumber){
        this.lottoNumber = lottoNumber;
    }
    public void lottoNumberOutput() {
        System.out.println(lottoNumber.size()+"개를 구매했습니다.");
        for(Lotto e : lottoNumber){
            System.out.println(e.getNumbers());
        }
    }
}
