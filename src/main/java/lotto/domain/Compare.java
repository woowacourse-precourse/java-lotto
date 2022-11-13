package lotto.domain;

import java.util.ArrayList;
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

    public List<Integer> countCorrect() {
        List<Integer> countList = new ArrayList<>();
        int count = 0;

        Lotto myLotto = lottoWithBonus.getLotto();

        for (Lotto haveLotto : haveLottoList) {
            count += isContains(haveLotto, myLotto);
            countList.add(count);
            count = 0;
        }
        return countList;
    }

    private int isContains(Lotto haveLotto, Lotto myLotto) {
        int count = 0;
        for (Integer number : myLotto.getLottoNumbers()) {
            if (haveLotto.getLottoNumbers().contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    public void getAll() {
        for (Lotto lotto : haveLottoList) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println(lottoWithBonus.getLotto().getLottoNumbers());
        System.out.println(lottoWithBonus.getBonusNumber());
    }
}
