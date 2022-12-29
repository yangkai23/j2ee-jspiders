package harsha;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.TreeSet;

/**
 *
 * @author Harsha
 */
public class BadWords {
   public static TreeSet<String> pw=new TreeSet<String>();
    public static void loadBadWords(String path) throws FileNotFoundException, IOException {
        RandomAccessFile fin=new RandomAccessFile(path,"r");
        String line="";
        while(true)
        {
        line=fin.readLine();
        if(line==null)break;
        String[] cols=line.split("\t");
        
pw.add(cols[0]);
System.out.println(cols[0]);
        }
    }
    
}
