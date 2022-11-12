package domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static List<Lotto> lottos =new ArrayList<>();
    public static List<Amount.grade> grades=new ArrayList<>();
    public static int first_count = 0;
    public static int second_count = 0;
    public static int third_count = 0;
    public static int fourth_count = 0;
    public static int fifth_count = 0;

    public static void lottoSpawner(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
    }

    public static void printLottoNumbers() {
        for (Lotto lotto : lottos) {
            lotto.print();
            System.out.print("\n");
        }
    }

    public static void setGrades() {
        for (Lotto lotto : lottos) {
            grades.add(Amount.getGrade(lotto.get_hitCount(Game.getWinning_numbers()), lotto.bonus_hit(Game.bonusNumber)));
        }
    }

    public static void grade_count() {
        for (Amount.grade grade : grades) {
            if (Amount.grade.fifth == grade) fifth_count++;
            if (Amount.grade.fourth == grade) fourth_count++;
            if (Amount.grade.third == grade) third_count++;
            if (Amount.grade.second == grade) second_count++;
            if (Amount.grade.first == grade) first_count++;
        }
    }

    public static void print_Stactistics() {
        System.out.println("3개 일치 (5000원)" + fifth_count + "개");
        System.out.println("4개 일치 (50000원)" + fourth_count + "개");
        System.out.println("5개 일치 (2000000원)" + third_count + "개");
        System.out.println("5개 일치 + 보너스 번호 일치 (30000000원)" + second_count + "개");
        System.out.println("6개 일치 (2000000000원)" + first_count + '개');
    }

}

