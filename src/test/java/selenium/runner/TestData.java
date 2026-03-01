package selenium.runner;

public class TestData {

    public static final String UI_TESTING_BASE_URL = "http://uitestingplayground.com/";
    public static final String AUTOMATION_EXERCISES_BASE_URL = "https://automationexercise.com/";

    public enum MenuOption {
        HOME("Home"),
        PRODUCTS("Products"),
        CART("Cart"),
        SIGNUP_LOGIN(" Signup / Login"),
        TEST_CASES("Test Cases"),
        API_TESTING("API Testing"),
        VIDEO_TUTORIALS("Video Tutorials"),
        CONTACT_US("Contact us");

        private final String displayName;

        MenuOption(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum TestScenario {
        DYNAMIC_ID("Dynamic ID"),
        CLASS_ATTRIBUTE("Class Attribute"),
        HIDDEN_LAYERS("Hidden Layers"),
        LOAD_DELAY("Load Delay"),
        AJAX_DATA("AJAX Data"),
        CLIENT_SIDE_DELAY("Client Side Delay"),
        CLICK("Click"),
        TEXT_INPUT("Text Input"),
        SCROLLBARS("Scrollbars"),
        DYNAMIC_TABLE("Dynamic Table"),
        VERIFY_TEXT("Verify Text"),
        PROGRESS_BAR("Progress Bar"),
        OVERLAPPING_ELEMENTS("Overlapping Elements"),
        SHADOW_DOM("Shadow DOM");

        private final String displayName;

        TestScenario(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}
