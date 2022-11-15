package lotto.controller;

import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import java.io.IOException;

public class LottoController {
    private final LottoService lottoService = new LottoServiceImpl();
    public void run(){
        try {
            lottoService.play();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
