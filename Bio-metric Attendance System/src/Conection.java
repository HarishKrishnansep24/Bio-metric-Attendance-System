
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Conection {
Socket requestSocket;
ObjectOutputStream out;
ObjectInputStream in;
String message;

Conection() {
}

void run() throws IOException {
    try {
        // 1. creating a socket to connect to the server
        requestSocket = new Socket("192.168.1.1", 4370);
        System.out.println("Connected to given host in port 4370");
        // 2. get Input and Output streams
        in = new ObjectInputStream(requestSocket.getInputStream());
        // 3: Communicating with the server
        String line;
        while (true) {
            line = in.readLine();
            if (line != null) {
                System.out.println(line);
            }
        }
    } catch (UnknownHostException unknownHost) {
        System.err.println("You are trying to connect to an unknown host!");

    } catch (IOException ioException) {
        ioException.printStackTrace();

    } catch (Exception Exception) {
        Exception.printStackTrace();

    }// finally {
       // in.close();
       // requestSocket.close();
    //}
}

void sendMessage(String msg) {
    try {
        out.writeObject(msg);
        out.flush();
        System.out.println("client: " + msg);

    } catch (IOException ioException) {
        ioException.printStackTrace();
    }
}
public void enroll ( Template Fingerprint )  {
  Conection c=new Conection();
       ObjectInputStream in = null;
       Connectivity con=new Connectivity();
            Connection conn=null;
            conn=con.getvalue();
            PreparedStatement ps;
       
        //Inserts the template on the database
        
            String line = null;
            while (true) {
            if (line != null) {
                System.out.println(line);
            }
             try {
            String sql="insert into stu_details(Fingerprint) values(line)";
           System.out.println("Inserted");
               ps=conn.prepareStatement(sql);
         
          //  sql.setBinaryStream(1,new ByteArrayInputStream(Fingerprint.getd()), line.getBytes().length);
          // sql.executeUpdate();
              ps.executeUpdate();
             } 
        catch (SQLException ex) {
               Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
}

public static void main(String args[]) throws IOException {
    Conection client = new Conection();
    client.run();
    }
          
}
