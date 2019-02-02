/**
 * 
 */
package com.xpower.learning.jdk.io;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * 
 * FileInputStream obtains input bytes from a file in a file system. What files
 * are available depends on the host environment. FileInputStream is meant for
 * reading streams of raw bytes such as image data. For reading streams of
 * characters, consider using FileReader.
 * 
 * @author Stronger
 * 
 */
public class FileInputStreamX {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		System.out.println("Read file demo.");

		// "./src/resources/docs/FileInputStream.html"
		final String filePath = "./src/resources/docs/FileInputStream (Java Platform SE 8 ).png";
		final File file = new File(filePath);

		if (file.exists()) {
			// OutputStream os = System.out;
			File copy = File.createTempFile("test", ".png");
			OutputStream os = new FileOutputStream(copy);

			FileInputStream fis = null;

			try {
				fis = new FileInputStream(file);
				System.out.println(file.length() == fis.available());
				byte[] buffer = new byte[1024]; //
				int len;

				while ((len = fis.read(buffer)) > 0) {
					os.write(buffer, 0, len);
					os.flush();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					fis.close();
				}

				os.close();
			}

			// Open the file copy by the associated file program.
			if (Desktop.isDesktopSupported()) {
				Desktop dt = Desktop.getDesktop();
				System.out.println(copy.getAbsolutePath());
				dt.open(copy.getParentFile());
				dt.open(copy);
			}
		}
	}
}