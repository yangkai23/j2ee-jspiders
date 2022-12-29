

/**
 *
 * @author ranganath
 */
public class Classification {
    
    public static ClusterDomain doClassification(String filename,String text)
    {
    WordCluster cluster=new ConstructWordCluster().constructWordCluster();
ClusterDomain bestdomain=new ClusterDomain();
bestdomain.setDomain("Missellanous");
     int similary=0;

    for(int i=0;i<cluster.cluster.size();i++)
    {
        ClusterDomain temp=cluster.cluster.get(i);
        int domainid=cluster.cluster.get(i).getDomainid();
        String domianname=cluster.cluster.get(i).getDomain();
        System.out.println("Domain ID: "+domainid+" - Domain Name: "+domianname);
            int max=0;

  for(int j=0;j<cluster.cluster.get(i).getWords().size();j++)
    {
        String word=cluster.cluster.get(i).getWords().get(j);
        int wordWeight=FeatureExtraction.wordWeight(text.toUpperCase(),word.toUpperCase());
       
        
        cluster.cluster.get(i).getWeights().set(j,wordWeight);
        System.out.println("Word :"+word+"\t+Weight :"+wordWeight);
        
       
            max+=wordWeight;
     }
 System.out.println("Document Similarity :\t+Weight :"+max);
        if(similary<max)
        {
            similary+=max;
            bestdomain=temp;
        }
    
}
return bestdomain;
    }

}
