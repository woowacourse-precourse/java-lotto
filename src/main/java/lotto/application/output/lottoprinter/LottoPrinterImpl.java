package lotto.application.output.lottoprinter;

import lotto.domain.Lotto;

import java.util.List;

public class LottoPrinterImpl implements LottoPrinter {

    @Override
    public void showGeneratedLottoNumber(List<Lotto> generatedLottoNumber) {
        for (Lotto lotto : generatedLottoNumber) {
            System.out.println(lotto.getNumbers());
        }
    }
}
