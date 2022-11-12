package lotto;

import constant.Prize;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.junit.jupiter.api.Assertions.*;

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