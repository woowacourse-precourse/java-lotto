package lotto.lotterymachine.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LotteryMachineServiceTest {

    @Test
    void map_test() {
        final Map<String, Integer> map = new HashMap<>();
        map.put("aa",1);
        map.put("aa",map.get("aa")+1);
        System.out.println(map);
    }

}