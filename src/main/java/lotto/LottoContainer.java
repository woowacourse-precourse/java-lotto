package lotto;

import com.sun.jdi.ArrayReference;
import io.Output;
import java.util.ArrayList;
import java.util.List;

public class LottoContainer {
    private final List<Lotto> lottoBundle;
    private static Output output;

    public LottoContainer(List<Lotto> lottoBundle) {
        validate(lottoBundle);
        this.lottoBundle = lottoBundle;
    }

    private void validate(List<Lotto> lottoBundle) {

    }

    public void printLottoBundles(Output output) {
        LottoContainer.output = output;
        for (Lotto lotto : lottoBundle) {
            lotto.printLottoDigits(output);
        }
    }

    public List<Integer> getAnswerCompareResult(Lotto answer) {
        List<Integer> returnResult = new ArrayList<>();

        System.out.println("!!!!" + lottoBundle.size());
        for (int i = 0; i < lottoBundle.size(); i++) {
            returnResult.add(LottoCalculator.getCountOfSameNumber(lottoBundle.get(i), answer));
        }
//        lottoBundle.get(0).printLottoDigits(output);
//
//        answer.printLottoDigits(output);
//
        return returnResult;
    }

    public List<Integer> getBonusCompareResult(Lotto bonus) {
        List<Integer> returnResult2 = new ArrayList<>();

        for (int i = 0; i < lottoBundle.size(); i++) {
            returnResult2.add(LottoCalculator.getCountOfSameNumber(lottoBundle.get(i), bonus));
        }
        bonus.printLottoDigits(output);
        return returnResult2;
    }

}


/* list <> [6] 자리를 감싸고 있는 일급 컬랙션 Lotto 들의 리스트를 감싸는 일급 컬렉션   */

/*
Lotto -> (private final List<Integer> numbers)를 감쌈
LottoContainer -> (private final ArrayList<Lotto> lottoPack ) 를 감싼다.

 */