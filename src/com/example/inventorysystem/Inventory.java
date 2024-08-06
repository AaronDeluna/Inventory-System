package com.example.inventorysystem;

import java.util.Scanner;

public class Inventory {
    private int arraySize = 10;
    private int count = 0;
    private Product[] products = new Product[arraySize];
    Scanner scanner = new Scanner(System.in);

    // добавляет новый товар в инвентарь
    public void addProduct(Product product) {
        if (count == products.length) {
            arraySize = arraySize * 2;
            Product[] newProducts = new Product[arraySize];
            System.arraycopy(products, 0, newProducts, 0, products.length);
            products = newProducts;
        }
        if (!product.getName().isEmpty() && product.getId() >= 0) {
            products[count++] = product;
        } else {
            System.out.println("Ошибка данных");
        }
    }

    //Обнавляет товар
    public void updateProduct(int id) {
        for (int i = 0; i < count; i++) {
            if (products[i] != null && id == products[i].getId()) {
                System.out.println("Нашли ваш товар!");
                System.out.printf("id: %s, Название: %s, Цена: %s, Количество: %s\n",
                        products[i].getId(), products[i].getName(), products[i].getPrice(), products[i].getQuantity());
                exit:
                while (true) {
                    System.out.println("""
                            Что вы хотите изменить:\s
                            1. id
                            2. Название
                            3. Ценна
                            4. Количество
                            """);
                    int command = scanner.nextInt();
                    switch (command) {
                        case 1 -> {
                            System.out.printf("Введите новое id для продукта \" %s \", название: \" %s \":\n", products[i].getId(), products[i].getName());
                            int newProductId = scanner.nextInt();
                            products[i].setId(newProductId);
                            System.out.println("Id Успешно изменено на: " + newProductId);
                            break exit;
                        }
                        case 2 -> {
                            System.out.printf("Введите новое название для продукта название сейчас: \" %s \":\n", products[i].getName());
                            String newProductName = scanner.next();
                            products[i].setName(newProductName);
                            System.out.println("Название успешно изменено на: " + newProductName);
                            break exit;
                        }
                        case 3 -> {
                            System.out.printf("Введите новую цену для продукта: \" %s \", Цена сейчас: \" %s \"\n", products[i].getName(), products[i].getPrice());
                            double newProductPrice = scanner.nextDouble();
                            products[i].setPrice(newProductPrice);
                            System.out.println("Цена успешно изменена на: " + newProductPrice);
                            break exit;
                        }
                        case 4 -> {
                            System.out.printf("Введите новое количество для продукта: \" %s \", количество сейчас: \" %s \"\n", products[i].getName(), products[i].getQuantity());
                            int newProductQuantity = scanner.nextInt();
                            products[i].setQuantity(newProductQuantity);
                            System.out.println("Количество успешно изменено на: " + newProductQuantity);
                            break exit;
                        }
                        default -> System.out.println("Не верно выбрали команду! попробуйте еще раз");
                    }
                    return;
                }
            }
        }
        System.out.println("Товар не найден!");
    }

    //    удаляет товар по его id
    public void removeProduct(int id) {

    }

    public void listAllProducts() {
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
    }
}
