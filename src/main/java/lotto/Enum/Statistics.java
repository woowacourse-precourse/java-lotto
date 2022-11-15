package lotto.Enum;

import java.util.Arrays;
import java.util.HashMap;

import static lotto.Enum.Constant.ZERO_INDEX;

public enum Statistics {
    FIFTH_GRADE(3, "3개 일치 (5,000원) - ","개\n"),
    FOURTH_GRADE(4, "4개 일치 (50,000원) - ","개\n"),
    THIRD_GRADE(5, "5개 일치 (1,500,000원) - ","개\n"),
    SECOND_GRADE(7, "5개 일치, 보너스 볼 일치 (30,000,000원) - ","개\n"),
    FIRST_GRADE(6,"6개 일치 (2,000,000,000원) - ","개\n"),
    ;

    private int prize_number;
    private String start_message;
    private String end_message;

    Statistics(int prize_number, String start_message, String end_message) {
        this.prize_number = prize_number;
        this.start_message = start_message;
        this.end_message = end_message;
    }

    public static String getStatistics(HashMap<Integer,Integer> prize_count, double profit_rate){
        StringBuilder statistics_message = new StringBuilder();

        Arrays.stream(Statistics.values())
                .forEach(value->{
                    statistics_message.append(value.start_message)
                            .append(prize_count.getOrDefault(value.prize_number, ZERO_INDEX.getIntValue()))
                            .append(value.end_message);
                });

        statistics_message.append("총 수익률은 ")
                .append(String.format("%.1f", profit_rate))
                .append("%입니다.");

        return statistics_message.toString();
    }
}
