package lotto.domain;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoWithBonus;

public class Compare {

    private List<Lotto> haveLottoList;
    private LottoWithBonus lottoWithBonus;

    public Compare(List<Lotto> haveLottoList, LottoWithBonus lottoWithBonus) {
        this.haveLottoList = haveLottoList;
        this.lottoWithBonus = lottoWithBonus;
    }

    public void getAll() {
        for (Lotto lotto : haveLottoList) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println(lottoWithBonus.getLotto().getLottoNumbers());
        System.out.println(lottoWithBonus.getBonusNumber());
    }
}
