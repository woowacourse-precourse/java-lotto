package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Calculate {

  public void drawLotto(){
    try {
      LotteryMachine lotteryMachine = messageLottoPurchase();
      InputNumbers inputNumbers = inputLottoNumberAndBonusNumber();
      Lotto lotto = new Lotto(inputNumbers.lottoNumbers);
      messageStatistics(lotteryMachine.lottoRepository, lotto.numbers, inputNumbers.bonusNumber);

    } catch (IllegalArgumentException e){
      System.out.println(e.getMessage());
    }
  }

  private LotteryMachine messageLottoPurchase(){
    InputMessage.messageAbleBuyMoney();
    InputMoney inputMoney = new InputMoney(Console.readLine());

    LotteryMachine lotteryMachine = new LotteryMachine(inputMoney.getAbleCount());
    OutputMessage.messageGenerateLottoRepository(inputMoney.getAbleCount(), lotteryMachine.lottoRepository);

    return lotteryMachine;
  }

  private InputNumbers inputLottoNumberAndBonusNumber(){
    String numbers = InputMessage.messageLottoInput();
    String num = InputMessage.messageBonusInput();
    return new InputNumbers(numbers, num);
  }

  private void messageStatistics(List<List<Integer>> lottoRepository, List<Integer> numbers, Integer num){
    Score calculateLotto = new Score(lottoRepository, numbers, num);
    Float earning = calculateEarning(calculateLotto.ranking, lottoRepository.size());
    OutputMessage.messageStatisticsMessage(calculateLotto.ranking, earning);
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