import java.io.*;
import java.security.MessageDigest;
public class temp {
    public static byte[] SHA1Checksum(InputStream is) throws Exception {
        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("SHA-1");
        int numRead = 0;
        do {
            numRead = is.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);
        is.close();
        return complete.digest();
    }

    public static void dfs(String path) {
        File dir = new File(path);
        File[] fs = dir.listFiles();
        for (int i = 0; i < fs.length; i++) {
            if(fs[i].isFile()) {
                System.out.println("file " + fs[i].getName());
                dfs(path + File.separator + fs[i].getName());
            }
        }
    }

    public static void main(String [] args) {
        String path = "C:\\A - Sync\\OneDrive - pku.edu.cn\\G\\01_Markdown";
        dfs(path);
    }
}