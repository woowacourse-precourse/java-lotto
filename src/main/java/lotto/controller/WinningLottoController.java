package lotto.controller;

import lotto.console.Output;
import lotto.console.Input;
import lotto.domain.Lotto;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.console.Output.*;
import static lotto.service.Calculator.*;

public class WinningLottoController {

    static final List<Integer> key = List.of(3,4,5,-1,6);

    static final Map<Integer, Integer> statistic = new HashMap<>();

    static {
        statistic.put(3, 0);
        statistic.put(4, 0);
        statistic.put(5, 0);
        statistic.put(-1, 0);
        statistic.put(6, 0);
    }

    Map<Integer, Integer> revenueTable = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            -1, 30000000,
            6, 2000000000
    );

    public List<Integer> createWinningLotto() throws IOException {
        Output.printWhenInputWinningNumber();
        List<Integer> winningLotto = Input.inputWinningNumbers();
        return winningLotto;
    }

    public int addBonusNumber(List<Integer> winningLotto) throws IOException {
        getBufferedRecorder().writeNewLine();
        Output.printWhenInputBonusNumber();

        int bonusNumber = Input.inputBonusNumber();

        if(winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[Error] 이 보너스 번호는 유효하지 않습니다.");
        }

        return bonusNumber;
    }

    public void circuitLotto(List<Lotto> lottoList, List<Integer> winningLotto, int bonusNumber) {
        lottoList.stream()
                .map(Lotto::getLotto)
                .forEach(x -> updateStatistic(x, winningLotto, bonusNumber));
    }

    public void updateStatistic(List<Integer> lottoList, List<Integer> winningLotto, int bonusNumber) {
        int tmp = countIntersection(lottoList, winningLotto);
        if(statistic.containsKey(tmp)) {
            if(tmp==5 && lottoList.contains(bonusNumber)) {
                statistic.replace(-1, statistic.get(-1) + 1);
                return;
            }
            statistic.replace(tmp, statistic.get(tmp) + 1);
        }
    }

    public void writeStatistics() throws IOException {
        getBufferedRecorder().writeNewLine();
        getBufferedRecorder().writeStatistics();
        for(int i: key) {
            if(i==-1) {
                getBufferedRecorder().writeGradingWithBonusNumber(statistic.get(i));
                continue;
            }
            getBufferedRecorder().writeGrading(i, statistic.get(i));
        }
    }

    public void writeTotalRevenue(int cost) throws IOException {
        int totalRevenue = 0;
        for(int i: key) {
            totalRevenue += statistic.get(i) * revenueTable.get(i);
        }
        getBufferedRecorder().writeRevenueRate(calculateRevenueRate(totalRevenue, cost));
    }

    public void runWinningLottoController(List<Lotto> lottoList) throws IOException {
        List<Integer> winningLotto = createWinningLotto();
        int bonusNumber = addBonusNumber(winningLotto);

        circuitLotto(lottoList, winningLotto, bonusNumber);

        writeStatistics();
        writeTotalRevenue(getCost());
        printBufferedStream();
    }
}
