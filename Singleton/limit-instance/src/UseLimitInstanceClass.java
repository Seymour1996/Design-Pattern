/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/11/27 10:11
 * @github https://github.com/Seymour1996
 */
public class UseLimitInstanceClass {
    public static void main(String args[]){
        AccessLimitInstanceClassThread T1=new AccessLimitInstanceClassThread("线程1");
        AccessLimitInstanceClassThread T2=new AccessLimitInstanceClassThread("线程2");
        AccessLimitInstanceClassThread T3=new AccessLimitInstanceClassThread("线程3");
        AccessLimitInstanceClassThread T4=new AccessLimitInstanceClassThread("线程4");
        AccessLimitInstanceClassThread T5=new AccessLimitInstanceClassThread("线程5");
        AccessLimitInstanceClassThread T6=new AccessLimitInstanceClassThread("线程6");
        AccessLimitInstanceClassThread T7=new AccessLimitInstanceClassThread("线程7");
        AccessLimitInstanceClassThread T8=new AccessLimitInstanceClassThread("线程8");
        AccessLimitInstanceClassThread T9=new AccessLimitInstanceClassThread("线程9");
        AccessLimitInstanceClassThread T10=new AccessLimitInstanceClassThread("线程10");
        T1.start();
        T2.start();
        T3.start();
        T4.start();
        T5.start();
        T6.start();
        T7.start();
        T8.start();
        T9.start();
        T10.start();
    }
}
