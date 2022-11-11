package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    
    private final int MONEY_UNIT = 1000;

    LottoCompany lottoCompany = new LottoCompany();
    Printer printer = new Printer();
    Map<Integer, LottoNumber> lottoNumberMap = new LottoNumberGenerater().makeLottoNumberMap();


    private Lotto makeRandomNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        List<Integer> idxNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(idxNumbers);
        for (int number = 0; number < idxNumbers.size(); number++) {
            lottoNumbers.add(lottoNumberMap.get(idxNumbers.get(number)));
        }
        return new Lotto(lottoNumbers);
    }

    public void makeLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int sheets = money / MONEY_UNIT;
        for (int times = 0; times < sheets; times++) {
            Lotto lotto = makeRandomNumbers();
            lottos.add(lotto);
        }
        Lottos allLottos = new Lottos(lottos);
        printer.printLottoNumbers(allLottos);
        lottoCompany.winningNumbers(allLottos);
    }

}
