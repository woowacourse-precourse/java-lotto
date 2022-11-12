package lotto.service;

import lotto.Lotto;
import lotto.repository.LottoRepository;
import lotto.util.InputValidator;
import lotto.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class LottoService {
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
}
