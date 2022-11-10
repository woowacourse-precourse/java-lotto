package lotto.Service;

import java.util.List;

public interface LottoService {

    void priceValidate(int price);
    void buyLottos(int price);
    void generateLottos();

    List<Integer> generateRandomNum(int count);

}
