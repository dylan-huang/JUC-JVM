package pers.dylan.single;

//恶汉式单例
public class Hungry {

    private Hungry() {
    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
