package Controller;

import domain.Grade;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static Service.LottoService.lottos;
import static Controller.GameController.getWinning_numbers;
import static domain.Game.*;
import static domain.Grade.getGrade;


public class mainController {

    public static List<Grade.Lottogrades> grades = new ArrayList<>();
    public static int first_count = 0;
    public static int second_count = 0;
    public static int third_count = 0;
    public static int fourth_count = 0;
    public static int fifth_count = 0;
    public static int total_gain = 0;

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

    public static void set_totalGain() {
        total_gain = (fifth_count * 5000) + (fourth_count * 50000) + (third_count * 2000000) + (second_count * 30000000) + (first_count * 2000000000);
    }

    public static void print_gain() {
        System.out.print(total_gain);

    }

    public static double get_stactiscs() {
        double yield = 100.0 / getLottoCount() * (total_gain / 1000);
        return yield;
    }
}

