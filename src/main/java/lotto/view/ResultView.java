package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoGenerator;

public class ResultView {
    private static final String MESSAGE_FOR_LOTTO_QUANTITY = "%d개를 구매했습니다.\n";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String DELIMITER_FORMAT = ", ";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printLottoQuantity(int quantity) {
        System.out.println(NEW_LINE);
        System.out.printf(MESSAGE_FOR_LOTTO_QUANTITY, quantity);
    }

    public static void printGeneratedLotto(List<LottoGenerator> lottoGenerators) {
        for (LottoGenerator lottoGenerator : lottoGenerators) {
            String numbers = lottoGenerator.getSortedRandomLotto().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(DELIMITER_FORMAT));
            System.out.println(LEFT_BRACKET + numbers + RIGHT_BRACKET);
        }
    }






}
