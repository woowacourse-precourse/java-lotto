package view;

import domain.Statistics;

import java.util.List;
import java.util.Map;

public interface PrintService {
    void printLotto(List<List<Integer>> lottoList);
    void printWinningResult(Map<Statistics, Integer> result, double yield);
}