package com.github.nautic.utils;

/**
 * Utility class for color formatting.
 * Supports:
 * - Gradient
 * - Solid
 * - Rainbow
 * - Vanilla (&c)
 * - Hex colors
 *
 * @author Senkex
 * @powered Nautic Studios
 */
public class ColorUtil {

    /**
     * Applies color formatting to text.
     *
     * Input examples:
     * g:#ff0000:#00ff00
     * r:255
     * n:&c
     * n:#ff0000
     * s:#ff0000
     *
     * @param text Text to color
     * @param raw Color definition
     * @return Colored text
     */
    public static String apply(String text, String raw) {

        if (!raw.contains(":")) return text;

        String[] split = raw.split(":", 2);
        String type = split[0].toLowerCase();
        String data = split[1];

        switch (type) {
            case "g":
            case "gradient":
                String[] c = data.split(":");
                if (c.length != 2) return text;
                return "<GRADIENT:" + clean(c[0]) + ">" + text + "</GRADIENT:" + clean(c[1]) + ">";

            case "s":
            case "solid":
                return "<SOLID:" + clean(data) + ">" + text;

            case "r":
            case "rainbow":
                return "<RAINBOW:" + data + ">" + text + "</RAINBOW>";

            case "n":
            case "none":
                if (data.startsWith("&")) return data + text;
                if (data.startsWith("#")) return "<SOLID:" + clean(data) + ">" + text;
                return text;

            default:
                return text;
        }
    }

    /**
     * Cleans hex color format.
     */
    private static String clean(String c) {
        return c.replace("#", "");
    }
}