/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dallowayfromadistance;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class FileSearch {
    static Document dallowayText;
    public static void main(String[] args) {
        try {
            dallowayText = Jsoup.connect("https://www.gutenberg.org/cache/epub/71865/pg71865-images.html").get();
        } catch (Exception e) {
            System.out.println("Couldn't fetch the file!");
        }

        // load paragraphs only
        Elements paragraphs = dallowayText.select("p");

        // num of hyphens
        int hyphenCount = 0;

        for (Element p : paragraphs) {
            String paragraph = p.text();
            hyphenCount = 0;

            // iterate through string to find # of hyphens
            for (int i = 0; i < paragraph.length(); i++) {
                if (paragraph.charAt(i) == '-') {
                    hyphenCount++;
                }
            }
            System.out.println(hyphenCount);
        }
    }
}
