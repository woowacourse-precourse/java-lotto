package lotto.service;

import lotto.Lotto;
import lotto.comparator.LottoComparator;
import lotto.repository.LottoRepository;
import lotto.validator.InputValidator;
import lotto.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LottoService {

    public static Integer getTheNumberOfLotto(String purchaseMoney) {
        InputValidator.checkUserInputMoney(purchaseMoney);
        savePurchaseMoney(purchaseMoney);
        return Integer.parseInt(purchaseMoney) / 1000;
    }

    private static void savePurchaseMoney(String purchaseMoney) {
        LottoRepository.savePurchaseMoney(purchaseMoney);
    }

    public List<Lotto> createUserLotto(Integer numberOfLotto) {
        List<Lotto> userLottoGroup = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto userLottoPiece = RandomUtils.createRandomUserLotto();
            userLottoGroup.add(userLottoPiece);
        }
        saveUserLotto(userLottoGroup);
        return userLottoGroup;
    }

    private void saveUserLotto(List<Lotto> userLottoGroup) {
        LottoRepository.saveUserLotto(userLottoGroup);
    }

    public void createWinningLotto(String winningNumber) {
        InputValidator.checkWinningNumber(winningNumber);
        Lotto winningLotto = new Lotto(Arrays.asList(winningNumber.split(",")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList()));
        saveWinningLotto(winningLotto);
    }

    private void saveWinningLotto(Lotto winningLotto) {
        LottoRepository.saveWinningLotto(winningLotto);
    }

    public void createBonusNumber(String bonusNumber) {
        InputValidator.checkBonusNumber(bonusNumber);
        saveBonusNumber(Integer.parseInt(bonusNumber));
    }

    private void saveBonusNumber(int bonusNumber) {
        LottoRepository.saveBonusNumber(bonusNumber);
    }

    public List<Integer> compareLotto() {
        List<Lotto> userLottoGroup = LottoRepository.getLastUserLottoGroup();
        Lotto winningLotto = LottoRepository.getLastWinningLotto();
        Integer bonusNumber = LottoRepository.getBonusNumber();
        List<Integer> winningResult = LottoComparator.compareUserLottoAndWinningLotto(
                userLottoGroup,bonusNumber,winningLotto);

        saveWinningResult(winningResult);
        return winningResult;
    }

    private void saveWinningResult(List<Integer> winningResult) {
        LottoRepository.saveWinningResult(winningResult);
    }

    public String getProfit() {
        List<Integer> winningResult = LottoRepository.getWinningResult();
        Double purchaseMoney = Double.valueOf(LottoRepository.getPurchaseMoney());

        Long totalPrice = 0L;
//        for (int i = 0 ; i < winningMoney.size(); i ++){
//            totalPrice += winningMoney.get(i) * winningResult.get(i);
//        }
        return String.format("%.1f", totalPrice/purchaseMoney*100);
    }
}
