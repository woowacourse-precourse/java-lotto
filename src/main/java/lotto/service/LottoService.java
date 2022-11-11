package lotto.service;

import static lotto.domain.Lotto.END_LOTTO_NUMBER;
import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;
import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.domain.Lotto.START_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.repository.RankRepository;

public class LottoService {

    private static final DecimalFormat INTEGER_FORMAT = new DecimalFormat("###,###");
    private static final DecimalFormat FLOAT_FORMAT = new DecimalFormat("###,###.#");

    int purchasePrice;
    List<Lotto> playerPurchaseLottos = new ArrayList<>();
    WinningLotto winningLotto;

    public void play() {
        printPurchaseGuideMessage();
        setPlayerPurchaseLottos(purchaseLottos());
        setWinningLotto(inputWinningLotto());
        List<Rank> lottoResults = getResult();
        printResult(lottoResults);
    }

    private static void printPurchaseGuideMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void printResult(List<Rank> lottoResults) {
        int totalReward = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.printf("%s (%s) - %d개%n", rank.getDescriptionMessage(),
                    getFormattedReward(rank.getWinningPrice()), getMatchedRankCount(lottoResults, rank));
            totalReward += rank.getWinningPrice() * getMatchedRankCount(lottoResults, rank);
        }
        System.out.printf("총 수익률은 %s%%입니다.%n", getFormattedRateOfReturn(totalReward));
    }

    private String getFormattedRateOfReturn(int totalReward) {
        return FLOAT_FORMAT.format(totalReward * 100.0 / purchasePrice);
    }

    private static long getMatchedRankCount(List<Rank> lottoResults, Rank matchedRank) {
        return lottoResults.stream()
                .filter(lottoResult -> lottoResult.equals(matchedRank))
                .count();
    }

    private static String getFormattedReward(int winningPrice) {
        return INTEGER_FORMAT.format(winningPrice);
    }

    private List<Rank> getResult() {
        List<Rank> lottoResults = new ArrayList<>();
        for (Lotto playerPurchaseLotto : playerPurchaseLottos) {
            RankRepository.getRank(playerPurchaseLotto, winningLotto)
                    .ifPresent(lottoResults::add);
        }
        return lottoResults;
    }

    private void setWinningLotto(WinningLotto inputWinningLotto) {
        winningLotto = inputWinningLotto;
    }

    WinningLotto inputWinningLotto() {
        printInputWinningLottoGuideMessage();
        Lotto lotto = getWinningLotto();
        printInputBonusNumberGuideMessage();
        int bonusNumber = inputBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }

    private static void printInputWinningLottoGuideMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private static void printInputBonusNumberGuideMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
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
            System.out.println("[ERROR] 당첨 번호는 반드시 숫자여야 합니다.\n");
            throw new IllegalArgumentException();
        }
    }

    private int inputBonusNumber() {
        String playerInput = Console.readLine();
        try {
            return Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 반드시 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    void setPlayerPurchaseLottos(List<Lotto> lottos) {
        playerPurchaseLottos.clear();
        playerPurchaseLottos.addAll(lottos);
    }

    List<Lotto> purchaseLottos() {
        this.purchasePrice = inputPurchasePrice();
        if (purchasePrice % LOTTO_PRICE != 0) {
            System.out.printf("[ERROR] 로또는 %d원 단위로 나누어 떨어져야 합니다.\n", LOTTO_PRICE);
            throw new IllegalArgumentException();
        }
        return generateLottos(purchasePrice / LOTTO_PRICE);
    }

    int inputPurchasePrice() {
        String playerInput = Console.readLine();
        try {
            return Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 구매 금액은 반드시 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    Lotto generateLotto() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        return new Lotto(uniqueNumbers);
    }
}
