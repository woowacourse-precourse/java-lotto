package Domain;

import Controller.Validation;
import View.InputView;
import View.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoList {

    private int lottoPlayNumber;
    private final List<Lotto> lottoList;

    public LottoList(String BuyingLottoMoney){
        Validation.validateMoneyInput(BuyingLottoMoney);
        this.lottoPlayNumber = Integer.parseInt(BuyingLottoMoney) / 1000;
        lottoList = makeRandomLottoNumbers(lottoPlayNumber);
    }

    private List<Lotto> makeRandomLottoNumbers(int lottoPlayNumber){
        List<Lotto> lottoList = new ArrayList<>();
        for(int playLottoCount=0; playLottoCount<lottoPlayNumber; playLottoCount++){
            List<Integer> playLotto = pickUniqueNumbersInRange(1, 45, 6); //상수
            lottoList.add(new Lotto(playLotto));
        }
        return lottoList;
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public int getLottoPlayNumber(){
        return lottoPlayNumber;
    }
}
