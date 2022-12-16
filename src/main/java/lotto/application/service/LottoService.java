package lotto.application.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.application.port.in.*;
import lotto.application.port.in.dto.RequestBuyLottoDto;
import lotto.application.port.in.dto.RequestMatchDto;
import lotto.application.port.in.dto.ResponseBuyLottoDto;
import lotto.application.port.in.dto.ResponseMatchDto;
import lotto.domain.*;
import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.result.Result;
import lotto.domain.result.ResultTable;
import lotto.domain.reward.Reward;
import lotto.domain.reward.RewardTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LottoService implements LottoServiceUseCase {

    @Override
    public Lotto ConvertLotto(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        String[] split = inputNumbers.split(",");

        for (String splitValue : split) {
            numbers.add(Integer.parseInt(splitValue));
        }
        return new Lotto(numbers);
    }

    @Override
    public ResponseMatchDto matchWinningNumber(RequestMatchDto requestMatchDto) {
        //비교하여 Result 객체로 리턴.
        List<Lotto> lottos = requestMatchDto.getLottoTickets().getLottos();
        int numberOfLottos = getNumberOfLottos(lottos);
        WinningLotto winningLotto = new WinningLotto(
                requestMatchDto.getWinningLotto(), requestMatchDto.getBonus());

        ResultTable resultTable = createResultTable(winningLotto, lottos);
        RewardTable rewardTable = createRewardTable(resultTable);

        return new ResponseMatchDto(rewardTable);
    }

    @Override
    public ResponseBuyLottoDto buyLotto(RequestBuyLottoDto requestBuyLottoDto) {
        List<Lotto> lottos = new ArrayList<>();
        Money money = new Money(requestBuyLottoDto.convertToInteger());
        int lottoCount = money.exchangeLotto();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto());
        }
        return new ResponseBuyLottoDto(lottos);
    }

    private RewardTable createRewardTable(ResultTable resultTable) {
        List<Reward> rewards = getRewards(resultTable.getResults());
        return new RewardTable(rewards);
    }

    private List<Reward> getRewards(List<Result> results) {
        List<Reward> rewards = new ArrayList<>();
        for (Result result : results) {
            Optional<Reward> optionalReward = result.matchReward();
            if (optionalReward.isPresent()) {
                rewards.add(optionalReward.get());
            }
        }
        return rewards;
    }

    private int getNumberOfLottos(List<Lotto> lottos) {
        return lottos.size();
    }

    private ResultTable createResultTable(WinningLotto winningLotto, List<Lotto> lottos) {
        List<Result> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            results.add(matchLottoNumbers(winningLotto, lotto));
        }
        return new ResultTable(results);
    }

    private Result matchLottoNumbers(WinningLotto winningLotto, Lotto lotto) {
        long matchedNumbers = getMatchedNumbers(winningLotto.getLotto().getNumbers(), lotto);
        boolean isMatchedBonus = isMatchedBonus(winningLotto.getBonus(), lotto);

        return new Result(matchedNumbers, isMatchedBonus);
    }

    private long getMatchedNumbers(List<Integer> winningNumbers, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return winningNumbers.stream().filter(answer -> lottoNumbers.contains(answer)).count();
    }

    private boolean isMatchedBonus(Bonus bonus, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(bonus.getNumber());
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}