package Service;

import domain.Grade;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static Service.LottoService.lottos;
import static domain.Game.getWinning_numbers;
import static domain.Game.*;
import static domain.Grade.getGrade;


public class gradeService {

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


}