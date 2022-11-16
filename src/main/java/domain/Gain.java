package domain;

import static Service.gradeService.*;
import static domain.Game.getLottoCount;

public class Gain {
    public static int total_gain = 0;

    public static void set_totalGain() {
        total_gain = (fifth_count * 5000) + (fourth_count * 50000) + (third_count * 2000000) + (second_count * 30000000) + (first_count * 2000000000);
    }


    public static double get_stactiscs() {
        double yield = 100.0 / getLottoCount() * (total_gain / 1000);
        return yield;
    }
}
