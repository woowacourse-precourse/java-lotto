package lotto.application.output.lottoprinter;

import java.util.Arrays;
import java.util.List;

public class LottoPrinterImpl implements LottoPrinter {

    @Override
    public void showGeneratedLottoNumber(List<List<Integer>> generatedLottoNumber) {
        for (List<Integer> eachLottoPaper : generatedLottoNumber) {
            System.out.println(Arrays.toString(Arrays.stream(eachLottoPaper.toArray()).sorted().toArray()));
        }
    }
}
