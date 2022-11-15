package lotto.application.output.lottoprinter;

import java.util.Arrays;
import java.util.List;

public class LottoPrinterImpl implements LottoPrinter {

    @Override
    public void showGeneratedLottoNumber(List<List<Integer>> generatedLottoNumber) {
        for (List<Integer> eachLottoNumber : generatedLottoNumber) {
            System.out.println(Arrays.toString(Arrays.stream(eachLottoNumber.toArray()).sorted().toArray()));
        }
    }
}
