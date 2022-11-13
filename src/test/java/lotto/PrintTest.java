package lotto;

import java.util.EnumMap;
import lotto.model.Prize;
import lotto.view.Print;
import org.junit.jupiter.api.Test;

class PrintTest {

    private Print print = new Print();

    @Test
    public void 출력_확인() {
        EnumMap<Prize, Integer> prizeIntegerEnumMap = new EnumMap<>(Prize.class);
        prizeIntegerEnumMap.put(Prize.FIRST, 3);
        prizeIntegerEnumMap.put(Prize.SECOND, 1);
        prizeIntegerEnumMap.put(Prize.THIRD, 2);
        prizeIntegerEnumMap.put(Prize.FOURTH, 0);
        prizeIntegerEnumMap.put(Prize.FIFTH, 22);
        print.statics(prizeIntegerEnumMap);
    }
}