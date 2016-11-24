package google;

public class DirectoryListing {

	public static void main(String[] args) {
		
	//	String directoryList="dir1\n dir11\n  text1.txt\n  dir111\n   image0.jpeg\n   image1.jpeg\n dir12\n  image2.jpeg\ndir2\n image3.jpeg";
		String directoryList="dir1\n dir11\n  text1.txt\n  dir111\n   image0.jpeg\n   image1.jpeg\n   dir1111\n dir12\n  image2.jpeg\ndir2\n image3.jpeg";
		System.out.println(directoryList);
		
		int totLen=0;
		String[] contents=directoryList.split("\n");
		String path="/"+contents[0];

		for(int i=1; i<contents.length; i++)
		{
			if(contents[i].replaceFirst("[^ ]+", "").length()==0)
				path="";
			
			if(contents[i].replaceFirst("[^ ]+", "").length() == contents[i-1].replaceFirst("[^ ]+", "").length())
			{
				if(contents[i-1].indexOf('.')==-1)
					path = path.substring(0, path.lastIndexOf("/")); 								
			}
			else if(contents[i].replaceFirst("[^ ]+", "").length() < contents[i-1].replaceFirst("[^ ]+", "").length())
			{
				String oldPath=path;
				for(int j=1; j<= oldPath.replaceAll("[^/]+", "").length()-contents[i].replaceFirst("[^ ]+", "").length(); j++)
				{
					if(path!="" && path.lastIndexOf("/")!=-1)
						path = path.substring(0, path.lastIndexOf("/"));
				}				
			}
			
			if(contents[i].indexOf('.')!=-1)
			{
				if(contents[i].endsWith(".png") || contents[i].endsWith(".jpeg") || contents[i].endsWith(".gif"))
				{
					totLen = totLen + path.length() + 1 + contents[i].trim().length();
					continue;
				}
			}
			else
			{
				path = path+"/"+contents[i].trim();
			}	
			
		}
		
		System.out.println("Total length is : " + totLen);


	}

}
