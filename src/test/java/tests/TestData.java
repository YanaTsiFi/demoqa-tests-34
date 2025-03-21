package tests;

import com.github.javafaker.Faker;
import utils.RandomUtils;
import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en-GB"));

    // Генерация случайных данных
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = RandomUtils.getRandomItemFromArray(new String[]{"Male", "Female", "Other"}),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            monthOfBirth = RandomUtils.getRandomItemFromArray(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2023)),
            subject = RandomUtils.getRandomItemFromArray(new String[]{"Maths", "Physics", "Chemistry", "Biology"}),
            hobby = RandomUtils.getRandomItemFromArray(new String[]{"Sports", "Reading", "Music"}),
            picture = "images/image.jpg",
            currentAddress = faker.address().fullAddress(),
            state = RandomUtils.getRandomItemFromArray(new String[]{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"}),
            city = getCityByState(state);

    // Метод для получения города по выбранному штату
    public static String getCityByState(String state) {
        return switch (state) {
            case "NCR" -> RandomUtils.getRandomItemFromArray(new String[]{"Delhi", "Gurgaon", "Noida"});
            case "Uttar Pradesh" -> RandomUtils.getRandomItemFromArray(new String[]{"Agra", "Lucknow", "Merrut"});
            case "Haryana" -> RandomUtils.getRandomItemFromArray(new String[]{"Karnal", "Panipat"});
            case "Rajasthan" -> RandomUtils.getRandomItemFromArray(new String[]{"Jaipur", "Jaiselmer"});
            default -> "";
        };
    }
}