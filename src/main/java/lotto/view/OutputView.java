package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.domain.GameResult;
import lotto.domain.LottoGenerator;
import lotto.domain.NumberOfLottos;
import lotto.domain.Ranking;

public class OutputView {

    private static final String NUMBER_OF_LOTTOS_PHRASE = "%d개를 구매했습니다.\n";
    private static final String FRONT_SQUARE_BRACKETS = "[";
    private static final String BACK_SQUARE_BRACKETS = "]\n";
    private static final String DELIMITER = ", %d";
    private static final String CORRECT_COUNT_PHRASE = "%d개 일치";
    private static final String CORRECT_BONUS_PHRASE = ", 보너스 볼 일치";
    private static final String REWARD_AND_COUNT_PHRASE = " (%s원) - %d개\n";
    private static final String GAME_RESULT_PHRASE = "당첨 통계\n---";
    private static final String GAME_YIELD_PHRASE = "총 수익률은 %.1f%%입니다.\n";

    public OutputView() {
    }

    public static void printYield(double yield) {
        String yieldPhrase = String.format(GAME_YIELD_PHRASE, yield * 100);
        System.out.println(yieldPhrase);
    }

    public static void printGameResult() {
        System.out.println(GAME_RESULT_PHRASE);
    }

    public static void printResultStatistic(GameResult gameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Map.Entry<Ranking, Integer>> gameResults = convertMaptoList(gameResult);

        for (Map.Entry<Ranking, Integer> entry : gameResults) {
            Ranking ranking = entry.getKey();
            int count = entry.getValue();

            generateResultPhrase(ranking, count, stringBuilder);
        }
        System.out.println(stringBuilder);
    }

    private static void generateResultPhrase(Ranking ranking, int count, StringBuilder stringBuilder) {
        String countPhrase = String.format(CORRECT_COUNT_PHRASE, ranking.getCount());
        stringBuilder.append(countPhrase);

        if (ranking.isExistBonusNumber()) {
            stringBuilder.append(CORRECT_BONUS_PHRASE);
        }

        String rewardPhrase = String.format(REWARD_AND_COUNT_PHRASE, ranking.getFormatedMoney(), count);
        stringBuilder.append(rewardPhrase);
    }

    private static List<Map.Entry<Ranking, Integer>> convertMaptoList(GameResult gameResult) {
        return gameResult.getGameResult().entrySet().stream().filter(list -> list.getKey() != Ranking.LOSING)
                .sorted(Comparator.comparingInt(i -> i.getKey().getMoney()))
                .collect(Collectors.toList());
    }

    public static void printLottos(NumberOfLottos numberOfLottos, LottoGenerator lottoGenerator) {
        StringBuilder stringBuilder = new StringBuilder();
        int priceAmount = numberOfLottos.getPrice();

        String lottoAmountPhrase = String.format(NUMBER_OF_LOTTOS_PHRASE,
                numberOfLottos.calculateNumberOfLottos(priceAmount));
        stringBuilder.append(lottoAmountPhrase);

        List<Lotto> lottos = lottoGenerator.getLottos();

        for (Lotto lotto : lottos) {
            gererateLottosPhrase(lotto, stringBuilder);
        }
        System.out.println(stringBuilder);
    }

    private static void gererateLottosPhrase(Lotto lotto, StringBuilder stringBuilder) {
        List<Integer> numbers = lotto.getNumbers();
        stringBuilder.append(FRONT_SQUARE_BRACKETS);
        stringBuilder.append(numbers.get(0));

        for (int i = 1; i < numbers.size(); i++) {
            String generatedLotto = String.format(DELIMITER, numbers.get(i));
            stringBuilder.append(generatedLotto);
        }
        stringBuilder.append(BACK_SQUARE_BRACKETS);
    }
}
