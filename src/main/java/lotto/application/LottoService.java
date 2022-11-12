package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.application.dto.WinStat;
import lotto.domain.Lotto;
import lotto.domain.repository.LottoRepository;
import lotto.presentation.dto.BonusNumber;
import lotto.presentation.dto.PurchaseAmount;
import lotto.presentation.dto.WinnerNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int ONE=6;
    private static final int TWO=5;
    private static final int THREE=5;
    private static final int FOUR=4;
    private static final int FIVE=3;
    private static final int START_NUMBER=1;
    private static final int END_NUMBER=45;
    private static final int SIZE=6;

    private static final LottoService instance = new LottoService();
    private static final int UNIT = 1000;
    private final LottoRepository lottoRepository;

    private LottoService() {
        lottoRepository=LottoRepository.getInstance();
    }
    public static LottoService getInstance() {
        return instance;
    }
    public void purchasedLotto() {
        List<Lotto> lottos=new ArrayList<>();
        for(int i=0;i<lottoRepository.getCountLotto();i++){
            Lotto lotto=new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, SIZE));
            lottos.add(lotto.sort());
        }
        lottoRepository.updatePurchasedLotto(lottos);
    }
    public WinStat winStatistics(){
        WinStat winStat=new WinStat();
        for(Lotto lotto:lottoRepository.getPurchasedLotto()){
            calculateWinStat(winStat,matchNumber(lotto),checkBonusNumber(lotto));
        }
        return winStat;
    }
    private void calculateWinStat(WinStat winStat,Integer matchNumber,Boolean bonusNumber){
        if(matchNumber==FIVE){
            winStat.updateFive();
        }
        if(matchNumber==FOUR){
            winStat.updateFour();
        }
        if(matchNumber==THREE&&!bonusNumber){
            winStat.updateThree();
        }
        if(matchNumber==TWO&&bonusNumber){
            winStat.updateTwo();
        }
        if(matchNumber==ONE){
            winStat.updateOne();
        }
    }
    private Integer matchNumber(Lotto lotto){
        int result=0;
        for(Integer number:lottoRepository.getWinnerNumber().getWinnerNumber()){
            if(lotto.getNumbers().contains(number)){
                result+=1;
            }
        }
        return result;
    }
    private Boolean checkBonusNumber(Lotto lotto){
        return lotto.getNumbers().contains(lottoRepository.getBonusNumber().getBonusNumber());
    }
    public void saveCountLotto(PurchaseAmount purchaseAmount){
        lottoRepository.updateCountLotto(countPurchasedLotto(purchaseAmount));
    }
    private Integer countPurchasedLotto(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getAmount() / UNIT;
    }
    public void saveWinnerNumber(WinnerNumber winnerNumber){
        lottoRepository.updateWinnerNumber(winnerNumber);
    }
    public void saveBonusNumber(BonusNumber bonusNumber){
        lottoRepository.updateBonusNumber(bonusNumber);
    }
}
