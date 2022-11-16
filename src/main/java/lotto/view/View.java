package lotto.view;

public abstract class View {
    private String page;

    protected void initPage(String page){
        this.page = page;
    }

    public void show(){
        System.out.println(page);
    }

}
