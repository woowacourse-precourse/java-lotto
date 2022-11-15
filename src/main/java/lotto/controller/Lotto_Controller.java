package lotto.controller;

import lotto.domain.Lotto;
import lotto.model.Input_Numbers;
import lotto.model.Main_Service;
import lotto.model.Make_Numbers;
import lotto.view.Output_View;

import java.util.List;

public class Lotto_Controller {
    Input_Numbers input_numbers;
    Main_Service main_service;
    Make_Numbers make_numbers;
    Output_View output_view;
    Lotto lotto;
    private int money, lottoCnt, bonusNumber;
    private List<Lotto> RandomLottoNumbers;
    private List<Integer> winNumbers;
    private int[] winStats;
    private String yield;

    public Lotto_Controller() {
        input_numbers = new Input_Numbers();
        main_service = new Main_Service();
        make_numbers = new Make_Numbers();
        output_view = new Output_View();
    }

    public void start_Lotto() {
        Enter_Purchase_Amount();
    }

    public void Enter_Purchase_Amount() {
        money = input_numbers.input_Money();
        lottoCnt = main_service.get_NumberOfLotto(money);
        output_view.print_LottoCnt(lottoCnt);
        Generate_And_Print_Random_Lotto_Numbers();
    }

    public void Generate_And_Print_Random_Lotto_Numbers() {
        RandomLottoNumbers = make_numbers.make_RandomLotto(lottoCnt);
        Output_View.print_RandomLottoNumbers(RandomLottoNumbers);
        Enter_Lottery_Winning_Conditions();
    }

    public void Enter_Lottery_Winning_Conditions() {
        winNumbers = input_numbers.input_WinNumbers();
        bonusNumber = input_numbers.input_BonusNumber(winNumbers);
        Show_Winning_Stats();
    }

    public void Show_Winning_Stats() {
        winStats = main_service.organize_Details(RandomLottoNumbers, winNumbers, bonusNumber);
        Output_View.print_winningStats(winStats);
        Show_Yield();
    }

    public void Show_Yield() {
        yield = main_service.get_Yield(winStats, money);
        Output_View.print_yield(yield);
    }
}