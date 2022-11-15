package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.lotto.Lotto;
import domain.lotto.LottoRepository;
import domain.lotto.Rank;
import domain.user.Number;
import model.Model;
import view.View;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private LottoRepository lottoRepository;

    public LottoController(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void createIssuanceLottoNumbers() {

        View.printCount();
        Model model = Model.getInstance();
        int count = model.getUser().getCount();

        for (int i = 0; i < count; i++) {
            lottoRepository.saveLottoNumber(new Lotto(createLottoNumber()));
        }

        model.setLottoRepository(lottoRepository);
        View.printIssuanceLottoNumbers();
    }

    public void calculate() {

        calculateRank();
        calculateYield();
        View.printLottoResult();
    }

    public void calculateRank() {

        Model model = Model.getInstance();
        List<Lotto> lottoList = lottoRepository.getLottoList();
        Number number = model.getUser().getNumber();

        for (Lotto lotto : lottoList) {

            Rank rank = Rank.findRank(calculateNumberOfMatch(number.getWinningNumber(), lotto.getNumbers())
                    , isBonusNumberContain(number.getWinningNumber(), number.getBonusNumber()));
            lottoRepository.saveLottoResult(rank);
            rank.plusCount();
        }

        model.setLottoRepository(lottoRepository);
    }

    public void calculateYield() {

        Model model = Model.getInstance();
        int yield = 0;

        List<Rank> ranks = lottoRepository.getRanks();

        for (Rank rank : ranks) {
            yield += rank.getReward();
        }

        model.setYield(yield);
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted().collect(Collectors.toList());
    }

    private int calculateNumberOfMatch(List<Integer> winningNumber, List<Integer> lottoNumber) {
        int count = 0;

        for (Integer n : winningNumber) {
            if (lottoNumber.contains(n)) {
                count++;
            }
        }

        return count;
    }

    private boolean isBonusNumberContain(List<Integer> winningNumber, int bonusNumber) {
        return winningNumber.contains(bonusNumber);
    }
}
