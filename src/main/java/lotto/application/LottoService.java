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
    private static final int ONE=0;
    private static final int TWO=1;
    private static final int THREE=2;
    private static final int FOUR=3;
    private static final int FIVE=4;
    private static final int START_NUMBER=1;
    private static final int END_NUMBER=45;
    private static final int SIZE=6;
    private static final List<Integer> moneys=List.of(2000000000,30000000,1500000,50000,5000);
    private static final int SIX_CORRECT=6;
    private static final int FIVE_CORRECT=5;
    private static final int FOUR_CORRECT=4;
    private static final int THREE_CORRECT=3;
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
    public Double calculateYield(){
        WinStat winStat=lottoRepository.getWinStat();
        double profit=0;
        for(int i=0;i<moneys.size();i++){
            profit+=winStat.getWinStat().get(i)*moneys.get(i);
        }
        return (profit/lottoRepository.getPurchasedMoney())*100;
    }
    public void winStatistics(){
        WinStat winStat=new WinStat();
        for(Lotto lotto:lottoRepository.getPurchasedLotto()){
            calculateWinStat(winStat,matchNumber(lotto),checkBonusNumber(lotto));
        }
        lottoRepository.updateWinStat(winStat);
    }
    private void calculateWinStat(WinStat winStat,Integer matchNumber,Boolean bonusNumber){
        if(matchNumber==SIX_CORRECT){
            winStat.updateWinStat(ONE);
        }
        if(matchNumber==FIVE_CORRECT&&bonusNumber){
            winStat.updateWinStat(TWO);
        }
        if(matchNumber == FIVE_CORRECT){
            winStat.updateWinStat(THREE);
        }
        if(matchNumber==FOUR_CORRECT){
            winStat.updateWinStat(FOUR);
        }
        if(matchNumber==THREE_CORRECT){
            winStat.updateWinStat(FIVE);
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
        lottoRepository.updatePurchasedMoney(purchaseAmount.getAmount());
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
