package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.LottoData;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    LottoData lottoData = new LottoData();
    OutputView output = new OutputView();

    private void setLottoCount(){
        output.askPurchasePrice();
        lottoData.setCountOfLotto(Integer.parseInt(readLine()));
    }

    private void makeLottoNumber(){
        List<Lotto> lottos = new ArrayList<Lotto>();
        for(int i = 0; i < lottoData.getCountOfLotto(); i++){
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumber);
            lottos.add(lotto);
        }
        lottoData.setLottos(lottos);
    }

    private void printLottoNumber(){
        List<Lotto> lottos = lottoData.getLottos();
        List<List<Integer>> lottoNumber = new ArrayList<List<Integer>>();
        for(Lotto lotto : lottos){
            lottoNumber.add(lotto.getLottoNumber());
        }
        output.showPurchasedLotto(lottoData.getCountOfLotto(), lottoNumber);
    }

    private void inputWinnerNumber(){
        output.askWinnerNumber();
        List<Integer> winnerNumber = Arrays.stream(readLine().split(","))
                                            .mapToInt(Integer::parseInt)
                                            .boxed()
                                            .collect(Collectors.toList());
        Lotto winnerNumberLotto = new Lotto(winnerNumber);
        lottoData.setWinnerNumber(winnerNumberLotto);
    }

    private void inputBonusNumber(){
        output.askBonusNumber();
        int bonusNumber = Integer.parseInt(readLine());
        lottoData.setBonusNumber(bonusNumber);
    }

    private int compareWinnerNumber(Lotto userNumberLotto, Lotto winnerNumberLotto){
        List<Integer> userNumber = userNumberLotto.getLottoNumber();
        List<Integer> winnerNumber = winnerNumberLotto.getLottoNumber();
        int matchedNumber = 0;
        for(int number : winnerNumber){
            if(userNumber.contains(winnerNumber)){
                matchedNumber += 1;
            }
        }
        return matchedNumber;
    }

    private boolean isContainsBonusNumber(Lotto userNumberLotto, int bonusNumber){
        List<Integer> userNumber = userNumberLotto.getLottoNumber();
        return userNumber.contains(bonusNumber);
    }
}