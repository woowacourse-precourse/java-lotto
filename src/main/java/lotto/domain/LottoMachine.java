package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMachine {

    public void drawLotto(){
        try {
            GenerateLottoRepository gr = printLottoPurchase();
            InputNumbers inputNumbers = inputLottoNumberAndBonusNumber();
            Lotto lotto = new Lotto(inputNumbers.lottoNumbers);
            printStatistics(gr.lottoRepository, lotto.numbers, inputNumbers.bonusNumber);

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private GenerateLottoRepository printLottoPurchase(){
        InputView.printAbleBuyMoney();
        UsedMoney usedMoney = new UsedMoney(Console.readLine());

        GenerateLottoRepository gr = new GenerateLottoRepository(usedMoney.getAbleCount());
        OutputView.printGenerateLottoRepository(usedMoney.getAbleCount(), gr.lottoRepository);

        return gr;
    }

    private InputNumbers inputLottoNumberAndBonusNumber(){
        String numbers = InputView.printLottoInput();
        String num = InputView.printBonusInput();
        return new InputNumbers(numbers, num);
    }

    private void printStatistics(List<List<Integer>> lottoRepository, List<Integer> numbers, Integer num){
        CalculateLotto calculateLotto = new CalculateLotto(lottoRepository, numbers, num);
        Float earning = calculateEarning(calculateLotto.ranking, lottoRepository.size());
        OutputView.printStatisticsMessage(calculateLotto.ranking, earning);
    }

    private Float calculateEarning(int[] ranking, int lottoTicket){
        return  100*((Grade.FIRST.getReward()*ranking[1])+
                (Grade.SECOND.getReward()*ranking[2])+
                (Grade.THIRD.getReward()*ranking[3])+
                (Grade.FOURTH.getReward()*ranking[4])+
                (Grade.FIFTH.getReward()*ranking[5]))/
                ((float) Math.max(1, lottoTicket) * 1000);
    }
}
