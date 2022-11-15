package Domain;

import Controller.Constant;
import Controller.Validation;
import java.util.ArrayList;

import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoList {
    private int availableLottoPlayNumber;
    private final List<Lotto> lottoList;

    public LottoList(String readMoneyValue){
        Validation.validateMoneyInput(readMoneyValue);
        this.availableLottoPlayNumber = Integer.parseInt(readMoneyValue) / Constant.LOTTO_PRICE;
        lottoList = makeRandomLottoNumbers(availableLottoPlayNumber);
    }

    private List<Lotto> makeRandomLottoNumbers(int availableLottoPlayNumber){
        List<Lotto> lottoList = new ArrayList<>();
        for(int playLottoCount=0; playLottoCount<availableLottoPlayNumber; playLottoCount++){
            List<Integer> playLottoOnce = pickUniqueNumbersInRange(Constant.LOTTO_NUMBER_RANGE_START, Constant.LOTTO_NUMBER_RANGE_END, Constant.LOTTO_LENGTH);
            lottoList.add(new Lotto(playLottoOnce));
        }
        return lottoList;
    }

    public int getAvailableLottoPlayNumber(){
        return availableLottoPlayNumber;
    }
    public List<Lotto> getLottoList(){
        return lottoList;
    }
}
