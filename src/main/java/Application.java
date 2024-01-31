import DTO.Current;
import DTO.CurrentResponse;
import retrofit2.Response;
import Response.JsonPlaceHolderService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        System.out.println("Приветствую в приложении \"Weather API Console App\"");
        while (true) {
            System.out.print("Введите название города, где вас интересует погода: ");
            String city = scanner.nextLine();

            if (Objects.equals(city.toLowerCase(), "стоп")) {
                break;
            }
            Response<CurrentResponse> response =
                        JsonPlaceHolderService.instance().posts("c4b4b97b53db4ec29c172030242701", city).execute();
            if (response.isSuccessful()) {
                Current current = response.body().getCurrent();
                System.out.println("Температура в городе " + city + ": " + current.getTemp_c() + "\nОщущается как: " + current.getFeelslike_c());
                System.out.println("Если хотите завершить выполнение программы, то введите \"Стоп\"\n");
            } else {
                System.out.println("Такого города не обнаружено");
            }
        }
    }
}
