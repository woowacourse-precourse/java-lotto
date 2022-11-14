package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoRankingType;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserInterface {
    private static final int ZERO = 0;
    private static final int ASCII_ZERO = 48;
    private static final int ASCII_NINE = 57;
    private static final int LOTTO_PRICE = 1000;
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String DELIMITER = ",";
    private static final String OUTPUT_BUY_LOTTO = "구입금액을 입력해 주세요.";
    private static final String OUTPUT_LOTTO_COUNT = "%d개를 구매했습니다.%s";
    private static final String OUTPUT_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String OUTPUT_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String OUTPUT_RESULT = "당첨 통계";
    private static final String OUTPUT_LINE_BREAKER = "---------------------------------";
    private static final String OUTPUT_WINNING_HISTORY = "%d개 일치 (%s원) - %d개%s";
    private static final String OUTPUT_WINNING_HISTORY_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%s";
    private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %s%%입니다.%s";
    private static final String ERROR_IS_NOT_NUMBER = "[ERROR] 숫자만 입력 해 주세요.";
    private static final String ERROR_CAN_NOT_BUY_LOTTO = "[ERROR] 1000원 단위로 입력 해주세요.";
    private static final String ERROR_IS_NOT_CORRECT_COUNT = "[ERROR] 당첨 번호는 서로 다른 숫자 6개 입니다.(구분자 \',\')";
    private static final String ERROR_IS_INVALID_NUMBER = "[ERROR] 1~45 사이의 숫자만 입력 해 주세요.";
    private static final DecimalFormat INT_DECIMAL_FORMAT_BY_KOREA_MONEY = new DecimalFormat("###,###");
    private static final DecimalFormat DOUBLE_DECIMAL_FORMAT_BY_KOREA_MONEY = new DecimalFormat("#,##0.0");


    public UserInterface() {
    }

    public int getLottoCount() {
        System.out.println(OUTPUT_BUY_LOTTO);

        String userInput = Console.readLine();
        if (isNotNumber(userInput)) {
            throw new IllegalArgumentException(ERROR_IS_NOT_NUMBER);
        }
        int inputAmount = Integer.parseInt(userInput);
        if (canNotBuyLotto(inputAmount)) {
            throw new IllegalArgumentException(ERROR_CAN_NOT_BUY_LOTTO);
        }

        System.out.println();
        return inputAmount / LOTTO_PRICE;
    }

    public void printLotto(int lottoCount, List<Lotto> lottos) {
        System.out.printf(OUTPUT_LOTTO_COUNT, lottoCount, System.lineSeparator());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public List<Integer> getWinningNumbers() {
        System.out.println(OUTPUT_INPUT_WINNING_NUMBERS);

        String userInput = Console.readLine();
        if (isNotCorrectCount(userInput)) {
            throw new IllegalArgumentException(ERROR_IS_NOT_CORRECT_COUNT);
        }

        List<Integer> winningNumbers = makeWinningNumbers(userInput);
        if (isInvalidWinningNumber(winningNumbers)) {
            throw new IllegalArgumentException(ERROR_IS_INVALID_NUMBER);
        }
        System.out.println();
        return winningNumbers;
    }

    public int getBonusNumber() {
        System.out.println(OUTPUT_INPUT_BONUS_NUMBER);

        String userInput = Console.readLine();
        if (isNotNumber(userInput)) {
            throw new IllegalArgumentException(ERROR_IS_NOT_NUMBER);
        }

        int bonusNumber = Integer.parseInt(userInput);
        if (isInValidNumber(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_IS_INVALID_NUMBER);
        }
        System.out.println();
        return bonusNumber;
    }

    public void printResult(Map<LottoRankingType, Integer> lottoRankingTypes, double rateOfReturn) {
        System.out.println(OUTPUT_RESULT);
        System.out.println(OUTPUT_LINE_BREAKER);
        printWinningHistory(lottoRankingTypes);
        System.out.printf(OUTPUT_RATE_OF_RETURN, DOUBLE_DECIMAL_FORMAT_BY_KOREA_MONEY.format(rateOfReturn), System.lineSeparator());
    }

    private void printWinningHistory(Map<LottoRankingType, Integer> lottoRankingTypes) {
        System.out.printf(OUTPUT_WINNING_HISTORY
                , LottoRankingType.FIFTH_PLACE.getMatchedNumberCount()
                , INT_DECIMAL_FORMAT_BY_KOREA_MONEY.format(LottoRankingType.FIFTH_PLACE.getWinningAmount())
                , lottoRankingTypes.get(LottoRankingType.FIFTH_PLACE).intValue()
                , System.lineSeparator());
        System.out.printf(OUTPUT_WINNING_HISTORY
                , LottoRankingType.FOURTH_PLACE.getMatchedNumberCount()
                , INT_DECIMAL_FORMAT_BY_KOREA_MONEY.format(LottoRankingType.FOURTH_PLACE.getWinningAmount())
                , lottoRankingTypes.get(LottoRankingType.FOURTH_PLACE).intValue()
                , System.lineSeparator());
        System.out.printf(OUTPUT_WINNING_HISTORY
                , LottoRankingType.THIRD_PLACE.getMatchedNumberCount()
                , INT_DECIMAL_FORMAT_BY_KOREA_MONEY.format(LottoRankingType.THIRD_PLACE.getWinningAmount())
                , lottoRankingTypes.get(LottoRankingType.THIRD_PLACE).intValue()
                , System.lineSeparator());
        System.out.printf(OUTPUT_WINNING_HISTORY_WITH_BONUS
                , LottoRankingType.SECOND_PLACE.getMatchedNumberCount()
                , INT_DECIMAL_FORMAT_BY_KOREA_MONEY.format(LottoRankingType.SECOND_PLACE.getWinningAmount())
                , lottoRankingTypes.get(LottoRankingType.SECOND_PLACE).intValue()
                , System.lineSeparator());
        System.out.printf(OUTPUT_WINNING_HISTORY
                , LottoRankingType.FIRST_PLACE.getMatchedNumberCount()
                , INT_DECIMAL_FORMAT_BY_KOREA_MONEY.format(LottoRankingType.FIRST_PLACE.getWinningAmount())
                , lottoRankingTypes.get(LottoRankingType.FIRST_PLACE).intValue()
                , System.lineSeparator());
    }


    private List<Integer> makeWinningNumbers(String userInput) {
        String[] userInputs = userInput.split(DELIMITER);
        List<Integer> winningNumbers = new ArrayList<>(WINNING_NUMBER_COUNT);

        for (String number : userInputs) {
            if (isNotNumber(number)) {
                throw new IllegalArgumentException(ERROR_IS_NOT_NUMBER);
            }
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    private boolean isNotNumber(String number) {
        for (int i = 0; i < number.length(); ++i) {
            if (number.charAt(i) < ASCII_ZERO || ASCII_NINE < number.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean canNotBuyLotto(int amount) {
        if (amount % LOTTO_PRICE != ZERO) {
            return true;
        }
        return false;
    }

    private boolean isNotCorrectCount(String userInput) {
        String[] winningNumbers = userInput.split(DELIMITER);
        if (winningNumbers.length != WINNING_NUMBER_COUNT) {
            return true;
        }
        return false;
    }

    private boolean isInvalidWinningNumber(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (isInValidNumber(winningNumber.intValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean isInValidNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number) {
            return true;
        }
        return false;
    }

}
