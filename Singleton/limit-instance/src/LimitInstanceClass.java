import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/11/27 9:41
 * @github https://github.com/Seymour1996
 */
public class LimitInstanceClass {
    private static List<LimitInstanceClass> list =new ArrayList<LimitInstanceClass>();
    private static int count=0;
    private int id;
    private boolean isBusy=false;
    private String accessMessage;
    private LimitInstanceClass(){

    }
    public static synchronized LimitInstanceClass getInstance(){
        if(count==0) {
            try {
                InputStream in = LimitInstanceClass.class.getClassLoader().getResourceAsStream("InstanceLimit.cfg");
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                count = Integer.parseInt(br.readLine());
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        if(list.size()<count) {
            LimitInstanceClass limitInstanceClass=new LimitInstanceClass();
            limitInstanceClass.id= list.size();
            limitInstanceClass.isBusy=true;
            list.add(limitInstanceClass);
            return limitInstanceClass;
        }
        for(int i = 0; i < list.size() ; i++){
            if(list.get(i).isBusy==false) {
                list.get(i).isBusy=true;
                return list.get(i);
            }
        }
        return null;
    }
    public void release(){
        this.isBusy=false;
    }
    public void writeAccessMessage(String message){
        this.accessMessage=message+"实例编号:"+id;
    }
    public void printAccessMessage()
    {
        System.out.println(accessMessage);
    }

}
