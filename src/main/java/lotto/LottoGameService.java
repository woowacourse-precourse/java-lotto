package lotto;

import domain.Statistics;

import java.util.List;
import java.util.Map;

public interface LottoGameService {
    void play();
    void getAllInputs();
    List<List<Integer>> makeLottoList();
    Map<Statistics, Integer> makeResult();
    void printAllResults();

}