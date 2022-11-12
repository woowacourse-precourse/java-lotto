package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottoList = lottoGenerator.createLottoNumbers(1001);
        for(Lotto l : lottoList) {
            l.printSortedNumbers();
        }
    }
}
