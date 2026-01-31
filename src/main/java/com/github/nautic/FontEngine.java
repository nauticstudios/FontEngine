package com.github.nautic;

import com.github.nautic.utils.ColorUtil;
import com.github.nautic.utils.NumberFontUtil;
import com.github.nautic.utils.TextFontUtil;
import com.iridium.iridiumcolorapi.IridiumColorAPI;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

import javax.annotation.Nonnull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main PlaceholderAPI expansion for FontEngine.
 *
 * This class handles:
 * - Text formatting (letters)
 * - Number formatting (digits)
 * - Combined formatting (letters + numbers)
 * - Color systems (solid, gradient, rainbow, vanilla)
 *
 * Supported formats:
 * text / number / combined
 *
 * @author Senkex
 * @powered Nautic Studios
 */
public final class FontEngine extends PlaceholderExpansion {

    /**
     * Pattern for basic text or number formatting.
     * Example: text/1/g[#ff0000:#00ff00]
     */
    private static final Pattern BASIC =
            Pattern.compile("(text|t|number|n)/([^/]+)/([^\\[]+)\\[(.+?)]");

    /**
     * Pattern for combined formatting (letters + numbers).
     * Example: combined<t:1/n:2/g[#ff0000:#00ff00]>
     */
    private static final Pattern COMBINED =
            Pattern.compile("(combined|cd)<t:([^/]+)/n:([^/]+)/([^>]+)>");

    @Override
    public @Nonnull String getIdentifier() {
        return "fontengine";
    }

    @Override
    public @Nonnull String getAuthor() {
        return "Senkex";
    }

    @Override
    public @Nonnull String getVersion() {
        return "0.1.1";
    }

    /**
     * Handles placeholder requests and processes formatting.
     *
     * @param player The player requesting the placeholder
     * @param identifier The raw placeholder identifier
     * @return Formatted string result
     */
    @Override
    public String onRequest(OfflinePlayer player, @Nonnull String identifier) {

        if (!identifier.contains("=(") || !identifier.endsWith(")")) return null;

        String[] split = identifier.split("=", 2);
        String format = split[0];
        String text = split[1].substring(1, split[1].length() - 1);

        // Apply PlaceholderAPI placeholders inside the content
        text = PlaceholderAPI.setBracketPlaceholders(player, text);

        // Combined mode (letters + numbers)
        Matcher cmb = COMBINED.matcher(format);
        if (cmb.matches()) {
            String tFont = cmb.group(2);
            String nFont = cmb.group(3);
            String colorRaw = cmb.group(4);

            StringBuilder sb = new StringBuilder();
            for (char c : text.toCharArray()) {
                if (Character.isDigit(c)) {
                    sb.append(NumberFontUtil.applyChar(c, nFont));
                } else {
                    sb.append(TextFontUtil.applyChar(c, tFont));
                }
            }

            return IridiumColorAPI.process(ColorUtil.apply(sb.toString(), colorRaw));
        }

        // Basic mode (text or number)
        Matcher m = BASIC.matcher(format);
        if (!m.matches()) return null;

        String mode = m.group(1);
        String font = m.group(2);
        String colorType = m.group(3);
        String colorData = m.group(4);

        if (mode.equalsIgnoreCase("text") || mode.equalsIgnoreCase("t")) {
            text = TextFontUtil.apply(text, font);
        } else {
            text = NumberFontUtil.apply(text, font);
        }

        return IridiumColorAPI.process(ColorUtil.apply(text, colorType + ":" + colorData));
    }
}
