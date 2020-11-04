package caa.register.checkin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {


	private static String txtPath = "check-list.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(txtPath);
		if(file.exists()){
			file.createNewFile();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file,true);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Start record at "+ df.format(new Date()));
		System.out.println("Please Check in:");
		while (true){
			String line = scanner.nextLine();
			if ("exit".equals(line))
				break;
			line = line + " [" + df.format(new Date())+ "]\r\n";
			fileOutputStream.write(line.getBytes());
			fileOutputStream.flush();
		}
		fileOutputStream.close();
	}
}
