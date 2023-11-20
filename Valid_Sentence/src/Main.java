import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValidSentence("The quick brown fox said “hello Mr lazy dog”."));
        System.out.println(isValidSentence("The quick brown fox said hello Mr lazy dog."));
        System.out.println(isValidSentence("The quick brown fox said hello Mr lazy dog."));
        System.out.println(isValidSentence("The quick brown fox said hello Mr lazy dog."));
        System.out.println(isValidSentence("How many \"lazy dogs\" are there?"));

        System.out.println(isValidSentence("The quick brown fox said \"hello Mr. lazy dog\"."));
        System.out.println(isValidSentence("the quick brown fox said “hello Mr lazy dog\"."));
        System.out.println(isValidSentence("\"The quick brown fox said “hello Mr lazy dog.\""));
        System.out.println(isValidSentence("One lazy dog is too few, 12 is too many."));
        System.out.println(isValidSentence("Are there 11, 12, or 13 lazy dogs?"));
        System.out.println(isValidSentence("There is no punctuation in this sentence"));
    }

    public static boolean isValidSentence(String sentence) {
        // Check if the sentence starts with a capital letter
        if (!Character.isUpperCase(sentence.charAt(0))) {
            return false;
        }

        // Check if the sentence has an even number of quotation marks
        long quoteCount = sentence.chars().filter(ch -> ch == '\"').count();
        if (quoteCount % 2 != 0) {
            return false;
        }

        // Check if the sentence ends with a sentence termination character
        if (!Pattern.matches(".*[.?!]$", sentence)) {
            return false;
        }

        // Check if the sentence has no period characters other than the last character
        if (sentence.substring(0, sentence.length() - 1).contains(".")) {
            return false;
        }

        // Check if numbers below 13 are spelled out
        String[] words = sentence.split("\\W+");
        for (String word : words) {
            try {
                int number = Integer.parseInt(word);
                if (number < 13) {
                    return false;
                }
            } catch (NumberFormatException e) {

            }
        }

        return true;
    }
}
