package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.NumberOfLottos;

public class OutputView {

    private static final String NUMBER_OF_LOTTOS_PHRASE = "%d개를 구매했습니다.\n";
    private static final String FRONT_SQUARE_BRACKETS = "[";
    private static final String BACK_SQUARE_BRACKETS = "]\n";
    private static final String DELIMITER = ", %d";

    public OutputView() {
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
