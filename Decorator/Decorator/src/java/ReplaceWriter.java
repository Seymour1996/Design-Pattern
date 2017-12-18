import java.io.File;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2017/12/18 9:37
 * @github https://github.com/Seymour1996
 */
public class ReplaceWriter extends Writer{
    private static List<String> regex;
    protected Writer out;
    protected ReplaceWriter(Writer out) {
        super(out);
        if(regex==null){
            try {
                regex=new LinkedList<>();
                Scanner sc = new Scanner(new File("src/resources/badwords.txt"));
                while(sc.hasNext()){
                    regex.add(sc.nextLine());
                }
            }
            catch(Exception e){e.printStackTrace();}
        }
        this.out = out;
    }

    @Override
    public void write(char cbuf[], int off, int len) throws IOException {
        String data=new String(cbuf);
        for(int i=0;i<regex.size();i++)
        data.replaceAll(regex.get(i),"*");
        out.write(data, off, len);
    }
    @Override
    public void write(String str, int off, int len) throws IOException {
        for(int i=0;i<regex.size();i++)
            str=str.replaceAll(regex.get(i),"*");
        out.write(str, off, len);
    }

    @Override
    public void write(String str) throws IOException {
        for(int i=0;i<regex.size();i++) {
            String badword=regex.get(i);
            str=str.replace(badword, replacement(badword.length()));
        }
        out.write(str);
    }
    private String replacement(int count){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<count;i++){
            sb.append("*");
        }
        return sb.toString();
    }
    @Override
    public void flush() throws IOException {
        out.flush();
    }
    @Override
    public void close() throws IOException {
        out.close();
    }
}

