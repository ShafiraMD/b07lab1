public class Driver2{
    public static void main(String[]args) throws Exceptions{
    File f = new File("C:\\Users\\Shafiramd\\Downloads");
    if(f.isDirectory()){
        File [] files = f.listFiles();
        //for(int i=0; i<files.length ; i++){
        //    System.out.println(files[i].getName());
        //}
        for(File x:files){
            System.out.println(x.getName());
        }

    //BufferedReader
    
    BufferedReader input = new BufferedReader(new FileReader("C:\\"));
    String line = input.readLine();
    while(line!=null){
        System.out.println(line);
        line = input.readLine();
    }

        
    }
}
}



