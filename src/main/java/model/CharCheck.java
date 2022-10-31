package model;

public class CharCheck {
	//replaceEscapeCharクラス
		 //概要：文字列データのエスケープを行う
		public static String replaceEscapeChar(String val) {
			if (val == null) return "";
		       val = val.replaceAll("&", "& amp;");
		       val = val.replaceAll("<", "& lt;");
		       val = val.replaceAll(">", "& gt;");
		       val = val.replaceAll("\"", "&quot;");
		       val = val.replaceAll("'", "&apos;");
		       return val;
		     }
}
