package lotto.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @Test
    void printLottoList() {
        LottoController lottoController = new LottoController();
        lottoController.createLottoList(6);
        lottoController.printLottoList();
    }
    @Test
    void getCorrect(){
        LottoController lottoController = new LottoController();
        lottoController.createLottoList(6);
        lottoController.printLottoList();

        lottoController.getCorrect(List.of(1,2,3,4,5,6));

        List<Integer> list = lottoController.getCorrectTimes();
        for(int i =0 ;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}