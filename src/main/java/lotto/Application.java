package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        String amount = Console.readLine();
        List<Lotto> lottoList = lottoGenerator.createLottoNumbers(amount);

    }
}
