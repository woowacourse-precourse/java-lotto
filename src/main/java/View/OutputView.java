package View;

import Controller.InputController;

import static Dto.ConstDto.InputOutputConstDto.PRINT_LOTTO_SIZE_MESSAGE;

public class OutputView {

    private final InputController inputController = new InputController();

    public void printLottoSize(){
       int lottoSize = inputController.inputMoney();
        System.out.println(lottoSize+PRINT_LOTTO_SIZE_MESSAGE);
    }
}
