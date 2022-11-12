package lotto.view;

public class Output {

    static final String OUTPUT_RESULT_TITLE = "당첨 통계";
    static final String OUTPUT_RESULT_LINE = "---";

    public Output() {
    }

    public static void printTitle() {
        System.out.println(OUTPUT_RESULT_TITLE);
        System.out.println(OUTPUT_RESULT_LINE);
    }

}
