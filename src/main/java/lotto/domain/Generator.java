package lotto.domain;

import java.util.List;

public interface Generator {
    
    String[] numberSeparator(String str);


    int generateMoney();

    String generateLotto();

    String generateBonusLottoNumber();
}
