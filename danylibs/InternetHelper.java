package danylibs;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import cpw.mods.fml.common.FMLLog;

public class InternetHelper
{
	public static String readRemoteFile(String url, Object... format)
	{
		String result = null;
		String tmpFileName = "%TMP%\\" + new Random().nextInt();
		deleteIfExists(tmpFileName);
		try
		{
			downloadRemoteFile(tmpFileName, url, format);
			result = new String(Files.readAllBytes(Paths.get(new File(tmpFileName).toURI())));
		}
		catch (Throwable t)
		{
			FMLLog.warning("Unable to read remotely downloaded file!");
			t.printStackTrace();
		}
		finally
		{
			deleteIfExists(tmpFileName);
		}
		return result;
	}
	
	public static void downloadRemoteFile(String saveTo, String url, Object... format)
	{
		deleteIfExists(saveTo);
		try
		{
			URL website = new URL(String.format(url, format));
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(saveTo);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
		}
		catch (Throwable t)
		{
			FMLLog.warning("Unable to download remote file!");
			t.printStackTrace();
		}
	}
	
	private static void deleteIfExists(String filename)
	{
		File temporary = new File(filename);
		if (temporary.exists())
		{
			temporary.delete();
		}
	}
}