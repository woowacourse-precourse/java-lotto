package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoList {
    tatic final int LOTTO_PRICE = 1000;

    private int lottoPlayNumber;
    private List<Lotto> lottoList;

    public LottoList(){
        InputView.printBuyingLottoMessage();
        lottoPlayNumber = getLottoPlayNumber();
        lottoList = makeRandomLottoNumbers(lottoPlayNumber);
        OutputView.printNumberOfLotto(lottoPlayNumber, lottoList);
    }

    private int getLottoPlayNumber(){
        String readMoneyValue = InputView.readInputLine();
        Validation.validateMoneyInput(readMoneyValue);
        int money = Integer.parseInt(readMoneyValue);
        return money / LOTTO_PRICE;
    }

    private List<Lotto> makeRandomLottoNumbers(int lottoPlayNumber){
        List<Lotto> lottoList = new ArrayList<>();
        for(int playLottoCount=0; playLottoCount<lottoPlayNumber; playLottoCount++){
            List<Integer> playLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(playLotto);
            lottoList.add(new Lotto(playLotto));
        }
        return lottoList;
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }
}
