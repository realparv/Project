
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Redclient {
    public static void main(String []agrs){

        try{
        System.out.println("Client Started.....");
        
        Socket soc=new Socket("localhost",9002);
        //this bufferreader is used from keyboard
        BufferedReader userInput =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Start chating......");
        String str=userInput.readLine();
    
        PrintWriter output=new PrintWriter(soc.getOutputStream(),true);
        output.println(str);
    
        //read the data which server send and display on the screen
        BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
        System.out.println(in.readLine());
    
        }catch(Exception e){
            e.printStackTrace();
            }
    
    
        }
}
