package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.repository.LottoRepository;
import lotto.presentation.dto.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int UNIT = 1000;
    private static final LottoService instance = new LottoService();
    private final LottoRepository lottoRepository;

    private LottoService() {
        lottoRepository=LottoRepository.getInstance();
    }

    public static LottoService getInstance() {
        return instance;
    }

    private Integer countPurchasedLotto(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getAmount() / UNIT;
    }
    public void saveCountLotto(PurchaseAmount purchaseAmount){
        lottoRepository.updateCountLotto(countPurchasedLotto(purchaseAmount));
    }

    public List<Lotto> buyLotto(Integer countLotto) {
        List<Lotto> lottos=new ArrayList<>();
        for(int i=0;i<countLotto;i++){
            Lotto lotto=new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto.sort());
        }
        return lottos;
    }
}
