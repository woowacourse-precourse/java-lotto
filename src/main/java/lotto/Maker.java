package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Maker {

    public List<Integer> lottoWinList(String lottoWin) {

        String[] lottoWinArray = lottoWin.split(",");

        List<Integer> lottoWinList = new ArrayList<>();

        for (int i = 0; i < lottoWinArray.length; i++) {
            lottoWinList.add(Integer.parseInt(lottoWinArray[i]));
        }



        return lottoWinList;
    }
}
