import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.TreeSet;

public class NagativeWords {
   public static TreeSet<String> nw=new TreeSet<String>();
    public static void loadNagativeWords(String path) throws FileNotFoundException, IOException {
        RandomAccessFile fin=new RandomAccessFile(path,"r");
        String line="";
        while(true)
        {
        line=fin.readLine();
        if(line==null)break;
        String[] cols=line.split("\t");
        
nw.add(cols[0]);
//System.out.println(cols[0]);
        }
    }
    
}