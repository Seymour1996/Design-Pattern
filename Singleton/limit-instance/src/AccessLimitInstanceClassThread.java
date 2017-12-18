import java.util.Random;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/11/27 10:01
 * @github https://github.com/Seymour1996
 */
public class AccessLimitInstanceClassThread extends Thread {
    AccessLimitInstanceClassThread(String name){
        super(name);
    }
    @Override
    public void run() {
       try {
           LimitInstanceClass limitInstanceClass = LimitInstanceClass.getInstance();
           if(limitInstanceClass==null)
           {
               System.out.println(this.getName()+"无空闲实例可用!");
               throw new InterruptedException();
           }
           limitInstanceClass.writeAccessMessage(this.getName());
           Thread.sleep(1000 * (new Random()).nextInt(5));
           limitInstanceClass.printAccessMessage();
           limitInstanceClass.release();
       }
       catch (InterruptedException e){
       }

    }
}
