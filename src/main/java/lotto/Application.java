package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();
        lottoService.purchaseLottos();
        lottoService.printLottos();
        List<Integer> winningNumbers = lottoService.getWinningNumbers();
        List<Integer> scoreList = lottoService.compareWinnings(winningNumbers);
        List<Boolean> bonusList = lottoService.compareBonus();
        lottoService.printWinnings(scoreList, bonusList);
    }
}
