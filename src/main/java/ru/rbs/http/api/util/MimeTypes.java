package ru.rbs.http.api.util;

public final class MimeTypes {
    private MimeTypes() {
    }

    public static final class Text {
        public static final String XML = "text/xml";
        public static final String JSON = "text/json";

        private Text() {
        }
    }

    public static final class Application {
        public static final String JSON = "application/json";
        public static final String X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
        public static final String XML = "application/xml";

        private Application() {
        }
    }
}
