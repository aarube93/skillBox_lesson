package Stream_API_Vebinar_Po_Java.textFormatter;

import java.util.Map;
import java.util.function.Function;

public class TextFormatAfter {
    Map<SyntaxFormatA, Function<String, String>> syntaxMapping =
            Map.of(
                    SyntaxFormatA.MD, this::boldMDa,
                    SyntaxFormatA.HTML, (s) -> boldHTMLa(s),
                    SyntaxFormatA.BB, (s) -> "[b]" + s + "[/b]",
                    SyntaxFormatA.HTMLp, (str) -> boldHTMLPref(str, "h "),
                    SyntaxFormatA.HTMLmD, (s) -> {
                        String bolded = boldHTMLa(s);
                        return boldMDa(bolded);
                    }
            );

    public String bold(String text, SyntaxFormatA syntaxFormat) {
        return syntaxMapping.get(syntaxFormat).apply(text);
    }

    public String boldMDa(String text) {
        return "<**>" + text + "<**>";
    }

    public String boldHTMLa(String text) {
        return "<strong>" + text + "</strong>";
    }

    public String boldHTMLPref(String text, String prefix) {
        return "<strong>" + prefix + text + "</strong>";
    }

    public enum SyntaxFormatA {
        MD, HTML, BB, HTMLp, HTMLmD
    }
}