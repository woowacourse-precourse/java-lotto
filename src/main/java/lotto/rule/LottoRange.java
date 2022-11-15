package lotto.rule;

public enum LottoRange {

    START(1),
    END(45);

    private final int range;

    LottoRange(int range){
        this.range = range;
    }

    public static boolean isOutOfRange(int number){
        return number < START.range || number > END.range;
    }
}
