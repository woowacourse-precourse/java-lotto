package lotto.domain.repository;

import lotto.application.dto.WinStat;
import lotto.domain.Lotto;
import lotto.presentation.dto.BonusNumber;
import lotto.presentation.dto.WinnerNumber;

import java.util.List;

public class LottoRepository {
    private static final LottoRepository instance=new LottoRepository();
    private List<Lotto> purchasedLotto;
    private WinStat winStat;
    private WinnerNumber winnerNumber;
    private BonusNumber bonusNumber;
    private Integer purchasedMoney;
    private Integer countLotto;
    private LottoRepository(){}

    public static LottoRepository getInstance(){
        return instance;
    }
    public void updatePurchasedLotto(List<Lotto> purchasedLotto){
        this.purchasedLotto=purchasedLotto;
    }
    public void updateCountLotto(Integer countLotto){
        this.countLotto=countLotto;
    }
    public void updateWinnerNumber(WinnerNumber winnerNumber){
        this.winnerNumber=winnerNumber;
    }
    public void updateBonusNumber(BonusNumber bonusNumber){
        this.bonusNumber=bonusNumber;
    }
    public void updateWinStat(WinStat winStat){
        this.winStat=winStat;
    }
    public void updatePurchasedMoney(Integer purchasedMoney){
        this.purchasedMoney=purchasedMoney;
    }
    public List<Lotto> getPurchasedLotto(){
        return purchasedLotto;
    }
    public Integer getCountLotto(){
        return countLotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public WinStat getWinStat() {
        return winStat;
    }

    public Integer getPurchasedMoney() {
        return purchasedMoney;
    }
    public WinnerNumber getWinnerNumber() {
        return winnerNumber;
    }
}
