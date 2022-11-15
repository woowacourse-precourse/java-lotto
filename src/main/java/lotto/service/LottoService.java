package lotto.service;

import static lotto.util.Printer.printMessage;
import static lotto.util.Printer.printPurchaseLottosInfo;
import static lotto.util.Printer.printResult;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.repository.RankRepository;

public class LottoService {

    Player player;
    WinningLotto winningLotto;

    public void play() {
        printPurchaseGuideMessage();
        player = Player.purchase();
        printPurchaseLottosInfo(player.getPurchaseLottos());
        winningLotto = inputWinningLotto();
        List<Rank> lottoResults = getResult();
        printResult(lottoResults, player.getPurchasePrice());
    }

    private static void printPurchaseGuideMessage() {
        printMessage("구입금액을 입력해 주세요.");
    }

    private List<Rank> getResult() {
        List<Rank> lottoResults = new ArrayList<>();
        for (Lotto playerPurchaseLotto : player.getPurchaseLottos()) {
            RankRepository.getRank(playerPurchaseLotto, winningLotto)
                    .ifPresent(lottoResults::add);
        }
        return lottoResults;
    }

    WinningLotto inputWinningLotto() {
        printInputWinningLottoGuideMessage();
        Lotto lotto = getWinningLotto();
        printInputBonusNumberGuideMessage();
        int bonusNumber = inputBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }

    private static void printInputWinningLottoGuideMessage() {
        printMessage("당첨 번호를 입력해 주세요.");
    }

    private static void printInputBonusNumberGuideMessage() {
        printMessage("보너스 번호를 입력해 주세요.");
    }

    private Lotto getWinningLotto() {
        List<Integer> winningLottoNumbers = inputWinningLottoNumbers();
        return new Lotto(winningLottoNumbers);
    }

    private List<Integer> inputWinningLottoNumbers() {
        String playerInput = Console.readLine();
        String[] inputNumbers = playerInput.split(",");
        try {
            return Arrays.stream(inputNumbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 반드시 숫자여야 합니다.", e);
        }
    }

    private int inputBonusNumber() {
        String playerInput = Console.readLine();
        try {
            return Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 반드시 숫자여야 합니다.", e);
        }
    }
}
