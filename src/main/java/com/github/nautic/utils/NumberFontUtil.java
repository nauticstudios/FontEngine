package com.github.nautic.utils;

/**
 * Utility class for applying number fonts.
 * Converts digits into styled Unicode digits.
 *
 * @author Senkex
 * @powered Nautic Studios
 */
public class NumberFontUtil {

    /**
     * Available numeric fonts.
     */
    private static final String[][] FONTS = {
            {"0","1","2","3","4","5","6","7","8","9"},
            {"𝟶","𝟷","𝟸","𝟹","𝟺","𝟻","𝟼","𝟽","𝟾","𝟿"},
            {"➊","➋","➌","➍","➎","➏","➐","➑","➒","⓿"},
            {"𝟭","𝟮","𝟯","𝟰","𝟱","𝟲","𝟳","𝟴","𝟵","𝟬"},
            {"𝟏","𝟐","𝟑","𝟒","𝟓","𝟔","𝟕","𝟖","𝟗","𝟎"},
            {"¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹","⁰"},
            {"₁","₂","₃","₄","₅","₆","₇","₈","₉","₀"}
    };

    /**
     * Applies a number font to a string.
     *
     * @param input Original text
     * @param font Font index
     * @return Styled numeric string
     */
    public static String apply(String input, String font) {
        int idx = parse(font);
        if (idx <= 0 || idx >= FONTS.length) return input;

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(Character.isDigit(c) ? FONTS[idx][c - '0'] : c);
        }
        return sb.toString();
    }

    /**
     * Applies a font to a single digit.
     */
    public static char applyChar(char c, String font) {
        if (!Character.isDigit(c)) return c;
        int idx = parse(font);
        return idx <= 0 || idx >= FONTS.length ? c : FONTS[idx][c - '0'].charAt(0);
    }

    /**
     * Parses font index safely.
     */
    private static int parse(String f) {
        try { return Integer.parseInt(f); } catch (Exception e) { return 0; }
    }
}