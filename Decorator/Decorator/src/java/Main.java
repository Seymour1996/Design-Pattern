import java.io.*;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/12/18 9:56
 * @github https://github.com/Seymour1996
 */
public class Main {
    public static void main(String []args){
        try{
            FileWriter fw=new FileWriter("src/resources/out.txt");
            ReplaceWriter rw=new ReplaceWriter(fw);
            rw.write("你个sb我cnm");
            rw.flush();
            rw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
