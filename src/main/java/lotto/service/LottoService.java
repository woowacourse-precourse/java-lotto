package lotto.service;

import lotto.Lotto;
import lotto.repository.LottoRepository;
import lotto.util.Validator;
import lotto.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public static Integer getTheNumberOfLotto(String userInputMoney) {
        Validator.checkUserInputMoney(userInputMoney);
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
}
