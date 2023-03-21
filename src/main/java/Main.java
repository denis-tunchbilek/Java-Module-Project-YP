import java.util.Scanner;

class Calculater {
    String names = "Добавленные товары:";
    int count;
    double result;
    String resultStr;
    double sum = 0;

    void add(double price, String name) {
        names = names + "\n" + name;
        sum += price;
    }

    void getResult() {
        result = sum / count;

    }

    void resultReformString() {
        resultStr = String.format("%.2f", result);
    }
}

class Formatter {
    String wordForm = "";

    void reform(double price) {
        if (price >= 11 & price <= 19) {
            wordForm = "рублей";
        } else {
            int ostatok = (int) Math.floor(price % 10);
            if (ostatok == 1) {
                wordForm = "рубль";
            } else if (ostatok >= 2 & ostatok <= 4) {
                wordForm = "рубля";
            } else if (ostatok >= 5 & ostatok <= 9 | ostatok == 0) {
                wordForm = "рублей";

            }
        }
    }
}


public class Main {


    public static void main(String[] args) {
        String trash;
        Calculater calculate = new Calculater();
        Formatter format = new Formatter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество посетителей:");
        while (true) {

            if (!scanner.hasNextInt()) {
                System.out.println("Это не число, попробуйте еще раз:");
                scanner.nextLine();
            } else {
                calculate.count = scanner.nextInt();
                if (calculate.count < 1) {
                    System.out.println("Вы ввели некоректное количество человек, попробуйте ещё раз:");
                } else {
                    break;
                }


            }
        }
        String end = "";
        while (!end.equalsIgnoreCase("завершить")) {
            System.out.println("Введите название и  стоимость товара");
            String name = scanner.next();
            double price;
            while (true) {
                while (!scanner.hasNextDouble()) {
                    System.out.println("Это не число с плавующией точкой, попробуйте еще раз:");
                    trash = scanner.next();
                }
                price = scanner.nextDouble();
                if (price < 0) {
                    System.out.println("Цена не может быть отрицательной попробуйте ещё раз:");
                } else {
                    break;
                }
            }
            calculate.add(price, name);
            System.out.println("Хотели бы вы добавить еще товар? Введите любой символ для продолжения. Если нет, напишите 'Завершить':");
            end = scanner.next();
        }
        System.out.println(calculate.names);
        calculate.getResult();
        calculate.resultReformString();
        format.reform(calculate.result);
        System.out.println("Каждый человек должен заплатить" + calculate.resultStr + format.wordForm);
        // ваш код начнется здесь
        // вы не должы ограничиваться только классом Main и можете создавать свои классы по необходимости

    }
}
