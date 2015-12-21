package duplicate;

import java.io.File;
import java.util.ArrayList;

public class FindTheFuckers {
	File folder = new File("C:\\Program Files (x86)\\UltraStar Deluxe\\test");
	File[] listOfFiles = folder.listFiles();
	String sCurrentFolder;
	String sLookingFolder;
	public String sSplittedArtist;
	String sSong;
	int iIndex;
	int iDash;
	ArrayList<String> alArtistFound = new ArrayList<String>();

	public void FindThemAll(){
		for (int i = 0; i < 1; i++) {
			System.out.println(listOfFiles[i].toString());
			sCurrentFolder = listOfFiles[i].toString();
			iIndex = sCurrentFolder.indexOf(" -");
			iDash = sCurrentFolder.lastIndexOf("\\");
			//System.out.println(iIndex);
			//System.out.println(iDash);
			if(iIndex != -1){
				sSplittedArtist = sCurrentFolder.substring(iDash+1, iIndex);
				System.out.println(sSplittedArtist);
			}
			for (int j = 0; j < listOfFiles.length; j++){
				if(listOfFiles[j].toString().matches("(.*)"+sSplittedArtist+"(.*)|(.*)"+sSplittedArtist.toLowerCase()+"(.*)|(.*)"+sSplittedArtist.substring(0, 1).toUpperCase() + sSplittedArtist.substring(1).toLowerCase()+"(.*)")){
					//System.out.println(sSplittedArtist);
					alArtistFound.add(sSplittedArtist);
					sLookingFolder = listOfFiles[j].toString();
					System.out.println("Match Found"); 
					System.out.println(listOfFiles[j].toString());
					sSong = sLookingFolder.substring(iIndex+3);
					System.out.println(sSong);
				}
			}
		}
	}
}