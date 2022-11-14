package view;

import domain.Rank;

import java.util.List;
import java.util.Map;

public interface PrintService {
    void printLotto(List<List<Integer>> lottoList);
    void printWinningResult(Map<Rank, Integer> result, double yield);
}
