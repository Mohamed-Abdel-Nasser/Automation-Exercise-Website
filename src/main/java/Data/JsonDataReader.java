package Data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonDataReader {
    private static final String DATA_PATH = "src/test/java/DataForTest/Data.json";
    private static final String CARD_DATA_PATH = "src/test/java/DataForTest/CardData.json";
    private static final Logger LOGGER = Logger.getLogger(JsonDataReader.class.getName());


    // Method to fetch data from the main JSON file
    public static String getData(String keyName) {
        JSONObject jsonObject = readJsonFile(DATA_PATH);
        return getValueFromJson(jsonObject, keyName);
    }

    // Method to fetch card data from the card data JSON file
    public static String getCardData(String keyName) {
        JSONObject jsonObject = readJsonFile(CARD_DATA_PATH);
        return getValueFromJson(jsonObject, keyName);
    }

    // Helper method to read JSON data from a given file path
    private static JSONObject readJsonFile(String filePath) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);
            return (JSONObject) obj;
        } catch (IOException | ParseException e) {
            String errorMessage = String.format("Error occurred while reading JSON file: %s", filePath);
            LOGGER.log(Level.SEVERE, errorMessage, e);
            throw new RuntimeException(errorMessage, e); // Throw RuntimeException with the error message
        }
    }

    // Helper method to extract value from a JSON object using the key
    private static String getValueFromJson(JSONObject jsonObject, String keyName) {
        if (jsonObject.containsKey(keyName)) {
            return (String) jsonObject.get(keyName);
        } else {
            String errorMessage = String.format("Key not found: %s", keyName);
            LOGGER.log(Level.WARNING, errorMessage);
            throw new RuntimeException(errorMessage); // Throw RuntimeException with the error message
        }
    }

    // Method to generate a random email
    public static String randomEmail() {
        String digits = "1234567890";
        int userNameLength = 7;
        try {
            StringBuilder userName = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < userNameLength; i++) {
                int index = random.nextInt(digits.length());
                userName.append(digits.charAt(index));
            }
            String email = "test" + userName + "@test.com";
            LOGGER.log(Level.INFO, "Random email generated: {0}", email);
            return email;
        } catch (Exception e) {
            String errorMessage = "Error occurred while generating random email.";
            LOGGER.log(Level.SEVERE, errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }
}

