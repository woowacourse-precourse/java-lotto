package lotto.service;

import lotto.Lotto;
import lotto.repository.LottoRepository;
import lotto.validator.InputValidator;
import lotto.utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class LottoService {

    public Integer luckyCount;
    public Integer secondaryCount;

    public static Integer getTheNumberOfLotto(String userInputMoney) {
        InputValidator.checkUserInputMoney(userInputMoney);
        return Integer.parseInt(userInputMoney) / 1000;
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
        Lotto winningLotto = new Lotto(asList(winningNumber.split(",")).stream()
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

    public Map<Integer, Integer> compareLotto() {
        List<Lotto> userLottoGroup = LottoRepository.getLastUserLottoGroup();
        Lotto winningLotto = LottoRepository.getLastWinningLotto();
        Integer bonusNumber = LottoRepository.getBonusNumber();
        Map<Integer, Integer> resultCount = new HashMap<>();

        for (Lotto userLotto : userLottoGroup) {
            initCount();
            Integer luckyCount = compareUserAndWinning(userLotto, winningLotto, bonusNumber);
            createWinningResult(resultCount, luckyCount);
        }
        return resultCount;
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

    private void createWinningResult(Map<Integer, Integer> resultCount, Integer luckyCount) {
        if (luckyCount >= 3) {
            resultCount.put(luckyCount, resultCount.getOrDefault(luckyCount, 0) + 1);
        }
    }
}
