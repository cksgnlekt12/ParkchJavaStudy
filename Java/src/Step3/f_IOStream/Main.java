package Step3.f_IOStream;

import java.io.*;

public class Main {
    public static void main(String[] args){
        /**
         * 대상 기준 : 입력 스트림 / 출력 스트림
            입력 스트림
            FileInputStream, FileReader, BufferedInputStream, BufferedReader 등
            출력 스트림
            FileOutputStream, FileWriter, BufferedOutputStream, BufferedWriter 등

         * 자료의 종류 : 바이트 스트림 / 문자 스트림
             바이트 스트림
             FileInputStream, FileOutputStream, BufferedInputStream, BufferedOutputStream 등
             문자 스트림
             FileReader, FileWriter, BufferedReader, BufferedWriter 등

         * 기능 : 기반 스트림 / 보조 스트림
             기반 스트림
             FileInputStream, FileOutputStream, FileReader, FileWriter 등
             보조 스트림
             InputStreamReader, OutputStreamWriter, BufferedInputStream, BufferedOutputStream 등
         **/
        /** [1] 표준 입출력 시스템 (System) **/
        // System.in 써보기
//        System.out.println("알파벳 하나를 쓰고 [Enter]를 누르세요");
//
//        int i, ii;
//
//        try {
//            i = System.in.read();
//            //입력을 받는 부분. 문자 자체도 숫자로 구분되기 때문에 int 로 입력을 받는다
//            System.out.println(i);
//            System.out.println((char)i);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        // System.in 여러개 써보기
//        System.out.println("알파벳 여러 개를 쓰고 [Enter]를 누르세요");
//
//        try {
//            //여러 문자일 경우 \n(줄바꿈)을 만나기 전까지 while 문을 돌려서 출력해준다.
//            while( (ii = System.in.read()) != '\n' ) {
//                System.out.print((char)ii);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /** [2] 바이트 스트림 **/
        /* 클래스
        * FileInputStream :  파일에서 바이트 단위로 자료를 읽습니다.
        * ByteArrayInputStream : byte 배열 메모리에서 바이트 단위로 자료를 읽습니다.
        * FilterInputStream : 기반 스트림에서 자료를 읽을 때 추가 기능을 제공하는 보조 스트림의 상위 클래스
         */

        /* 메서드
        int read()
        입력 스트림으로부터 한 바이트의 자료를 읽습니다. 읽은 자료의 바이트 수를 반환합니다.
        int read(byte b[])
        입력 스트림으로 부터 b[] 크기의 자료를 b[]에 읽습니다. 읽은 자료의 바이트 수를 반환합니다.
        int read(byte b[], int off, int len)
        입력 스트림으로 부터 b[] 크기의 자료를 b[]의 off변수 위치부터 저장하며 len 만큼 읽습니다. 읽은 자료의 바이트 수를 반환합니다.
        void close()
        입력 스트림과 연결된 대상 리소스를 닫습니다.
         */

        FileInputStream fis = null;

        //파일에서 한 바이트씩 읽어오기
        try {
            fis = new FileInputStream("input.txt");

            System.out.println((char)fis.read());
            System.out.println((char)fis.read());
            System.out.println((char)fis.read());

        } catch (IOException e) {
            System.out.println(e);
        } finally{
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println(e);
            } catch (NullPointerException e){
                System.out.println(e);
            }
        }
        System.out.println("end");

        //파일의 끝까지 한 바이트씩 불러오기
        try(FileInputStream fis2 = new FileInputStream("Step3/f_IOStream/input.txt")){
            int i;
            while ( (i = fis.read()) != -1){
                System.out.println((char)i);
            }
            System.out.println("end");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //파일에서 바이트 배열로 자료 읽기
        try (FileInputStream fis3 = new FileInputStream("input2.txt")){

            byte[] bs = new byte[10];
            int i;
            while ( (i = fis.read(bs)) != -1){
				/*for(byte b : bs){
					System.out.print((char)b);
				}*/
                for(int k= 0; k<i; k++){
                    System.out.print((char)bs[k]);
                }
                System.out.println(": " +i + "바이트 읽음" );
            }

			/*while ( (i = fis.read(bs, 1, 9)) != -1){
				for(int k= 0; k<i; k++){
					System.out.print((char)bs[k]);
				}
				System.out.println(": " +i + "바이트 읽음" );
			}*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");
        /*
        flush() 와 close() 메서드
        출력 버퍼를 비울때 flush() 메서드를 사용
        close() 메서드 내부에서 flush()가 호출되므로 close()메서드가 호출되면 출력 버퍼가 비워짐
         */

        /** [3] 문자 스트림 **/

        try(FileWriter fw = new FileWriter("writer.txt")){
            fw.write('A');    // 문자 하나 출력
            char buf[] = {'B','C','D','E','F','G'};

            fw.write(buf); //문자 배열 출력
            fw.write("안녕하세요. 잘 써지네요"); //String 출력
            fw.write(buf, 1, 2); //문자 배열의 일부 출력
            fw.write("65");  //숫자를 그대로 출력
        }catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("출력이 완료되었습니다.");

        /** [4] 보조 스트림 **/
        long millisecond = 0;
        try(FileInputStream fis2 = new FileInputStream("a.zip");
            FileOutputStream fos = new FileOutputStream("copy.zip");
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos)){

            millisecond = System.currentTimeMillis();

            int i;
            while( ( i = bis.read()) != -1){
                bos.write(i);
            }

            millisecond = System.currentTimeMillis() - millisecond;
        }catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("파일 복사 하는 데 " + millisecond + " milliseconds 소요되었습니다.");

        try(FileOutputStream fos = new FileOutputStream("data.txt");
            DataOutputStream dos = new DataOutputStream(fos))
        {

            dos.writeByte(100);
            dos.writeChar('A');
            dos.writeInt(10);
            dos.writeFloat(3.14f);
            dos.writeUTF("Test");
        }catch(IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fis3 = new FileInputStream("data.txt");
            DataInputStream dis = new DataInputStream(fis))
        {

            System.out.println(dis.readByte());
            System.out.println(dis.readChar());
            System.out.println(dis.readInt());
            System.out.println(dis.readFloat());
            System.out.println(dis.readUTF());
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
