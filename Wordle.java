/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 */

import java.util.Locale;

public class Wordle {
    private String hiddenWord;
    private int row;


    public void run() {
        String currentLetter = "";
        gw = new WordleGWindow();
        //hiddenWord = WordleDictionary.FIVE_LETTER_WORDS[(int) (Math.random() * (WordleDictionary.FIVE_LETTER_WORDS.length))];
        hiddenWord = "plane";
        gw.addEnterListener((s) -> enterAction(s));

    }

/*
 * Called when the user hits the RETURN key or clicks the ENTER button,
 * passing in the string of characters on the current row.
 */

    public void enterAction(String s) {
        String currentLetter = "";

        String word = "";
        int good = 0;

            for (int j = 0; j < WordleDictionary.FIVE_LETTER_WORDS.length; j++) {
                word = WordleDictionary.FIVE_LETTER_WORDS[j];
                if (good == 1) {
                    break;
                }
                else {
                    for (int i = 0; i < WordleGWindow.N_COLS; i++) {
                        currentLetter = s.substring(i, i + 1).toLowerCase(Locale.ROOT);
                        if (i == WordleGWindow.N_COLS - 1) {
                            if (currentLetter.equals(word.substring(i))) {
                                gw.showMessage("The word you have entered is real. Good job!");
                                good++;
                                break;
                            }
                        } else if (currentLetter.equals(word.substring(i, i + 1))) {
                        } else {
                            break;
                        }
                    }
                }
            }
            if (good != 1) {
                gw.showMessage("Not in word list");
                return;
            }
            else {
                for (int k = 0; k < WordleGWindow.N_COLS; k++) {
                    String sCurrent = s.substring(k, k + 1).toLowerCase(Locale.ROOT);
                    gw.setSquareLetter(gw.getCurrentRow(), k, sCurrent.toUpperCase(Locale.ROOT));
                    if (sCurrent.equals(hiddenWord.substring(k, k + 1))) {
                        gw.setSquareColor(gw.getCurrentRow(), k, WordleGWindow.CORRECT_COLOR);
                        gw.setKeyColor(sCurrent.toUpperCase(Locale.ROOT), WordleGWindow.CORRECT_COLOR);
                    }
                    for (int l = 0; l < WordleGWindow.N_COLS; l++) {
                        if (sCurrent.equals(hiddenWord.substring(l, l + 1)) && !(gw.getSquareColor(gw.getCurrentRow(), l).equals(WordleGWindow.CORRECT_COLOR))) {
                            gw.setSquareColor(gw.getCurrentRow(), l, WordleGWindow.PRESENT_COLOR);
                            if (!gw.getKeyColor(sCurrent.toUpperCase(Locale.ROOT)).equals(WordleGWindow.CORRECT_COLOR)) {
                                gw.setKeyColor(sCurrent.toUpperCase(Locale.ROOT), WordleGWindow.PRESENT_COLOR);
                            }
                        } else if (!(gw.getSquareColor(gw.getCurrentRow(), l).equals(WordleGWindow.CORRECT_COLOR)) && (!(gw.getSquareColor(gw.getCurrentRow(), l).equals(WordleGWindow.PRESENT_COLOR)))) {

                            gw.setSquareColor(gw.getCurrentRow(), l, WordleGWindow.MISSING_COLOR);
                            if (!(gw.getKeyColor(sCurrent.toUpperCase(Locale.ROOT)).equals(WordleGWindow.CORRECT_COLOR)) && !((gw.getKeyColor(sCurrent.toUpperCase(Locale.ROOT)).equals(WordleGWindow.PRESENT_COLOR)))) {
                                gw.setKeyColor(sCurrent.toUpperCase(Locale.ROOT), WordleGWindow.MISSING_COLOR);
                            }
                        }
                    }
                }
                if (s.toLowerCase(Locale.ROOT).equals(hiddenWord)) {
                    gw.showMessage("You win!");
                    return;
                }
            }
            row++;
            gw.setCurrentRow(row);
    }

/* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
    }

/* Private instance variables */

    private WordleGWindow gw;

}
