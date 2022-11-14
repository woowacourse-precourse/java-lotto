package lotto;

import domain.Rank;

import java.util.List;
import java.util.Map;

public interface LottoGameService {
    void play();
    void getAllInputs();
    List<List<Integer>> makeLottoList();
    Map<Rank, Integer> makeResult();
    void printAllResults();

}
