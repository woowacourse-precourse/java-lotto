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

        int lottoCount= lotto.getLottoCount(input.getInputPrice());
        Print.lottoCount(lottoCount);

        LottoGenerator lottoGenerator = new LottoGenerator(lottoCount);
        List<List<Integer>> lottoNumbers = lottoGenerator.getlottoNumbers();
        Print.lottoNumber(lottoNumbers);


        int bonusNumber = input.getBonusNumber();


        List<Integer> winningNumber =lotto.getLottoNumbers();
        List<Integer> winningList = new ArrayList<>();

        for(int i = 0; i < lottoNumbers.size(); i++){
            Computer computer =new Computer(winningNumber, lottoNumbers.get(i));
            winningList.add(computer.getOverlapedCount());
        }








//        List<Integer> lotto = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
//        Print.lottoNumber(lotto);
    }
}
