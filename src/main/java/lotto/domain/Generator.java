package lotto.domain;

import java.util.List;

public interface Generator {
    
    String[] numberSeparator(String str);



    String generateLotto();

    String generateBonusLottoNumber();
}
