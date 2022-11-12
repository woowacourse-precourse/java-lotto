package domain;

import Service.gradeService;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static Service.LottoService.lottos;

public class Controller {

    public static List<gradeService.grade> grades=new ArrayList<>();
    public static int first_count = 0;
    public static int second_count = 0;
    public static int third_count = 0;
    public static int fourth_count = 0;
    public static int fifth_count = 0;

    public static void setGrades() {
        for (Lotto lotto : lottos) {
            grades.add(gradeService.getGrade(lotto.get_hitCount(Game.getWinning_numbers()), lotto.bonus_hit(Game.bonusNumber)));
        }
    }

    public static void grade_count() {
        for (gradeService.grade grade : grades) {
            if (gradeService.grade.fifth == grade) fifth_count++;
            if (gradeService.grade.fourth == grade) fourth_count++;
            if (gradeService.grade.third == grade) third_count++;
            if (gradeService.grade.second == grade) second_count++;
            if (gradeService.grade.first == grade) first_count++;
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

