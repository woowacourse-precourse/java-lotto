package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private List<Lotto> lottoList = new ArrayList<>();
    private List<Rank> ranks = new ArrayList<>();

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void saveLottoNumber(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public void saveLottoResult(Rank rank) {
        ranks.add(rank);
    }
}
