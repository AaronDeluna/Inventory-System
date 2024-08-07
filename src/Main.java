import com.example.inventorysystem.Inventory;
import com.example.inventorysystem.Product;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать!\n");
        exit:
        while (true) {
            System.out.println("Общее количество товара: " + Product.totalProducts);
            System.out.println("1. Добавить товар");
            System.out.println("2. Обновить товар");
            System.out.println("3. Удалить товар");
            System.out.println("4. Просмотреть список товаров");
            System.out.println("5. Выйти");
            System.out.println("Выберите действие:");
            int command = scanner.nextInt();

            switch (command) {
                case 1 -> addProductMenu();
                case 2 -> updateProductMenu();
                case 3 -> removeProductMenu();
                case 4 -> inventory.listAllProducts();
                case 5 -> {
                    System.out.println("Всего доброго! Будем вас ждать");
                    break exit;
                }
                default -> System.out.println("Введена не верная команда! Попробуйте еще раз");
            }
        }
    }

    private static void addProductMenu() {
        System.out.println("Введите название товара: ");
        String productName = scanner.next();
        System.out.println("Введите цену товара: ");
        double productPrice = scanner.nextDouble();
        System.out.println("Введите количество товара: ");
        int productQuantity = scanner.nextInt();
        inventory.addProduct(new Product(Product.generateId(), productName, productPrice, productQuantity));
        System.out.println("\nТовар успешно добавлен!\n");
    }

    private static void updateProductMenu() {
        System.out.println("Введите уникальный номер товара: ");
        int productId = scanner.nextInt();
        inventory.updateProduct(productId);
    }

    private static void removeProductMenu() {
        System.out.println("Введите уникальный номер товара хотите удалить:");
        int productId = scanner.nextInt();
        inventory.removeProduct(productId);
    }
}