package lotto.domain;

import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNum;
import lotto.domain.model.WinningNumber;
import lotto.dto.LottoDto;
import lotto.dto.StatisticsDto;
import lotto.view.*;

import java.util.List;

public class LottoGame {

  private RateOfReturnView rateOfReturnView;
  private StatisticsView statisticsView;
  private LottoFactory lottoFactory;
  private InputView inputView;
  private MyLottosView myLottosView;
  private StatisticsExtractor statisticsExtractor;
  private RateOfReturnCalculator rateOfReturnCalculator;

  public LottoGame(){
    inputView = new InputView();
    myLottosView = new MyLottosView();
    rateOfReturnView = new RateOfReturnView();
    statisticsView = new StatisticsView();
    lottoFactory = new LottoFactory();
    statisticsExtractor = new StatisticsExtractor();
    rateOfReturnCalculator = new RateOfReturnCalculator();
  }

  public void run(){
    LottoNum lottoNum = inputView.readPurchaseAmount();
    List<Lotto> lottos = lottoFactory.makeLottos(lottoNum);
    myLottosView.print(lottos);
    WinningNumber winningNumber = inputView.readWinningNumber();
    BonusNumber bonusNumber = inputView.readBonusNumber(winningNumber);
    StatisticsDto statistics = statisticsExtractor.extract(new LottoDto(lottos, winningNumber, bonusNumber));
    statisticsView.print(statistics);
    rateOfReturnView.print(rateOfReturnCalculator.calculate(statistics, lottoNum));
  }

}