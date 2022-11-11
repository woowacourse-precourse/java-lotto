package lotto.domain.repository;

import lotto.domain.Lotto;
import java.util.List;

public class LottoRepository {
    private static final LottoRepository instance=new LottoRepository();
    private List<Lotto> purchasedLotto;
    private Integer countLotto;
    private LottoRepository(){}

    public static LottoRepository getInstance(){
        return instance;
    }
    public void updatePurchasedLotto(List<Lotto> purchasedLotto){
        this.purchasedLotto=purchasedLotto;
    }
    public List<Lotto> getPurchasedLotto(){
        return purchasedLotto;
    }
    public void updateCountLotto(Integer countLotto){
        this.countLotto=countLotto;
    }
    public Integer getCountLotto(){
        return countLotto;
    }
}
