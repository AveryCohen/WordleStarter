/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 */

public class Wordle {

    public void run() {
        String currentLetter = "";
        gw = new WordleGWindow();
        gw.addEnterListener((s) -> enterAction(s));
        String word = WordleDictionary.FIVE_LETTER_WORDS[(int)(Math.random() * (WordleDictionary.FIVE_LETTER_WORDS.length))];
        for (int i = 0; i < WordleGWindow.N_COLS; i++) {
                currentLetter = word.substring(i, i + 1);
            gw.setSquareLetter(0, i, currentLetter);
        }
    }

/*
 * Called when the user hits the RETURN key or clicks the ENTER button,
 * passing in the string of characters on the current row.
 */

    public void enterAction(String s) {
        gw.showMessage("You have to implement this method.");
    }

/* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
    }

/* Private instance variables */

    private WordleGWindow gw;

}
