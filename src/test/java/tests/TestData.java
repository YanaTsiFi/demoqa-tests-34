package tests;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en-GB"));

    // Генерация случайных данных
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2023)),
            subject = faker.options().option("Maths", "Physics", "Chemistry", "Biology"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            picture = "images/image.jpg",
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getCityByState(state);

    // Метод для получения города по выбранному штату
    public static String getCityByState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "";
        };
    }
}