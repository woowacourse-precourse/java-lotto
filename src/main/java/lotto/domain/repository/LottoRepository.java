package lotto.domain.repository;

import lotto.domain.Lotto;
import lotto.presentation.dto.WinnerNumber;

import java.util.List;

public class LottoRepository {
    private static final LottoRepository instance=new LottoRepository();
    private List<Lotto> purchasedLotto;
    private WinnerNumber winnerNumber;
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
    public void updateWinnerNumber(WinnerNumber winnerNumber){
        this.winnerNumber=winnerNumber;
    }
    public Integer getCountLotto(){
        return countLotto;
    }
    public WinnerNumber getWinnerNumber() {
        return winnerNumber;
    }
}
