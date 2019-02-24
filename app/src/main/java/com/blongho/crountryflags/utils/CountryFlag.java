package com.blongho.crountryflags.utils;
/**
 * @file CountryFlag.java
 * @author 	Bernard Che Longho
 * @brief	A class to load all the flags and countries in a map
 * This eases the access of flag when the country alpha2 or alpha3 codes are known
 */

import android.os.Build;

import com.blongho.crountryflags.R;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class CountryFlag {
	/**
	 * A concurrent has
	 */
	private Map<String, Integer> flagMap = null;

	public Map<String, Integer> getCountryFlagMap() {
		loadCountryFlagMap();
		return flagMap;
	}

	/**
	 * Load the countries and their flags in a Map container
	 * <br>
	 *     Each country is flag is mapped with the country alpha2 and alpha3 codes
	 */
	private void loadCountryFlagMap() {
		flagMap = new ConcurrentHashMap<>();
		flagMap.put("af", R.drawable.af);
		flagMap.put("al", R.drawable.al);
		flagMap.put("ax", R.drawable.ax);
		flagMap.put("dz", R.drawable.dz);
		flagMap.put("ad", R.drawable.ad);
		flagMap.put("ao", R.drawable.ao);
		flagMap.put("ag", R.drawable.ag);
		flagMap.put("ar", R.drawable.ar);
		flagMap.put("am", R.drawable.am);
		flagMap.put("au", R.drawable.au);
		flagMap.put("at", R.drawable.at);
		flagMap.put("az", R.drawable.az);
		flagMap.put("bs", R.drawable.bs);
		flagMap.put("bh", R.drawable.bh);
		flagMap.put("bd", R.drawable.bd);
		flagMap.put("bb", R.drawable.bb);
		flagMap.put("by", R.drawable.by);
		flagMap.put("be", R.drawable.be);
		flagMap.put("bz", R.drawable.bz);
		flagMap.put("bj", R.drawable.bj);
		flagMap.put("bt", R.drawable.bt);
		flagMap.put("bo", R.drawable.bo);
		flagMap.put("ba", R.drawable.ba);
		flagMap.put("bw", R.drawable.bw);
		flagMap.put("br", R.drawable.br);
		flagMap.put("bn", R.drawable.bn);
		flagMap.put("bg", R.drawable.bg);
		flagMap.put("bf", R.drawable.bf);
		flagMap.put("bi", R.drawable.bi);
		flagMap.put("kh", R.drawable.kh);
		flagMap.put("cm", R.drawable.cm);
		flagMap.put("ca", R.drawable.ca);
		flagMap.put("cv", R.drawable.cv);
		flagMap.put("cf", R.drawable.cf);
		flagMap.put("td", R.drawable.td);
		flagMap.put("cl", R.drawable.cl);
		flagMap.put("co", R.drawable.co);
		flagMap.put("km", R.drawable.km);
		flagMap.put("ck", R.drawable.ck);
		flagMap.put("cr", R.drawable.cr);
		flagMap.put("ci", R.drawable.ci);
		flagMap.put("hr", R.drawable.hr);
		flagMap.put("cu", R.drawable.cu);
		flagMap.put("cy", R.drawable.cy);
		flagMap.put("cz", R.drawable.cz);
		flagMap.put("cd", R.drawable.cd);
		flagMap.put("dk", R.drawable.dk);
		flagMap.put("dj", R.drawable.dj);
		flagMap.put("dm", R.drawable.dm);
		flagMap.put("do", R.drawable.doRenamed);
		flagMap.put("tl", R.drawable.tl);
		flagMap.put("ec", R.drawable.ec);
		flagMap.put("eg", R.drawable.eg);
		flagMap.put("sv", R.drawable.sv);
		flagMap.put("gq", R.drawable.gq);
		flagMap.put("er", R.drawable.er);
		flagMap.put("ee", R.drawable.ee);
		flagMap.put("et", R.drawable.et);
		flagMap.put("fj", R.drawable.fj);
		flagMap.put("fi", R.drawable.fj);
		flagMap.put("fr", R.drawable.fr);
		flagMap.put("ga", R.drawable.ga);
		flagMap.put("gm", R.drawable.gm);
		flagMap.put("ge", R.drawable.ge);
		flagMap.put("de", R.drawable.de);
		flagMap.put("gh", R.drawable.gh);
		flagMap.put("gr", R.drawable.gr);
		flagMap.put("gd", R.drawable.gd);
		flagMap.put("gt", R.drawable.gt);
		flagMap.put("gn", R.drawable.gn);
		flagMap.put("gw", R.drawable.gw);
		flagMap.put("gy", R.drawable.gy);
		flagMap.put("ht", R.drawable.ht);
		flagMap.put("hn", R.drawable.hn);
		flagMap.put("hu", R.drawable.hu);
		flagMap.put("is", R.drawable.is);
		flagMap.put("in", R.drawable.in);
		flagMap.put("id", R.drawable.id);
		flagMap.put("ir", R.drawable.ir);
		flagMap.put("iq", R.drawable.iq);
		flagMap.put("ie", R.drawable.ie);
		flagMap.put("il", R.drawable.il);
		flagMap.put("it", R.drawable.it);
		flagMap.put("jm", R.drawable.jm);
		flagMap.put("jp", R.drawable.jp);
		flagMap.put("jo", R.drawable.jo);
		flagMap.put("kz", R.drawable.kz);
		flagMap.put("ke", R.drawable.ke);
		flagMap.put("ki", R.drawable.ki);
		flagMap.put("ks", R.drawable.ks);
		flagMap.put("kw", R.drawable.kw);
		flagMap.put("kg", R.drawable.kg);
		flagMap.put("la", R.drawable.la);
		flagMap.put("lv", R.drawable.lv);
		flagMap.put("lb", R.drawable.lb);
		flagMap.put("ls", R.drawable.ls);
		flagMap.put("lr", R.drawable.lr);
		flagMap.put("ly", R.drawable.ly);
		flagMap.put("li", R.drawable.li);
		flagMap.put("lt", R.drawable.lt);
		flagMap.put("lu", R.drawable.lu);
		flagMap.put("mk", R.drawable.mk);
		flagMap.put("mg", R.drawable.mg);
		flagMap.put("mw", R.drawable.mw);
		flagMap.put("my", R.drawable.my);
		flagMap.put("mv", R.drawable.mv);
		flagMap.put("ml", R.drawable.ml);
		flagMap.put("mt", R.drawable.mt);
		flagMap.put("mh", R.drawable.mh);
		flagMap.put("mr", R.drawable.mr);
		flagMap.put("mu", R.drawable.mu);
		flagMap.put("mx", R.drawable.mx);
		flagMap.put("fm", R.drawable.fm);
		flagMap.put("md", R.drawable.md);
		flagMap.put("mc", R.drawable.mc);
		flagMap.put("mn", R.drawable.mn);
		flagMap.put("me", R.drawable.me);
		flagMap.put("ma", R.drawable.ma);
		flagMap.put("mz", R.drawable.mz);
		flagMap.put("mm", R.drawable.mm);
		flagMap.put("na", R.drawable.na);
		flagMap.put("nr", R.drawable.nr);
		flagMap.put("np", R.drawable.np);
		flagMap.put("nl", R.drawable.nl);
		flagMap.put("nz", R.drawable.nz);
		flagMap.put("ni", R.drawable.ni);
		flagMap.put("ne", R.drawable.ne);
		flagMap.put("ng", R.drawable.ng);
		flagMap.put("nu", R.drawable.nu);
		flagMap.put("kp", R.drawable.kp);
		flagMap.put("no", R.drawable.no);
		flagMap.put("om", R.drawable.om);
		flagMap.put("pk", R.drawable.pk);
		flagMap.put("pw", R.drawable.pw);
		flagMap.put("pa", R.drawable.pa);
		flagMap.put("pg", R.drawable.pg);
		flagMap.put("py", R.drawable.py);
		flagMap.put("cn", R.drawable.cn);
		flagMap.put("pe", R.drawable.pe);
		flagMap.put("ph", R.drawable.ph);
		flagMap.put("pl", R.drawable.pl);
		flagMap.put("pt", R.drawable.pt);
		flagMap.put("qa", R.drawable.qa);
		flagMap.put("tw", R.drawable.tw);
		flagMap.put("cg", R.drawable.cg);
		flagMap.put("ro", R.drawable.ro);
		flagMap.put("ru", R.drawable.ru);
		flagMap.put("rw", R.drawable.rw);
		flagMap.put("kn", R.drawable.kn);
		flagMap.put("lc", R.drawable.lc);
		flagMap.put("vc", R.drawable.vc);
		flagMap.put("ws", R.drawable.ws);
		flagMap.put("sm", R.drawable.sm);
		flagMap.put("st", R.drawable.st);
		flagMap.put("sa", R.drawable.sa);
		flagMap.put("sn", R.drawable.sn);
		flagMap.put("rs", R.drawable.rs);
		flagMap.put("sc", R.drawable.sc);
		flagMap.put("sl", R.drawable.sl);
		flagMap.put("sg", R.drawable.sg);
		flagMap.put("sk", R.drawable.sk);
		flagMap.put("si", R.drawable.si);
		flagMap.put("sb", R.drawable.sb);
		flagMap.put("so", R.drawable.so);
		flagMap.put("za", R.drawable.za);
		flagMap.put("kr", R.drawable.kr);
		flagMap.put("ss", R.drawable.ss);
		flagMap.put("es", R.drawable.es);
		flagMap.put("lk", R.drawable.lk);
		flagMap.put("sd", R.drawable.sd);
		flagMap.put("sr", R.drawable.sr);
		flagMap.put("sz", R.drawable.sz);
		flagMap.put("se", R.drawable.se);
		flagMap.put("ch", R.drawable.ch);
		flagMap.put("sy", R.drawable.sy);
		flagMap.put("tj", R.drawable.tj);
		flagMap.put("tz", R.drawable.tz);
		flagMap.put("th", R.drawable.th);
		flagMap.put("tg", R.drawable.tg);
		flagMap.put("to", R.drawable.to);
		flagMap.put("tt", R.drawable.tt);
		flagMap.put("tn", R.drawable.tn);
		flagMap.put("tr", R.drawable.tr);
		flagMap.put("tm", R.drawable.tm);
		flagMap.put("tv", R.drawable.tv);
		flagMap.put("ug", R.drawable.ug);
		flagMap.put("ua", R.drawable.ua);
		flagMap.put("ae", R.drawable.ae);
		flagMap.put("gb", R.drawable.gb);
		flagMap.put("us", R.drawable.us);
		flagMap.put("uy", R.drawable.uy);
		flagMap.put("uz", R.drawable.uz);
		flagMap.put("vu", R.drawable.vu);
		flagMap.put("va", R.drawable.va);
		flagMap.put("ve", R.drawable.ve);
		flagMap.put("vn", R.drawable.vn);
		flagMap.put("eh", R.drawable.eh);
		flagMap.put("ye", R.drawable.ye);
		flagMap.put("zm", R.drawable.zm);
		flagMap.put("zw", R.drawable.zw);
	}

	/**
	 * Add another country flag to the list of flags
	 * @param alpha the alpha2 or alpha3 of the country
	 * @param imageResource the image resource
	 *                      This should be a drawable resource
	 * @return if the map is successfully added, this returns true otherwise false
	 */
	public boolean addFlag(@NonNull final String alpha, @DrawableRes @NonNull final Integer imageResource){
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			flagMap.putIfAbsent(alpha, imageResource);
		}else{
			flagMap.put(alpha, imageResource);
		}
		return flagMap.get(alpha) != null;
	}
}
