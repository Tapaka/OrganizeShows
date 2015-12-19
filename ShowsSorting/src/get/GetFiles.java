package get;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class GetFiles {
		File folder = new File("E:\\OwnCloud");
		File showFolder;
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> sShowsList = new ArrayList<String>();
	public void ShowsList(){
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].toString().matches("(.*)VOSTFR(.*)")) {
				sShowsList.add(listOfFiles[i].toString().replace(".", ""));
			} else if (listOfFiles[i].isDirectory() && listOfFiles[i].toString().matches("(.*)VOSTFR(.*)")) {
				showFolder = new File("E:\\OwnCloud\\"+listOfFiles[i].getName()+"");
				File[] listOfFileInFolder = showFolder.listFiles();
				for (File file : listOfFileInFolder ){
					if (file.toString().matches("(.*)VOSTFR(.*)")){
						try {
							if(Files.probeContentType(file.toPath()).matches("video(.*)")){
								System.out.println("video :"+file.getName());
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
	}
}
