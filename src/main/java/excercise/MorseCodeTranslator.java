package excercise;

public class MorseCodeTranslator {

    public static final String[] MORSE_CODE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",".-.-.-"};
    public static final char[] ENGLISH_ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','.','0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static String translate(String text, boolean morseToEnglish) {
        if (morseToEnglish) {
            return decodeMorseCode(text);
        } else {
            return encodeMorseCode(text.toUpperCase());
        }
    }

    private static String encodeMorseCode(String text) {
        StringBuilder morseCodeBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                morseCodeBuilder.append(" ");
            } else if (Character.isLetterOrDigit(c)) {
                int index = getIndexForCharacter(c);
                morseCodeBuilder.append(MORSE_CODE[index]).append(" ");
            } else if(c == '.'){
                morseCodeBuilder.append(".-.-.-");
            }else {
                return "Invalid Morse Code Or Spacing";
            }
        }
        return morseCodeBuilder.toString();
    }

    private static String decodeMorseCode(String text) {
        StringBuilder englishBuilder = new StringBuilder();
        String[] words = text.trim().split(" {3}");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                int index = getIndexForMorseCode(letter);
                if (index != -1) {
                    englishBuilder.append(ENGLISH_ALPHABET[index]);
                }else {
                    return "Invalid Morse Code Or Spacing";
                }
            }
            englishBuilder.append(" ");
        }
        return englishBuilder.toString().toLowerCase();
    }

    private static int getIndexForCharacter(char c) {
        for (int i = 0; i < ENGLISH_ALPHABET.length; i++) {
            if (ENGLISH_ALPHABET[i] == c) {
                return i;
            }
        }
        return -1;
    }

    private static int getIndexForMorseCode(String code) {
        for (int i = 0; i < MORSE_CODE.length; i++) {
            if (MORSE_CODE[i].equals(code)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String input = "The wizard quickly jinxed the gnomes before they vaporized.";
        boolean morseToEnglish = false;
        String output = MorseCodeTranslator.translate(input, morseToEnglish);
        System.out.println(output);
    }
}
