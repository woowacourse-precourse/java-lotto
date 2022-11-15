package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class View {

    public String input() {
        return Console.readLine();
    }

    public void showMessage(String message){
        System.out.println(message);
    }

    public void lottoNumberShow(List<Lotto> lottos,String message){

        showMessage(message);
        for(int i=0;i<lottos.size();i++){
            System.out.println('['+lottos.get(i).getNumbers()+']');
        }
    }
}
