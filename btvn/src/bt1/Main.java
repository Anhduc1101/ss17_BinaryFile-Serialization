package bt1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int choice;


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        List<Product> products = new ArrayList<>();
        while (true) {
            System.out.println("********* Menu *********");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("0. Thoát");
            System.out.println("Mời lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            handleChoice(products);
        }
    }

    private static void handleChoice(List<Product> products) {
        switch (choice) {
            case 1:
                Product pro = new Product();
                System.out.println("Nhập tên sản phẩm: ");
                String proName = scanner.nextLine();
                pro.setProductName(proName);
                System.out.println("Nhập tên nhà sản xuất: ");
                String manName = scanner.nextLine();
                pro.setProducer(manName);
                System.out.println("Nhập giá: ");
                double cost = Double.parseDouble(scanner.nextLine());
                pro.setCost(cost);
                System.out.println("Nhập mô tả: ");
                String des = scanner.nextLine();
                pro.setDescription(des);
                products.add(pro);
                writeFile(products);
                break;
            case 2:
                readFile();
                for (Product pros : products) {
                    System.out.println(pros.toString());
                }
                break;
            case 3:
                System.out.println("Nhập tên sản phẩm cần tìm kiếm: ");
                String inputName = scanner.nextLine();
                boolean check=false;
                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getProductName().toLowerCase().contains(inputName.toLowerCase())) {
                        readFile();
                        System.out.println(products.get(i));
                        check=true;
//                        break;
                    }
                }
                if(!check){
                    System.out.println("không có sản phẩm này!");
                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void writeFile(List<Product> products) {
        File file = new File("btvn/src/bt1/product.dat");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Product> readFile() {
        File file = new File("btvn/src/bt1/product.dat");
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream oif = new ObjectInputStream(fis);
            products = (List<Product>) oif.readObject();
            fis.close();
            oif.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

}
