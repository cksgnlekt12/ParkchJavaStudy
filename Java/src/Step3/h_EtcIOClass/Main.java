package Step3.h_EtcIOClass;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) throws IOException {
        /** [1] File 클래스 **/
        File file = new File("D:\\JAVA_LAB\\Chapter6\\newFile.txt");
        file.createNewFile();

        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());

        file.delete();

        /** [2] RandomAccessFile 클래스 **/
        RandomAccessFile rf = new RandomAccessFile("random.txt", "rw");
        rf.writeInt(100);
        System.out.println("파일 포인터 위치:" + rf.getFilePointer());
        rf.writeDouble(3.14);
        System.out.println("파일 포인터 위치:" + rf.getFilePointer());
        rf.writeUTF("안녕하세요");
        System.out.println("파일 포인터 위치:" + rf.getFilePointer());

        rf.seek(0);
        System.out.println("파일 포인터 위치:" + rf.getFilePointer());

        int i = rf.readInt();
        double d = rf.readDouble();
        String str = rf.readUTF();

        System.out.println("파일 포인터 위치:" + rf.getFilePointer());
        System.out.println(i);
        System.out.println(d);
        System.out.println(str);

    }
}
