package ftpclient;


import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

public class FTPListDemo {
    public static void main(String[] args) {
        FTPClient byFlyClient = new FTPClient();

        try {
            byFlyClient.connect("ftp.byfly.by");
            byFlyClient.login("anonymous", "anonymous");

            if (byFlyClient.isConnected()) {
                // Получение списка файлов и директорий первого уровня. Если отсутствуют - возвращается пустой массив.
                String[] dirNames = byFlyClient.listNames();
                for (String name : dirNames) {
                    System.out.println("Name = " + name);
                }

                FTPFile[] ftpFiles = byFlyClient.listFiles();
                for (FTPFile ftpFile : ftpFiles) {

                    if (ftpFile.getType() == FTPFile.FILE_TYPE) {
                        System.out.printf("FTPFile: %s; %s%n",
                                ftpFile.getName(),
                                FileUtils.byteCountToDisplaySize(ftpFile.getSize()));
                    }
                }
            }
            byFlyClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byFlyClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


