package lotto;

import InputOutput.Input;
import InputOutput.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Lotto lotto = new Lotto(input.getWinningNumberList());

        Print.buyLotto();
        int lottoCount= lotto.getLottoCount(input.getInputPrice());

        Print.lottoCount(lottoCount);

        LottoGenerator lottoGenerator = new LottoGenerator(lottoCount);
        List<List<Integer>> lottoNumbers = lottoGenerator.getlottoNumbers();
        Print.lottoNumber(lottoNumbers);

        Print.BonusNumber();
        int bonusNumber = input.getBonusNumber();

        Print.winningNumber();
        List<Integer> winningNumber =lotto.getLottoNumbers();






//        List<Integer> lotto = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
//        Print.lottoNumber(lotto);
    }
}
