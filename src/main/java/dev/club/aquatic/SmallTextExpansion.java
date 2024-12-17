package dev.club.aquatic;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

/**
 * @author Vasty
 * @date 17/12/2024 @ 16:30
 * @url https://github.com/vastydev
 */

public class SmallTextExpansion extends PlaceholderExpansion {

    private static final String[] UPPERCASE_SMALL = {
            "ᴀ", "ʙ", "ᴄ", "ᴅ", "ᴇ", "ꜰ", "ɢ", "ʜ", "ɪ", "ᴊ", "ᴋ", "ʟ", "ᴍ", "ɴ", "ᴏ", "ᴘ", "ǫ", "ʀ", "ѕ", "ᴛ", "ᴜ", "ᴠ", "ᴡ", "x", "ʏ", "ᴢ"
    };
    private static final String[] LOWERCASE_SMALL = UPPERCASE_SMALL;

    @Override
    public String getIdentifier() {
        return "smalltext";
    }

    @Override
    public String getAuthor() {
        return "Vasty";
    }

    @Override
    public String getVersion() {
        return "0.1";
    }

    /**
     * Processes the text when the expansion is called
     *
     * @param player Player (can be null)
     * @param identifier The text given between %smalltext_<text>%
     * @return Text converted to "small caps"
     */
    @Override
    public String onRequest(OfflinePlayer player, String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            return null;
        }

        String input = identifier.replace("_", " ");
        return convertToSmallCaps(input);
    }

    /**
     * Method to convert text to "small caps"
     *
     * @param input Original text
     * @return Text converted to small caps
     */
    private String convertToSmallCaps(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append(UPPERCASE_SMALL[c - 'A']);
            } else if (c >= 'a' && c <= 'z') {
                result.append(LOWERCASE_SMALL[c - 'a']);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
