package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Message {

    static void Start() {
        System.out.println("구매금액을 입력해 주세요.");
    }

    static void Count(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    static void win() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    static void bonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    static void listNumber(HashSet<List> listLotto){
        for (List i : listLotto) {
            System.out.println(i);
        }
    }

    static void lotto(HashMap<Integer, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.get(5000) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(50000) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(1500000) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "
                + result.get(30000000) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(2000000000) + "개");
    }

    static void percentage(double percentage) {
        System.out.println("총 수익률은 " + String.format("%.1f", percentage) + "%입니다.");
    }
}
