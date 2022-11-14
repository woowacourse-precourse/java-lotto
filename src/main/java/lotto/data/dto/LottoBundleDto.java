package lotto.data.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.type.ConstantNumberType;
import lotto.type.ExceptionType;
import utils.RandomNumberGenerator;
import utils.Validator.IntegerValidator;
import utils.Validator.StringValidator;

public class LottoBundleDto {

    private Long ownerId;
    private Long roundId;
    private final List<LottoDto> lottos;

    public LottoBundleDto(List<LottoDto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoBundleDto createWithInput(String input) {
        validate(input);
        int buyableCount = getBuyableCount(Integer.parseInt(input));
        List<LottoDto> lottos = generateRandomLottos(buyableCount);
        return new LottoBundleDto(lottos);
    }

    private static void validate(String input) {
        if(hasErroneousNumberFormat(input)) {
            throw ExceptionType.NUMBER.getException();
        }
        if(hasErroneousMoneyValue(Integer.parseInt(input))) {
            throw ExceptionType.MONEY.getException();
        }
    }

    private static boolean hasErroneousNumberFormat(String input) {
        return !StringValidator.isNumeric(input);
    }

    private static boolean hasErroneousMoneyValue(int value) {
        return !IntegerValidator.isDivisibleBy(value, ConstantNumberType.COST.getValue());
    }

    private static int getBuyableCount(int money){
        return money / ConstantNumberType.COST.getValue();
    }

    private static List<LottoDto> generateRandomLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(number -> new LottoDto(RandomNumberGenerator.generateMultipleNumbers(
                        ConstantNumberType.MIN.getValue(),
                        ConstantNumberType.MAX.getValue(),
                        ConstantNumberType.COUNT.getValue())))
                .collect(Collectors.toList());
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public Long getRoundId() {
        return roundId;
    }

    public List<LottoDto> getLottos() {
        return lottos;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }
}
