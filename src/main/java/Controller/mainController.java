package Controller;

import Service.gradeService;
import domain.Grade;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static Service.LottoService.lottos;
import static domain.Game.bonusNumber;
import static Controller.GameController.getWinning_numbers;
import static domain.Grade.getGrade;


public class mainController {

    public static List<Grade.Lottogrades> grades = new ArrayList<>();
    public static int first_count = 0;
    public static int second_count = 0;
    public static int third_count = 0;
    public static int fourth_count = 0;
    public static int fifth_count = 0;

    public static void setGrades() {
        for (Lotto lotto : lottos) {
            grades.add(getGrade(lotto.get_hitCount(getWinning_numbers()), lotto.bonus_hit(bonusNumber)));
        }
    }

    public static void grade_count() {
        for (Grade.Lottogrades lottograde : grades) {
            if (lottograde.fifth == lottograde) fifth_count++;
            if (lottograde.fourth == lottograde) fourth_count++;
            if (lottograde.third == lottograde) third_count++;
            if (lottograde.second == lottograde) second_count++;
            if (lottograde.first == lottograde) first_count++;
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

