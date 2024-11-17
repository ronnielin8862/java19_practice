package org.example.freePractice.newVersion;

public class SwitchForJdk14 {
    public enum JAVA_VERSION {
        JavaSE6,JavaSE7,JavaSE8,JavaSE9,JavaSE10,JavaSE11,JavaSE12,JavaSE13
    }

    JAVA_VERSION version = JAVA_VERSION.JavaSE7;

    public void trySwitch() {
        switch (version) {
            case JavaSE6:
                System.out.println("Does not apply");

            case JavaSE7:
                System.out.println("Does not apply");

            case JavaSE8:
                System.out.println("Does not apply");

            case JavaSE9:
                System.out.println("Non-LTS");
                break;
            case JavaSE10:
                System.out.println("Non-LTS");

            case JavaSE11:
                String version = "JAVASE11";
                System.out.println(version + " is LTS");

            case JavaSE12:
                String version2 = "JAVASE12";
                System.out.println(version2 + " is Non-LTS");
            case JavaSE13:
                String version3 = "JAVASE13";
                System.out.println(version3 + " is Non-LTS");
            default:
                System.out.println("Does not apply or Java version is not defined.");

        }
    }

    public void newSwitchAndTextBlock(int version) {

        String textBlock = """
                
                JDK11
                
                """;
        switch (version) {
            case 9 -> System.out.println("JDK9\n");
            case 10 -> System.out.println("JDK10\n");
            case 11 -> System.out.println(textBlock);
            case 12 -> System.out.println("JDK12\n");
            case 13 -> System.out.println("JDK13\n");
            default -> System.out.println("Does not apply or Java version is not defined.");
        }
    }

    public void newSwitchAndYield(int version) {
        String message = switch (version){
            case 9,14,15 -> "JDK9";
            case 10 -> {yield "JDK10"; }
            case 11 -> "JDK11";
            case 12 -> "JDK12";
            case 13 -> {
                System.out.println("JDK13");
                yield "JDK13";
            }
            default -> "Does not apply or Java version is not defined.";
        };

        System.out.println(message);
    }


}
