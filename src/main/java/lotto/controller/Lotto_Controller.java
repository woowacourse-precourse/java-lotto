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
//        Generate_And_Print_Random_Lotto_Numbers();
    }
}
