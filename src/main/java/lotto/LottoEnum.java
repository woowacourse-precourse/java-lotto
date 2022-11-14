package lotto;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoEnum {

    THREE(value -> value*5000, "3개 일치 (5,000원)",3),
    FOUR(value -> value*50000,"4개 일치 (50,000원)",4),
    FIVE(value -> value*1500000,"5개 일치 (1,500,000원)",5),
    FIVE_B(value -> value*30000000,"5개 일치, 보너스 볼 일치 (30,000,000원)",7),
    SIX(value -> value*2000000000,"6개 일치 (2,000,000,000원)",6);

    private Function<Long,Long> money;
    private String moneyString;
    private int number;
    private static long sumMoney;

    LottoEnum(Function<Long,Long> lottoValue, String moneyPrint, int number) {
        this.money = lottoValue;
        this.moneyString = moneyPrint;
        this.number = number;
    }

    public void calculate(long value) {
        sumMoney += money.apply(value);
    }

    public String getMoneyString() { return moneyString; }
    public static long getSumMoney() { return sumMoney; }
    public int getNumber() { return number; }
    private static Map<Integer, LottoEnum> BY_NUMBER =
            Stream.of(values()).collect(Collectors.toMap(LottoEnum::getNumber, Function.identity()));

    public static LottoEnum valueOfNumber(int number) {
        return BY_NUMBER.get(number);
    }
}
