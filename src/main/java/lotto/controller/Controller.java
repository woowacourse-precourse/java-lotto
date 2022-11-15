package lotto.controller;

import lotto.console.InputConsole;
import lotto.console.OutputConsole;
import lotto.domain.CompareNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private InputConsole input = new InputConsole();
    private OutputConsole output = new OutputConsole();
    private LottoManager lottoManager = new LottoManager();

    private Lotto lotto;

    public int findLottoCount() {
        String inputMoney = input.Money();
        int lottoCount = lottoManager.countLotto(inputMoney);
        output.lottoCount(lottoCount);
        return lottoCount;
    }

    public List<List<Integer>> makeRandomNum(int lottoCount) {
        List<List<Integer>> randomNumbers = lottoManager.makeRandomNumbers(lottoCount);
        output.randomNumbers(randomNumbers);
        return randomNumbers;
    }

    public List<Integer> winingNumber() throws IllegalArgumentException{
        String[] inputNumbers = input.Number().split(",");
        List<Integer> winningLottoNumber = Arrays.asList(inputNumbers)
                .stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        lotto = new Lotto(winningLottoNumber);
        return lotto.getNumbers();
    }

    public int bonusNumber(List<Integer> numbers) throws IllegalArgumentException{
        int bonusNumber = Integer.parseInt(input.bonusNum());
        lotto = new Lotto(numbers, bonusNumber);
        return bonusNumber;
    }

    public void compareNumber(List<List<Integer>> lottoNumber, List<Integer> winingNumber, int bonusNumber){
        CompareNumber compareNumber = new CompareNumber(lottoNumber, winingNumber, bonusNumber);
        compareNumber.compareLotto();
        List<Integer> lottoResult = compareNumber.getLottoResult();
//        output.lottoRank(lottoResult);
        System.out.println(lottoResult);
    }

}
