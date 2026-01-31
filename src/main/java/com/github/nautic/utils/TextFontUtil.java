package com.github.nautic.utils;

/**
 * Utility class for applying letter fonts.
 * Converts standard Latin characters into styled Unicode fonts.
 *
 * @author Senkex
 * @powered Nautic Studios
 */
public class TextFontUtil {

    /**
     * Base alphabet used for indexing font replacements.
     */
    private static final String BASE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Available text fonts.
     * Each index represents a different font style.
     */
    private static final String[][] FONTS = {
            BASE.split(""),
            "ᴀʙᴄᴅᴇғɢʜɪᴊᴋʟᴍɴᴏᴘǫʀsᴛᴜᴠᴡxʏᴢᴀʙᴄᴅᴇғɢʜɪᴊᴋʟᴍɴᴏᴘǫʀsᴛᴜᴠᴡxʏᴢ".split(""),
            "ⒶⒷⒸⒹⒺⒻⒼⒽⒾⒿⓀⓁⓂⓃⓄⓅⓆⓇⓈⓉⓊⓋⓌⓍⓎⓏⒶⒷⒸⒹⒺⒻⒼⒽⒾⒿⓀⓁⓂⓃⓄⓅⓆⓇⓈⓉⓊⓋⓌⓍⓎⓏ".split(""),
            "ᵃᵇᶜᵈᵉᶠᵍʰᶦʲᵏˡᵐⁿᵒᵖᵠʳˢᵗᵘᵛʷˣʸᶻᴬᴮᶜᴰᴱᶠᴳᴴᴵᴶᴷᴸᴹᴺᴼᴾᵠᴿˢᵀᵁⱽᵂˣʸᶻ".split("")
    };

    /**
     * Applies a font to the given input string.
     *
     * @param input Original text
     * @param font Font index
     * @return Formatted text
     */
    public static String apply(String input, String font) {
        int idx = parse(font);
        if (idx <= 0 || idx >= FONTS.length) return input;

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            int i = BASE.indexOf(c);
            sb.append(i >= 0 ? FONTS[idx][i] : c);
        }
        return sb.toString();
    }

    /**
     * Applies a font to a single character.
     *
     * @param c Character to format
     * @param font Font index
     * @return Styled character
     */
    public static char applyChar(char c, String font) {
        return apply(String.valueOf(c), font).charAt(0);
    }

    /**
     * Parses font index safely.
     */
    private static int parse(String f) {
        try { return Integer.parseInt(f); } catch (Exception e) { return 0; }
    }
}