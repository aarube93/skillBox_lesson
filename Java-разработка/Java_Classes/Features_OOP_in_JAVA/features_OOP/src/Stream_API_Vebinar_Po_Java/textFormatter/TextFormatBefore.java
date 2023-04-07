package Stream_API_Vebinar_Po_Java.textFormatter;

public class TextFormatBefore {

    public String bold(String text, SyntaxFormat syntaxFormat) {

        if (syntaxFormat == SyntaxFormat.HTML) {
            return boldHTMLb(text);
        } else if (syntaxFormat == SyntaxFormat.MD) {
            return boldMDb(text);
        } else if (syntaxFormat == syntaxFormat.BB) {
            return "[b]" + text + "[/b]";
        }
        throw new IllegalArgumentException("There is no syntaxType={" + syntaxFormat + "}");
    }

    public String boldHTMLb(String text) {
        return "<strong>" + text + "</strong>";
    }

    public String boldMDb(String text) {
        return "**" + text + "**";
    }

    public enum SyntaxFormat {
        MD, HTML, BB
    }
}
