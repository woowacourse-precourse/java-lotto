package lotto.Service;

import lotto.Model.Lotto;

import java.util.List;

public interface LottoService {

    void priceValidate(int price);
    void buyLottos();
    void generateLottos();
    List<Integer> generateRandomNum(int count);
    String printResult();
    String calcLottos(Lotto index);
}
