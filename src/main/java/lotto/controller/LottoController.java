package lotto.controller;

import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

import java.io.IOException;

public class LottoController {
    private LottoService lottoService = new LottoServiceImpl();
    public LottoController(){
    }
    public void run(){
        try {
            lottoService.play();
        }catch (IOException e){
            System.out.println("[ERROR]"+e.getMessage());
        }
    }
}
