// dev branch for Y.Practicum
public class Calculater {
    String names = "Добавленные товары:";
    double sum = 0;

    void add(double price, String name) {
        names = names + "\n" + name;
        sum += price;
    }
}
