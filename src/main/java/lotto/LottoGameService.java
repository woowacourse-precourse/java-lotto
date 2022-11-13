package lotto;

import java.util.Map;

public interface LottoGameService {
    void play();
    void getAllInputs();
    Map<Rank, Integer> makeResult();
    void printAllResults();

}
