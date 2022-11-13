public class tutoring {
    public String main(String paragraph, String find, String replace) {

        String returnString = new String();
        int wordLength = find.length();
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.substring(i, i + wordLength).compareTo(find) == 0) {
                returnString += replace;
                i += wordLength;
            }
            else {
                returnString += paragraph.charAt(i);
            }
        }

        return returnString;

    }


}




/**/