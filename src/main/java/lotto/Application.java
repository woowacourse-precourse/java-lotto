package lotto;

import lotto.playlotto.PlayLotto;

public class Application {
    public static void main(String[] args) {
        try{
            PlayLotto lotto = new PlayLotto();
            lotto.play();
        }catch(IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
