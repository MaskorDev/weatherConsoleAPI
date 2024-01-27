package Response;


import DTO.CurrentResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Application {
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        JsonPlaceholderApi api = JsonPlaceHolderService.getInstance().api();

        System.out.println("Приветствую в приложении \"Weather API Console App\"");
        System.out.print("Введите название города, где вас интересует погода: ");
        String city = scanner.nextLine();
        Response<List<CurrentResponse>> response = api.posts(city).execute();
        System.out.println(response.isSuccessful());

    }
}
