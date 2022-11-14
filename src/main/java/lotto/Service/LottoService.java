package lotto.Service;

import lotto.Model.Lotto;

import java.util.List;

public interface LottoService {

    void buyLottos();
    void generateLottos();
    List<Integer> generateRandomNum(int count);
    void printResult();
    void calcLottos(Lotto index);
    boolean isPlay();
}
