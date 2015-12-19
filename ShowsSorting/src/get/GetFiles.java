package get;

import java.io.File;

public class GetFiles {
		File folder = new File("E:\\OwnCloud");
		File[] listOfFiles = folder.listFiles();
	public GetFiles(){
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].toString().matches("(.*)VOSTFR(.*)")) {
				System.out.println("File " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory() && listOfFiles[i].toString().matches("(.*)VOSTFR(.*)")) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
	}
}
