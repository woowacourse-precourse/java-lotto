package lotto.print;

import java.util.Arrays;

public enum StatisticsMessage {
    GUIDE("guide", "당첨 통계" + System.lineSeparator() + "---"),
    FIRST("1등", "6개 일치 (2,000,000,000원) - "),
    SECOND("2등", "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD("3등", "5개 일치 (1,500,000원) - "),
    FOURTH("4등", "4개 일치 (50,000원) - "),
    FIFTH("5등", "3개 일치 (5,000원) - "),
    EMPTY("", "");

    private final String name;
    private final String message;

    StatisticsMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }//constructor

    static StatisticsMessage find(String name) {
        return Arrays.stream(values())
                .filter(StatisticsMessage -> StatisticsMessage.name.equals(name))
                .findAny()
                .orElse(EMPTY);
    }//find

    static String sendMessage(String name) {
        return find(name).message;
    }// sendMessage
} //end enum
