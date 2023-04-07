package Stream_API_Vebinar_Po_Java.textFormatter;

import Stream_API_Vebinar_Po_Java.textFormatter.TextFormatAfter;
import Stream_API_Vebinar_Po_Java.textFormatter.TextFormatBefore;

public class Main {
    public static void main(String[] args) {
        String text = "Java is awesome!";

        System.out.println("\nTextFormatBefore():\n");
        System.out.println(new TextFormatBefore().bold(text, TextFormatBefore.SyntaxFormat.MD));
        System.out.println(new TextFormatBefore().bold(text, TextFormatBefore.SyntaxFormat.HTML));
        System.out.println(new TextFormatBefore().bold(text, TextFormatBefore.SyntaxFormat.BB));

        System.out.println("\nTextFormatAfter():\n");
        System.out.println(new TextFormatAfter().bold(text,TextFormatAfter.SyntaxFormatA.MD));
        System.out.println(new TextFormatAfter().bold(text,TextFormatAfter.SyntaxFormatA.HTML));
        System.out.println(new TextFormatAfter().bold(text, TextFormatAfter.SyntaxFormatA.BB));
        System.out.println(new TextFormatAfter().bold(text,TextFormatAfter.SyntaxFormatA.HTMLp));
        System.out.println(new TextFormatAfter().bold(text,TextFormatAfter.SyntaxFormatA.HTMLmD));
    }
}
