/**
 * 
 */
package com.xpower.learning.jdk.io;

import java.io.File;

/**
 * @author Stronger
 *
 */
public class FileX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file  = new File("test.txt");
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(String.format("File exist? %b.", file.exists()));
		System.out.println(String.format("File is a directory? %b.", file.isDirectory()));
		System.out.println(file.canExecute());
	}

}
