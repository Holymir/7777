package articleChanger;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {


        //FTPConnect connect = new FTPConnect();
        //connect.connect();
        //System.out.println(connect.changeWorkingDirectory("/banners/HTML5/777/Natives"));
        //System.out.println(connect.listFiles().toString());

        File file = new File("C:\\Users\\Holy\\Desktop\\Code.js");

        BufferedWriter writer = new BufferedWriter( new FileWriter(file));
        writer.write("kor");
        writer.close();





    }
}
