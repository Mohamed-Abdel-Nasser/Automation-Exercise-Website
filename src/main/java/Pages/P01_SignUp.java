package Pages;

import Data.DataClass;
import Utilities.Actions.ElementsActions;
import Utilities.BrowserSetUp.BrowserDriverFactory;
import Utilities.LOGGER.LogManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_SignUp extends BrowserDriverFactory {

    private static final By NAME_FIELD = By.xpath("//input[@name='name']");
    private static final By EMAIL_ADDRESS_FIELD = By.xpath("//input[@data-qa='signup-email']");
    private static final By SIGNUP_BUTTON = By.xpath("//button[@data-qa='signup-button']");
    private static final By TITLE_ICON = By.id("id_gender1");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By DAYS_DROPDOWN = By.id("days");
    private static final By MONTHS_DROPDOWN = By.id("months");
    private static final By YEARS_DROPDOWN = By.id("years");
    private static final By FIRST_NAME_FIELD = By.id("first_name");
    private static final By LAST_NAME_FIELD = By.id("last_name");
    private static final By ADDRESS_FIELD = By.id("address1");
    private static final By COUNTRY_DROPDOWN = By.id("country");
    private static final By STATE_FIELD = By.id("state");
    private static final By CITY_FIELD = By.id("city");
    private static final By ZIPCODE_FIELD = By.id("zipcode");
    private static final By MOBILE_NUMBER_FIELD = By.id("mobile_number");
    private static final By CREATE_ACCOUNT_BUTTON = By.xpath("//button[@data-qa='create-account']");
    private static final By CONTINUE_BUTTON = By.xpath("//a[@data-qa='continue-button']");
    private static final By ACCOUNT_CREATED_MESSAGE = By.xpath("//b[text()='Account Created!']");
    private static final By EMAIL_EXIST_VALIDATION_MESSAGE = By.xpath("//p[text()='Email Address already exist!']");

    private static final LogManager LOGGER = LogManager.getInstance();

    public P01_SignUp(WebDriver driver) {
        super(driver);
    }

    public P01_SignUp enterNameField(String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                String errorMessage = "Name cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.sendText(NAME_FIELD, name);
            String successMessage = String.format("Successfully entered name: %s", name);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter name: %s. Error: %s", name, e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp enterEmailAddress(String email) {
        try {
            if (email == null || email.trim().isEmpty()) {
                String errorMessage = "Email address cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.sendText(EMAIL_ADDRESS_FIELD, email);
            String successMessage = String.format("Successfully entered email: %s", email);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter email: %s. Error: %s", email, e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp clickSignupButton() {
        try {
            ElementsActions.clickElementByLocator(SIGNUP_BUTTON);
            String successMessage = "Successfully clicked the 'Sign Up' button.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = "Failed to click the 'Sign Up' button: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp selectTitle() {
        try {
            ElementsActions.clickElementByLocator(TITLE_ICON);
            String successMessage = "Successfully selected gender option.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = "Failed to click on gender option: " + e.getMessage();
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp enterPassword(String password) {
        try {
            if (password == null || password.trim().isEmpty()) {
                String errorMessage = "Password cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.sendText(PASSWORD_FIELD, password);
            String successMessage = String.format("Successfully entered password: %s", password);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter password. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp selectDateOfBirth_Days(String days) {
        try {
            if (days == null || days.trim().isEmpty()) {
                String errorMessage = "Day cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.selectFromDropdown(DAYS_DROPDOWN, days);
            String successMessage = String.format("Successfully selected day: %s", days);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to select day. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp selectDateOfBirth_Months(String months) {
        try {
            if (months == null || months.trim().isEmpty()) {
                String errorMessage = "Month cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.selectFromDropdown(MONTHS_DROPDOWN, months);
            String successMessage = String.format("Successfully selected month: %s", months);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to select month. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp selectDateOfBirth_Years(String years) {
        try {
            if (years == null || years.trim().isEmpty()) {
                String errorMessage = "Year cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.selectFromDropdown(YEARS_DROPDOWN, years);
            String successMessage = String.format("Successfully selected year: %s", years);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to select year. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp enterYourFirstName(String firstName) {
        try {
            if (firstName == null || firstName.trim().isEmpty()) {
                String errorMessage = "First name cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.sendText(FIRST_NAME_FIELD, firstName);
            String successMessage = String.format("Successfully entered first name: %s", firstName);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter first name. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp enterYourLastName(String lastName) {
        try {
            if (lastName == null || lastName.trim().isEmpty()) {
                String errorMessage = "Last name cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.sendText(LAST_NAME_FIELD, lastName);
            String successMessage = String.format("Successfully entered last name: %s", lastName);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter last name. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp enterYourAddress(String address) {
        try {
            if (address == null || address.trim().isEmpty()) {
                String errorMessage = "Address cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.sendText(ADDRESS_FIELD, address);
            String successMessage = String.format("Successfully entered address: %s", address);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter address. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp selectYourCountry(String country) {
        try {
            if (country == null || country.trim().isEmpty()) {
                String errorMessage = "Country cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.selectFromDropdown(COUNTRY_DROPDOWN, country);
            String successMessage = String.format("Successfully selected country: %s", country);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to select country. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp enterYourState(String state) {
        try {
            if (state == null || state.trim().isEmpty()) {
                String errorMessage = "State cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.sendText(STATE_FIELD, state);
            String successMessage = String.format("Successfully entered state: %s", state);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter state. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp enterYourCity(String city) {
        try {
            if (city == null || city.trim().isEmpty()) {
                String errorMessage = "City cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.sendText(CITY_FIELD, city);
            String successMessage = String.format("Successfully entered city: %s", city);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter city. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp enterYourZipcode(String zipcode) {
        try {
            if (zipcode == null || zipcode.trim().isEmpty()) {
                String errorMessage = "Zipcode cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.scrollToElement(ZIPCODE_FIELD);
            ElementsActions.sendText(ZIPCODE_FIELD, zipcode);
            String successMessage = String.format("Successfully entered zipcode: %s", zipcode);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter zipcode. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp enterYourMobileNumber(String mobileNumber) {
        try {
            if (mobileNumber == null || mobileNumber.trim().isEmpty()) {
                String errorMessage = "Mobile number cannot be null or empty.";
                LOGGER.error(errorMessage);
                Allure.step(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            ElementsActions.scrollToElement(MOBILE_NUMBER_FIELD);
            ElementsActions.sendText(MOBILE_NUMBER_FIELD, mobileNumber);
            String successMessage = String.format("Successfully entered mobile number: %s", mobileNumber);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to enter mobile number. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp clickOnCreateAccountButton() {
        try {
            ElementsActions.scrollToElement(CREATE_ACCOUNT_BUTTON);
            ElementsActions.clickElementByLocator(CREATE_ACCOUNT_BUTTON);
            String successMessage = "Successfully clicked on 'Create Account' button.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to click 'Create Account' button. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp clickOnContinueButton() {
        try {
            ElementsActions.clickElementByLocator(CONTINUE_BUTTON);
            String successMessage = "Successfully clicked on 'Continue' button.";
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return this;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to click 'Continue' button. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public String getAccountCreationValidationMessage() {
        try {
            String validationMessage = ElementsActions.getText(ACCOUNT_CREATED_MESSAGE);
            String successMessage = String.format("Successfully retrieved account creation message: %s", validationMessage);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return validationMessage;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to retrieve account creation message. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public String validationMessageForExistingEmail() {
        try {
            String validationMessage = ElementsActions.getText(EMAIL_EXIST_VALIDATION_MESSAGE);
            String successMessage = String.format("Successfully retrieved validation message for existing email: %s", validationMessage);
            LOGGER.info(successMessage);
            Allure.step(successMessage);
            return validationMessage;
        } catch (Exception e) {
            String errorMessage = String.format("Failed to retrieve validation message for existing email. Error: %s", e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;
        }
    }

    public P01_SignUp userRegisterationSuccessfully(String email) {
        // Validate email input
        if (email == null || email.trim().isEmpty()) {
            String errorMessage = "Email cannot be null or empty.";
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        try {
            // Log the start of the user sign-up process
            String startMessage = String.format("Starting sign-up process for email: %s", email);
            LOGGER.info(startMessage);
            Allure.step(startMessage);

            // Fill out the sign-up form with valid user data from DataClass
            enterNameField(DataClass.PersonalInformation.userName);
            enterEmailAddress(email);
            clickSignupButton();
            selectTitle();
            enterPassword(DataClass.PersonalInformation.password);
            selectDateOfBirth_Days(DataClass.PersonalInformation.day);
            selectDateOfBirth_Months(DataClass.PersonalInformation.month);
            selectDateOfBirth_Years(DataClass.PersonalInformation.year);
            enterYourFirstName(DataClass.PersonalInformation.firstName);
            enterYourLastName(DataClass.PersonalInformation.lastName);
            enterYourAddress(DataClass.AddressInformation.address);
            selectYourCountry(DataClass.AddressInformation.country);
            enterYourState(DataClass.AddressInformation.state);
            enterYourCity(DataClass.AddressInformation.city);
            enterYourZipcode(DataClass.AddressInformation.zipCode);
            enterYourMobileNumber(DataClass.ContactInformation.mobileNumber);
            clickOnCreateAccountButton();

            // Log and capture success message in Allure
            String successMessage = String.format("User successfully signed up with email: %s", email);
            LOGGER.info(successMessage);
            Allure.step(successMessage);

            return this;  // Return the current SignUp object to allow method chaining

        } catch (Exception e) {
            // Log the error and add an Allure step for failure
            String errorMessage = String.format("Sign-up process failed for email: %s. Error: %s", email, e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;  // Rethrow the exception to fail the test gracefully
        }
    }

    public void userRegisterationWithTheSameEmail() {
        // Validate email input
        String email = DataClass.ContactInformation.emailOne;
        if (email == null || email.trim().isEmpty()) {
            String errorMessage = "Email cannot be null or empty for registration.";
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        try {
            // Log the start of the user registration process
            String startMessage = String.format("Starting user registration with email: %s", email);
            LOGGER.info(startMessage);
            Allure.step(startMessage);

            // Fill out the registration form with user data
            enterNameField(DataClass.PersonalInformation.userName);
            enterEmailAddress(email);
            clickSignupButton();

            // Log and capture success message in Allure
            String successMessage = String.format("User successfully registered with email: %s", email);
            LOGGER.info(successMessage);
            Allure.step(successMessage);

        } catch (Exception e) {
            // Log the error and add an Allure step for failure
            String errorMessage = String.format("Registration failed for email: %s. Error: %s", email, e.getMessage());
            LOGGER.error(errorMessage);
            Allure.step(errorMessage);
            throw e;  // Rethrow the exception to fail the test gracefully
        }
    }

}
