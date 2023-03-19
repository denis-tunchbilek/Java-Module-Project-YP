import java.util.Scanner;


public class Main {
    public static class Calculater {
        String names = "Добавленные товары:";
        double sum = 0;
        void add(double price, String name){
            names = names + "\n" + name;
            sum += price;
        }
    }


    public static void main(String[] args) {
        String trash;
        Calculater calculate = new Calculater();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {

            while (!scanner.hasNextInt()){
                trash = scanner.nextLine();
                System.out.println("Это не число, попробуйте еще раз:");
            }
            count = scanner.nextInt();
            if (count < 1){
                System.out.println("Вы ввели некоректное количество человек, попробуйте ещё раз:");
            }else{
                break;
            }


        }
        String end = "";
        while (!end.equalsIgnoreCase("завершить")){
            System.out.println("Введите название и  стоимость товара");
            trash = scanner.nextLine();
            String name = scanner.nextLine();
            double price;
            while (true) {
                while (!scanner.hasNextDouble()){
                    trash = scanner.nextLine();
                    System.out.println("Это не число с плавующией точкой, попробуйте еще раз:");
                }
                price = scanner.nextDouble();
                if (price < 0){
                    System.out.println("Цена не может быть отрицательной попробуйте ещё раз:");
                }else{
                    break;
                }
            }
            calculate.add(price, name);
            System.out.println("Хотели бы вы добавить еще товар если нет напишите 'Завершить':");
            trash = scanner.nextLine();
            end = scanner.nextLine();
        }
        calculate.sum = calculate.sum / count;
        String resultSum = String.format("%.2f", calculate.sum);
        String wordForm = "";
        if (calculate.sum < 2){
            wordForm = "рубль";

        } else if (calculate.sum < 5) {
            wordForm = "рубля";
        }else {
            wordForm = "рублей";
        }
        System.out.println(calculate.names);
        System.out.println("Каждый человек должен заплатить" + resultSum + wordForm);
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

    }
}