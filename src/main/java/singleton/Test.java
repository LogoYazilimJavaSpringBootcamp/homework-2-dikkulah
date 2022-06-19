package singleton;

public class Test {
    public static void main(String[] args) {

        new Thread(() -> {

            try {
                Thread.sleep(10);
                System.out.println("Lazy: "+LazySingleton.getInstance().hashCode());
                System.out.println("Eager: "+EagerSingleton.getInstance().hashCode());
                System.out.println("Enum: "+EnumSingleton.INSTANCE.hashCode());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }).start();

        new Thread(() -> {

            try {
                System.out.println("Lazy: "+LazySingleton.getInstance().hashCode());
                System.out.println("Eager: "+EagerSingleton.getInstance().hashCode());
                System.out.println("Enum: "+EnumSingleton.INSTANCE.hashCode());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }).start();

    }
}
