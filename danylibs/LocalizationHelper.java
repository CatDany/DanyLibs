package danylibs;

import net.minecraft.util.StatCollector;

public class LocalizationHelper
{
	public static String get(String string)
	{
		return StatCollector.translateToLocal(string).replace("++", Paragraph.sign);
	}
	
	public static String get(String string, Object... format)
	{
		return StatCollector.translateToLocalFormatted(string, format).replace("++", Paragraph.sign);
	}
}