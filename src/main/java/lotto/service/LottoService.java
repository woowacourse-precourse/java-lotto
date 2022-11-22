package lotto.service;

import lotto.domain.*;
import lotto.comparator.LottoComparator;
import lotto.repository.LottoRepository;
import lotto.status.BoundaryStatus;
import lotto.status.NumberStatus;
import lotto.status.WinningStatus;
import lotto.validator.InputValidator;
import lotto.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LottoService {
    private static final LottoService lottoService = new LottoService();

    private LottoService() {
    }

    public static LottoService getInstance() {
        return lottoService;
    }

    public LottoRepository lottoRepository = LottoRepository.getInstance();

    public Money getTheNumberOfLotto(String purchaseMoney) {
        Money userMoney = InputValidator.checkUserInputMoney(purchaseMoney);
        saveUserMoney(userMoney);
        return userMoney;
    }

    private void saveUserMoney(Money userMoney) {
        lottoRepository.saveUserMoney(userMoney);
    }

    public List<Lotto> createUserLotto(Integer numberOfLotto) {
        List<Lotto> userLottoGroup = new ArrayList<>();
        for (int i = BoundaryStatus.START_NUMBER.getNumber(); i < numberOfLotto; i++) {
            Lotto userLottoPiece = RandomUtils.createRandomUserLotto();
            userLottoGroup.add(userLottoPiece);
        }
        saveUserLotto(userLottoGroup);
        return userLottoGroup;
    }

    private void saveUserLotto(List<Lotto> userLottoGroup) {
        lottoRepository.saveUserLotto(userLottoGroup);
    }

    public void createWinningLotto(String winningNumber) {
        InputValidator.checkWinningNumber(winningNumber);
        List<Integer> numbers = transferToNumbers(winningNumber);
        Lotto winningLotto = new Lotto(numbers);
        saveWinningLotto(winningLotto);
    }

    public List<Integer> transferToNumbers(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(",")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    private void saveWinningLotto(Lotto winningLotto) {
        lottoRepository.saveWinningLotto(winningLotto);
    }

    public void createBonusNumber(String userBonusNumber) {
        Lotto winningLotto = lottoRepository.getWinningLotto();
        BonusNumber bonusNumber = InputValidator.checkBonusNumber(userBonusNumber, winningLotto);
        saveBonusNumber(bonusNumber);
    }

    private void saveBonusNumber(BonusNumber bonusNumber) {
        lottoRepository.saveBonusNumber(bonusNumber);
    }

    public List<Integer> compareLotto() {
        List<Lotto> userLottoGroup = lottoRepository.getUserLottoGroup();
        Lotto winningLotto = lottoRepository.getWinningLotto();
        BonusNumber bonusNumber = lottoRepository.getBonusNumber();

        List<Integer> compareResult = LottoComparator.compareUserLottoAndWinningLotto(
                userLottoGroup, bonusNumber, winningLotto);

        saveWinningResult(compareResult);
        return compareResult;
    }

    private void saveWinningResult(List<Integer> winningResult) {
        lottoRepository.saveWinningResult(winningResult);
    }

    public String getProfit() {
        List<Integer> winningResult = lottoRepository.getWinningResult();
        Double purchaseMoney = Double.valueOf(lottoRepository.getUserMoney().getMoney());
        String totalProfit = calculateProfit(winningResult, purchaseMoney);
        return totalProfit;
    }

    public String calculateProfit(List<Integer> winningResult, Double purchaseMoney) {
        long totalPrice = NumberStatus.ZERO.getNumber();
        for (int i = BoundaryStatus.MIN_WINNING_COUNT.getNumber(); i < winningResult.size(); i++) {
            totalPrice += winningResult.get(i) * WinningStatus.find(i).getReward();
        }
        return String.format("%.1f", totalPrice / purchaseMoney * NumberStatus.PERCENT.getNumber());
    }
}
