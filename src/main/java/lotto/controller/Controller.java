package lotto.controller;

import lotto.console.InputConsole;
import lotto.console.OutputConsole;
import lotto.domain.CompareNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * UI로직과 비즈니스로직을 이어주는 클래스
 */
public class Controller {
    private InputConsole input = new InputConsole();
    private OutputConsole output = new OutputConsole();
    private LottoManager lottoManager = new LottoManager();
    private CompareNumber compareNumber;

    private Lotto lotto;
    private String inputMoney;

    public int findLottoCount() {
        inputMoney = input.Money();
        int lottoCount = lottoManager.countLotto(inputMoney);
        output.lottoCount(lottoCount);
        return lottoCount;
    }

    public List<List<Integer>> printBuyerLottoNumber(int lottoCount) {
        List<List<Integer>> randomNumbers = lottoManager.buyerLottoNumbers(lottoCount);
        output.randomNumbers(randomNumbers);
        return randomNumbers;
    }

    public List<Integer> checkWiningLottoNumber() throws IllegalArgumentException {
        String[] inputNumbers = input.Number().split(",");
        List<Integer> winningLottoNumber = Arrays.asList(inputNumbers)
                .stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        lotto = new Lotto(winningLottoNumber);
        return lotto.getNumbers();
    }

    public int checkBonusNumber(List<Integer> numbers) throws IllegalArgumentException {
        int bonusNumber = Integer.parseInt(input.bonusNum());
        lotto = new Lotto(numbers, bonusNumber);
        return bonusNumber;
    }

    public void compareNumber(List<List<Integer>> lottoNumber, List<Integer> winingNumber, int bonusNumber) {
        compareNumber = new CompareNumber(lottoNumber, winingNumber, bonusNumber);
        compareNumber.compareLotto();
        List<Integer> lottoResult = compareNumber.getLottoResult();
        output.lottoRank(lottoResult);
    }

    public void calculationYield() {
        float yield = compareNumber.calculationYield(inputMoney);
        output.yield(yield);
    }

    public void startLotto() {
        int lottoCount = findLottoCount();

        List<List<Integer>> randomNumbers = printBuyerLottoNumber(lottoCount);
        List<Integer> winingNumbers = checkWiningLottoNumber();
        int bonusNumber = checkBonusNumber(winingNumbers);

        compareNumber(randomNumbers, winingNumbers, bonusNumber);
        calculationYield();
    }

}
