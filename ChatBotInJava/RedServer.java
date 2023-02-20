
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RedServer{
    
public static void main(String []args){
  
    try{  
        System.out.println("Waiting for client.....");
        ServerSocket ss= new ServerSocket(9002);
        Socket soc = ss.accept();
        System.out.println("Connection establishing...");
        //buffereader is used for reading data from  sockets input streams 
        BufferedReader input =new BufferedReader(new InputStreamReader(soc.getInputStream()));
        String str=input.readLine();
        // sending streing back to the client 
        PrintWriter output=new PrintWriter(soc.getOutputStream(),true);
        // output.println("Server:" +str);
        if(str.equals("hi")|| str.equals("Hi")||str.equals("hello")||str.equals("Hello")){
            output.println("Server: Namaste");
        }
        else if(str.equals("how are you")|| str.equals("How are you")){
            output.println("Server: I'm Good");
        }
        else if(str.equals("Open notepad")|| str.equals("open notepad")|| str.equals("notepad")|| str.equals("Notepad")){
            Runtime rn=Runtime.getRuntime();
            output.println("Server: Opening...");
            rn.exec("notepad");
        }
        

    }
    catch(Exception e){
        e.printStackTrace();
    }
}
}