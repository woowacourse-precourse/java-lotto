package lotto;

import lotto.domain.Computer;
import lotto.domain.LottoProcess;
import lotto.domain.User;

import java.util.List;

public class LottoController {
    public void start(){
        User user = new User();
        Computer computer = new Computer();

        List<List<Integer>> lottos;
        List<Integer> ranks;

        user.inputMoney();
        lottos = computer.createLottos(user.getMoney());
        computer.printLottos(lottos);
        user.inputWinningNumbers();
        user.inputBonusNumber();

        LottoProcess lottoProcess = new LottoProcess(lottos, user.getWinningNumbers(), user.getBonusNumber(), user.getMoney());
        ranks = lottoProcess.decideRanks(lottos, user.getWinningNumbers());
        lottoProcess.printStatistics(lottoProcess.countRanks(ranks));
        lottoProcess.calculateRateOfReturn(lottoProcess.countRanks(ranks));
    }
}
