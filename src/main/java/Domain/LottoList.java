package Domain;

import Controller.Validation;
import View.InputView;
import View.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoList {
    static final int LOTTO_PRICE = 1000;

    private int lottoPlayNumber;
    private List<Lotto> lottoList;

    public LottoList(){
        InputView.printBuyingLottoMessage();
        lottoPlayNumber = setLottoPlayNumber();
        lottoList = makeRandomLottoNumbers(lottoPlayNumber);
        OutputView.printNumberOfLotto(lottoPlayNumber, lottoList);
    }

    private int setLottoPlayNumber(){
        String readMoneyValue = InputView.readInputLine();
        Validation.validateMoneyInput(readMoneyValue);
        int money = Integer.parseInt(readMoneyValue);
        return money / LOTTO_PRICE;
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
