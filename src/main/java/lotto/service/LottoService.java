package lotto.service;

import lotto.Lotto;
import lotto.repository.LottoRepository;
import lotto.validator.InputValidator;
import lotto.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LottoService {

    public Integer luckyCount;
    public Integer secondaryCount;

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
        List<Integer> winningResult = Arrays.asList(0,0,0,0,0);

        for (Lotto userLotto : userLottoGroup) {
            initCount();
            Integer luckyCount = compareUserAndWinning(userLotto, winningLotto, bonusNumber);
            createWinningResult(winningResult, luckyCount);
        }
        saveWinningResult(winningResult);
        return winningResult;
    }

    private void saveWinningResult(List<Integer> winningResult) {
        LottoRepository.saveWinningResult(winningResult);
    }

    private void initCount() {
        luckyCount = 0;
        secondaryCount = 0;
    }

    private Integer compareUserAndWinning(Lotto userLotto, Lotto winningLotto, Integer BonusNumber) {
        for (Integer userLottoNumber : userLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(userLottoNumber)) {
                luckyCount++;
            }
            if (userLottoNumber == BonusNumber) {
                secondaryCount++;
            }
        }
        if (secondaryCount == 1 && luckyCount == 5) {
            return 7;
        }
        return luckyCount;
    }

    private void createWinningResult(List<Integer> resultCount, Integer luckyCount) {
        if (luckyCount >= 3) {
            resultCount.set(luckyCount-3,resultCount.get(luckyCount-3)+1);
        }
    }

    public List<String> getWinningAmount() {
        return LottoRepository.getWinningAmount();
    }


    public String getProfit() {
        List<Integer> winningResult = LottoRepository.getWinningResult();
        List<String> winningMoney = LottoRepository.getWinningAmount();
        Double purchaseMoney = Double.valueOf(LottoRepository.getPurchaseMoney());

        Integer totalPrice = 0;
        for (int i = 0 ; i < winningMoney.size(); i ++){
            totalPrice += Integer.parseInt(winningMoney.get(i)) * winningResult.get(i);
        }
        return String.format("%.1f", totalPrice/purchaseMoney*100);
    }
}
