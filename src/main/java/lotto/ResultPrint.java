package lotto;

import java.util.Map;

public class ResultPrint {

    private Map<String, Integer> prizes;
    public ResultPrint(Map<String, Integer> prizesMap) {
        prizes = prizesMap;
    }
    public void printingResult() {
        System.out.print("3개 일치 (5,000원) - " + prizes.get("FIFTH") + "개");
        System.out.println("4개 일치 (50,000원) - " + prizes.get("FOURTH") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizes.get("THIRD") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizes.get("SECOND") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizes.get("FIRST") + "개");
    }
}
