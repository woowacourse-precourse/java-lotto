package lotto.domain;

import java.util.List;

public interface Generator {
    
    String[] numberSeparator(String str);

    List<Integer> lottoNumbersGenerator();
}
