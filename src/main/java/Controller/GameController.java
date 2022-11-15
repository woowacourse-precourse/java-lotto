package Controller;

import Service.LottoService;
import Service.gradeService;
import Utils.utils;

import static Service.View.*;
import static domain.Gain.set_totalGain;
import static domain.Game.*;

public class GameController {
    public static final boolean NOT_NUMBER_INPUT = true;
    public static boolean INPUT;

    public static void start() {
        INPUT = read_buyingLottoAmount();
        if (INPUT == NOT_NUMBER_INPUT) return;
        print_purchasedLottoNumber();
        LottoService.lottoSpawner(getLottoCount());
        LottoService.printLottoNumbers();
        read_WinningNumbers();
        setWinning_numbers(utils.change_StringToInt(winningNumbers_Input));
        read_bonusNumber();
        print_Message_Winning_Stastistics();
        gradeService.setGrades();
        gradeService.grade_count();
        print_Stactistics();
        set_totalGain();
        print_totalGain();

    }

}