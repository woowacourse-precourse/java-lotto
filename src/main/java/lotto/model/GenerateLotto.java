package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class GenerateLotto {
    private final List<Lotto> lottoTickets;

    public GenerateLotto() {
        this.lottoTickets = setLotto();
    }

    public List<Lotto> setLotto() {
        Money money = new Money();
        int tickets = money.getLottoTickets();

        List<Lotto> newLotto = new ArrayList<>();

        for(int i = 0; i < tickets; i++) {
            newLotto.add(new Lotto(getLottoNumbers()));
        }
        return newLotto;
    }
    public List<Integer> getLottoNumbers() {
        //1 ~ 45 6개 숫자 생성
        return null;
    }
}
