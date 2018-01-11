package articleChanger;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

public class FTPConnect extends FTPClient{

    private FTPClient ftpClient;            // = new FTPClient();

    public FTPConnect() {
        this.ftpClient = new FTPClient();
    }

    public void connect() {

        try {
            ftpClient.connect("ox.netinfocompany.bg");
            boolean login = ftpClient.login("banners", "fT&3-w");
            if (login) {

                System.out.println("Connection established...");
                //System.out.println("Status: "+ftpClient.getStatus());
//                System.out.println(ftpClient.changeWorkingDirectory("/banners/HTML5/777/Natives"));
//                System.out.println(ftpClient.printWorkingDirectory());
                //ftpClient.remoteStore("C:\\Users\\Holy\\Desktop\\Code.js");

            } else {

                System.out.println("Connection fail...");
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean changeWorkingDirectory(String pathname) throws IOException {
        return this.ftpClient.changeWorkingDirectory(pathname);
    }

    @Override
    public FTPFile[] listFiles() throws IOException {
        return this.ftpClient.listFiles();
    }

    @Override
    public boolean storeFile(String remote, InputStream local) throws IOException {
        return this.ftpClient.storeFile(remote, local);
    }

    @Override
    public boolean makeDirectory(String pathname) throws IOException {
        return this.ftpClient.makeDirectory(pathname);
    }

    @Override
    public boolean storeUniqueFile(InputStream local) throws IOException {
        return this.ftpClient.storeUniqueFile(local);
    }

    public void disconnect() throws IOException {

        try {
            boolean logout = ftpClient.logout();
            if (logout) {
                System.out.println("Connection close...");
            } else {
                System.out.println("You are not connected!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
