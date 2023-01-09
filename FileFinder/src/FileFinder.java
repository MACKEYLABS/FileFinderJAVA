import java.io.File;

public class FileFinder {
	
	    public static String printDirectoryTree(File folder) {
	        if (!folder.isDirectory()) {
	            throw new IllegalArgumentException("folder is not a Directory");
	        }
	        StringBuilder sb = new StringBuilder();
	        printDirectoryTree(folder, sb, 0);
	        return sb.toString();
	    }
	   
	  private static void printDirectoryTree(File file, StringBuilder sb, int indent) {
    if (file.isDirectory()) {
        File[] files = file.listFiles();
        int numFiles = files.length;
        sb.append(getIndentString(indent)).append("+---").append(file.getName())
        .append("/ [" + numFiles + " files]" + " ["+ file.length() + " bytes]" + "\n");
        
        for (File child : files) {
            printDirectoryTree(child, sb, indent + 1);
        }
    } else {
        sb.append(getIndentString(indent)).append("+---").append(file.getName()).append(" [" + file.length() + " bytes]\n");
    }
}
  

	
	    private static String getIndentString(int indent) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < indent; i++) {
	            sb.append("|  ");
	        }
	        return sb.toString();
	    }

	    public static void main(String[] args) {
	        File currentDir = new File(System.getProperty("user.dir"));
	        String directoryTree = printDirectoryTree(currentDir);
	        System.out.println(directoryTree);
	    }
	}
