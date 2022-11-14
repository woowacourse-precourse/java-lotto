package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum WinningType {
    FIFTH("3개 일치 (5,000원) - {0}개", 5000),
    FOURTH("4개 일치 (50,000원) - {0}개", 50000),
    THIRD("5개 일치 (1,500,000원) - {0}개", 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - {0}개", 30000000),
    FIRST("6개 일치 (2,000,000,000원) - {0}개", 2000000000),
    ;

    private final String desc;
    private final int money;


    WinningType(String desc, int money) {
        this.desc = desc;
        this.money = money;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getMoney() {
        return this.money;
    }

    public static List<String> getDescList() {
        return Arrays.stream(WinningType.values())
                .map(WinningType::getDesc)
                .collect(Collectors.toList());
    }

    public static List<Integer> getMoneyList() {
        return Arrays.stream(WinningType.values())
                .map(WinningType::getMoney)
                .collect(Collectors.toList());
    }
}
