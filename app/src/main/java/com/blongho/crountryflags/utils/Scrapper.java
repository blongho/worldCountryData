package com.blongho.crountryflags.utils;

import android.util.Log;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class Scrapper {

	public static void scrappedContent(){

		final String url = "https://news.ycombinator.com/";
			try {
			Document doc     = Jsoup.connect(url).get();
			Elements links   = doc.select("a[href]");
			Elements media   = doc.select("[src]");
			Elements imports = doc.select("link[href]");

			print("\nMedia: (%d)", media.size());
			for (Element src : media) {
				if (src.tagName().equals("img"))
					print(" * %s: <%s> %sx%s (%s)",
						  src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
						  trim(src.attr("alt"), 20));
				else
					print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
			}

			print("\nImports: (%d)", imports.size());
			for (Element link : imports) {
				print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
			}

			print("\nLinks: (%d)", links.size());
			for (Element link : links) {
				print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void print(String msg, Object... args) {
		Log.i("Scrapper", String.format(msg, args));
		//System.out.println(String.format(msg, args));
	}

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width-1) + ".";
		else
			return s;
	}
}
