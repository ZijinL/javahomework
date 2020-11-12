import java.io.*;
import java.util.*;
import java.security.MessageDigest;

public class hashDirectory {

    // 计算单个文件的哈希值
    public static String SHA1Checksum(File f) throws Exception {
        FileInputStream is = new FileInputStream(f);
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
        return digestToString(complete);
    }

    // 计算字符串类型的哈希值
    public static String SHA1Checksum4Str(String str) throws Exception {
        MessageDigest complete = MessageDigest.getInstance("SHA-1");
        complete.update(str.getBytes());
        return digestToString(complete);
    }

    // 计算文件夹的哈希值
    public static String SHA1Checksum4Dir(String path) throws Exception {
        File dir = new File(path);
        File[] fs = dir.listFiles();

        // 如果为空则返回空，否则对文件夹目录排序
        if (fs==null) {return null;}
        else {Arrays.sort(fs);}

        String str = "";
        // 对文件夹内容进行遍历
        for (File f: fs) {
            // 如果是文件，则将文件名和文件哈希值作为该文件夹的内容临时存放
            if (f.isFile()) {
                str += f.getName();
                str += SHA1Checksum(f);
            }
            // 如果是文件夹，则将文件夹名和文件夹哈希值作为该文件夹的内容临时存放
            if (f.isDirectory()) {
                str += f.getName();
                str += SHA1Checksum4Dir(path + File.separator + f.getName());
            }
        }
        // 将上述临时存放的内容一起进行哈希计算，得到文件夹的哈希值
        return SHA1Checksum4Str(str);
    }

    // 将MessageDigest类型的值返回成所需要的16进制字符串
    public static String digestToString(MessageDigest complete) {
        byte[] sha1 = complete.digest();
        String result = "";
        for (byte each : sha1) {result += Integer.toString(each&0xFF, 16);}
        return result;
    }
    
    public static void main(String [] args) {
        // String path = "C:\\A - Sync\\OneDrive - pku.edu.cn\\test";
        // 自定义输入的路径
        Scanner input = new Scanner(System.in);
        System.out.print("\nPls enter the path: ");
        String path = input.nextLine();
        input.close();

        // 测试文件夹哈希值计算函数
        try {
            System.out.print("\nSHA-1: ");
            System.out.println(SHA1Checksum4Dir(path));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}