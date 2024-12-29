package Data;

public class DataClass {

    //TODO: Personal Information
    public static class PersonalInformation {
        public static String userName = JsonDataReader.getData("Name");
        public static String password = JsonDataReader.getData("Password");
        public static String firstName = JsonDataReader.getData("FirstName");
        public static String lastName = JsonDataReader.getData("LastName");
        public static String day = JsonDataReader.getData("Day");
        public static String month = JsonDataReader.getData("Month");
        public static String year = JsonDataReader.getData("Year");
    }

    //TODO: Contact Information
    public static class ContactInformation {

        public static String emailOne = JsonDataReader.randomEmail();
        public static String emailTwo = JsonDataReader.randomEmail();
        public static String mobileNumber = JsonDataReader.getData("MobileNumber");
        public static String inValidEmail = JsonDataReader.getData("inValidEmail");
    }

    //TODO: Address Information
    public static class AddressInformation {
        public static String address = JsonDataReader.getData("Address");
        public static String country = JsonDataReader.getData("Country");
        public static String state = JsonDataReader.getData("State");
        public static String city = JsonDataReader.getData("City");
        public static String zipCode = JsonDataReader.getData("ZipCode");
    }

    //TODO: Message Information
    public static class MessageInformation {
        public static String subject = JsonDataReader.getData("Subject");
        public static String userMessage = JsonDataReader.getData("Message");
    }

    //TODO: Product Information
    public static class ProductInformation {
        public static String productName = JsonDataReader.getData("ProductName");
        public static String productQuantity = JsonDataReader.getData("ProductQuantity");
    }

    //TODO: Card Information
    public static class CardInformation {
        public static String CardName = JsonDataReader.getCardData("CardName");
        public static String CardNumber = JsonDataReader.getCardData("CardNumber");
        public static String CVC = JsonDataReader.getCardData("CVC");
        public static String Expiry_Month = JsonDataReader.getCardData("Expiry_Month");
        public static String Expiry_Year = JsonDataReader.getCardData("Expiry_Year");
    }
}


