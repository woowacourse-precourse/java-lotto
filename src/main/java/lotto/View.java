package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class View {
    public static String Input() {
        return Console.readLine();
    }

    public static void Output(String message) {
        System.out.println(message);
    }

    public static void OutputArrayList(ArrayList<Integer> arraylist) {
        for (Integer I : arraylist) {
            System.out.println(I);
        }
    }

}
