package bt2;

    import java.io.*;
public class Main {
        public static void main(String[] args) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                // Nhập tên tệp tin nguồn
                System.out.print("Nhập tên tệp tin nguồn: ");
                String sourceFilePath = reader.readLine();

                // Kiểm tra xem tệp tin nguồn có tồn tại hay không
                File sourceFile = new File(sourceFilePath);
                if (!sourceFile.exists()) {
                    System.out.println("Tệp tin nguồn không tồn tại.");
                    return;
                }

                // Nhập tên tệp tin đích
                System.out.print("Nhập tên tệp tin đích: ");
                String targetFilePath = reader.readLine();

                // Kiểm tra xem tệp tin đích đã tồn tại hay không
                File targetFile = new File(targetFilePath);
                if (targetFile.exists()) {
                    System.out.println("Tệp tin đích đã tồn tại.");
                    return;
                }

                // Sao chép nội dung từ tệp tin nguồn sang tệp tin đích
                FileInputStream fileInputStream = new FileInputStream(sourceFile);
                FileOutputStream fileOutputStream = new FileOutputStream(targetFile);

                int byteData;
                int totalBytesCopied = 0;

                while ((byteData = fileInputStream.read()) != -1) {
                    fileOutputStream.write(byteData);
                    totalBytesCopied++;
                }

                fileInputStream.close();
                fileOutputStream.close();

                // Hiển thị số byte đã sao chép
                System.out.println("Đã sao chép " + totalBytesCopied + " byte.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
