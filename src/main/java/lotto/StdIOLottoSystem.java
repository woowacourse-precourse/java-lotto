package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

public class StdIOLottoSystem implements LottoSystem{
    private final LottoMetadata metadata;
    private final LottoPublisher publisher;
    private final LottoWinningChecker checker;
    private Lotto winningNumber;
    private Integer bonusNumber;
    private Integer payment;

    public StdIOLottoSystem(LottoMetadata metadata) {
        this.metadata = metadata;
        this.publisher = new LottoPublisher(metadata);
        this.checker = new LottoWinningChecker(metadata);
    }

    private enum SystemMessage {
        ASK_FEE("구입금액을 입력해 주세요."),
        INFORM_PURCHASE ("개를 구매했습니다."),
        ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        SystemMessage(String message) {
            this.message = message;
        }
    }
    @Override
    public Integer askFeeFromUser() {
        printSystemMessage(SystemMessage.ASK_FEE.message);
        String line = Console.readLine();
        raiseErrorIfNotNumber(line);
        payment = Integer.parseInt(line);
        return payment;
    }

    private void raiseErrorIfNotNumber(String line) {
        Pattern pattern = Pattern.compile("[1-9][0-9]*");
        Matcher matcher = pattern.matcher(line);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 지불 금액은 숫자여야합니다.");
        }
    }

    private void printSystemMessage(String message) {
        System.out.println(message);
    }

    @Override
    public List<Lotto> purchaseMultipleLotto(Integer payment) {
        raiseErrorIfRemainderIsZero(payment, metadata.getPriceOfLotto());
        Integer nums = payment / metadata.getPriceOfLotto();
        printSystemMessage(nums + SystemMessage.INFORM_PURCHASE.message);
        return publisher.purchase(nums);
    }

    private void raiseErrorIfRemainderIsZero(Integer payment, Integer priceOfLotto) {
        if (payment % priceOfLotto != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 로또 가격으로 나누어 떨어지지 않습니다.");
        }
    }

    @Override
    public void showMultipleLotto(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    @Override
    public void setNumbersByUser() {
        printSystemMessage(SystemMessage.ASK_WINNING_NUMBERS.message);
        setWinningNumberByUserInput();
        printSystemMessage(SystemMessage.ASK_BONUS_NUMBER.message);
        setBonusNumberByUserInput();
        raiseErrorIfWinningNumberContainBonus();
    }

    private void raiseErrorIfWinningNumberContainBonus() {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 볼은 당첨 번호에 포함되어서는 안됩니다.");
        }
    }

    private void setWinningNumberByUserInput() {
        String line = Console.readLine();
        raiseErrorIfHasIllegalCharacter(line, metadata.getDelimeter());
        String[] split = line.split(metadata.getDelimeter());
        List<Integer> numbers = Arrays.stream(split).map(Integer::parseInt)
                .collect(Collectors.toList());
        raiseErrorIfElementOutOfRange(numbers, metadata.getStartNumber(), metadata.getEndNumber());
        winningNumber = new Lotto(numbers);
    }

    private void setBonusNumberByUserInput() {
        String line = Console.readLine();
        raiseErrorIfHasIllegalCharacter(line);
        Integer number = Integer.parseInt(line);
        raiseErrorIfNumberOutOfRange(number, metadata.getStartNumber(), metadata.getEndNumber());
        bonusNumber = number;
    }

    private void raiseErrorIfHasIllegalCharacter(String line, String delim) {
        Pattern pattern = Pattern.compile("[0-9]+(["+ delim +"][0-9]+)+");
        Matcher matcher = pattern.matcher(line);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 형식에 맞지않습니다. 숫자와 구분자만 올 수 있습니다.");
        }
    }
    private void raiseErrorIfHasIllegalCharacter(String line) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(line);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 올 수 있습니다.");
        }
    }

    private void raiseErrorIfElementOutOfRange(List<Integer> numbers, Integer startNumber, Integer endNumber) {
        for (Integer number : numbers) {
            raiseErrorIfNumberOutOfRange(number, startNumber, endNumber);
        }
    }

    private static void raiseErrorIfNumberOutOfRange(Integer number, Integer startNumber, Integer endNumber) {
        if (number < startNumber || endNumber < number) {
            throw new IllegalArgumentException("[ERROR] " + startNumber + "~" + endNumber + "인 수만 입력할 수 있습니다.");
        }
    }

    @Override
    public void announceResult(List<Lotto> lottos) {
        Map<Prize, Integer> winningLotto = checker.countWinningLotto(winningNumber, bonusNumber, lottos);
        Map<Prize, Integer> prizeMoney = metadata.getPrizeMoney();
        Map<Map.Entry<Integer, Boolean>, Prize> prizeTable = metadata.getPrizeTable();
        StringBuilder sb = getStringBuilder(winningLotto, prizeMoney, prizeTable);
        System.out.println(sb);
    }

    private StringBuilder getStringBuilder(Map<Prize, Integer> winningLotto, Map<Prize, Integer> prizeMoney, Map<Map.Entry<Integer, Boolean>, Prize> prizeTable) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---\n");
        sb.append("3개 일치 (5,000원) - ").append(winningLotto.get(Prize.FIFTH)).append("개\n");
        sb.append("4개 일치 (50,000원) - ").append(winningLotto.get(Prize.FOURTH)).append("개\n");
        sb.append("5개 일치 (1,500,000원) - ").append(winningLotto.get(Prize.THIRD)).append("개\n");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(winningLotto.get(Prize.SECOND)).append("개\n");
        sb.append("6개 일치 (2,000,000,000원) - ").append(winningLotto.get(Prize.FIRST)).append("개\n");
        sb.append("총 수익률은 ").append(getRevenueRatio(winningLotto)).append("%입니다.").append("\n");
        return sb;
    }

    private Double getRevenueRatio(Map<Prize, Integer> winningLotto) {
        Map<Prize, Integer> prizeMoney = metadata.getPrizeMoney();
        Long sum = 0L;
        for (Prize prize : List.of(Prize.values())) {
            sum += (long) prizeMoney.get(prize) * winningLotto.get(prize);
        }
        Double result = (double) sum / payment * 100L;
        result = Double.parseDouble(String.format("%.2f", result));
        return result;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public Integer getPayment() {
        return payment;
    }
}
