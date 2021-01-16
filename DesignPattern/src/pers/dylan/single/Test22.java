package pers.dylan.single;

public class Test22 {


   private static Test22 test1;

    private Test22() {
    }

    public static Test22 getInstance(){
        if (test1==null){
            test1=new Test22();
        }
        return test1;
    }

    public static void main(String[] args) {

        for (int i=0;i<10;i++){
            new Thread(() ->{
                System.out.println(Test22.getInstance());
            }).start();
        }
    }
}
