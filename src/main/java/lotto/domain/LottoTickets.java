package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    public LottoTickets(int count){
        addLotto(count);
    }

    public void addLotto(int count){
        for(int i = 0; i < count; i++){
            Lotto lotto = new Lotto(LottoNumber.createLotto());
            lottoTickets.add(lotto);
        }
    }
    public int length(){
        return lottoTickets.size();
    }

    public List<Lotto> getLottoTickets(){
        return Collections.unmodifiableList(lottoTickets);
    }
}
