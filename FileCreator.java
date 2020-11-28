
import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;



public class FileCreator {
    private ArrayList<String> fc = new ArrayList<String>();
    private String projectType;
    private String fileBuff = "";
    
    public FileCreator(String projectType) {
        this.projectType = projectType;
    } // constructor

    public void ReadFile(String fileDetails) {
        fileBuff = fileDetails;
        try {
            File file = new File(fileDetails);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fc.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(fileDetails + ": file not found!");
            //e.printStackTrace();
            //System.exit(0);
        }
    } // ReadFile()
    
    public void CreateFile(String fileDetails, String fileType) {
        try {
            // this three line code throw exceptions 
            // if no file found in source dir 
            File srcFile = new File(fileBuff);
            Scanner myReader = new Scanner(srcFile);
            myReader.close();

            File file = new File(fileDetails);
            if (file.createNewFile()) {
                CopyFileContents(file);
                System.out.println("Created: " + fileDetails);
            } 
            else {
                System.out.println("Skipped: " + fileDetails + " already exists!");
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Skipped: " + fileDetails + ": not created!");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    } // CreateFile() 

    private void CopyFileContents(File file) throws IOException {
        try (FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw)) {
            bw.newLine();
            for(int i = 0; i < fc.size(); i++) {
                bw.write(fc.get(i));
                bw.newLine();   // add new line, System.lineSeparator()
            }
        }
        fc.clear();
    } // CopyFileContents()

    public void CreateAssets (String src, String dest){
        File srcDir = new File(src);
        File destDir = new File(dest);
        CopyFolder(srcDir, destDir);
    } // CreateAssets

    // copy assets files recursivlly
    private void CopyFolder(File source, File destination)
    {
        if (source.isDirectory())
        {
            if (!destination.exists())
            {
                destination.mkdirs();
            }
    
            String files[] = source.list();
    
            for (String file : files)
            {
                File srcFile = new File(source, file);
                File destFile = new File(destination, file);

                if (destFile.exists() && destFile.isFile())
                    System.out.println("Skipped: " + destFile + " already exists!");
                else if (!destFile.exists()){
                    System.out.println("Copied: " + destFile);
                }
                CopyFolder(srcFile, destFile); 
            }
        }
        else
        {
            InputStream in = null;
            OutputStream out = null;
    
            try
            {
                in = new FileInputStream(source);
                out = new FileOutputStream(destination);
    
                byte[] buffer = new byte[1024];
    
                int length;
                while ((length = in.read(buffer)) > 0)
                {
                    out.write(buffer, 0, length);
                }
            }
            catch (Exception e)
            {
                try
                {
                    in.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
    
                try
                {
                    out.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    } // CopyFolder

    public String GenerateFiles(String location, String directoryName) {

        if(projectType.equals("basic")) {
            ReadFile(".\\basicCodeFiles\\basic.html");
            CreateFile(location + directoryName + "\\index.html", "html");
            CreateFile(location + directoryName + "\\css\\app.css", "css");
            CreateFile(location + directoryName + "\\scripts\\app.js", "js");
        }
        else {
            ReadFile(".\\templateCodeFiles\\template.html");
            CreateFile(location + directoryName + "\\index.html", "html");
            ReadFile(".\\templateCodeFiles\\css\\app.css");
            CreateFile(location + directoryName + "\\css\\app.css", "css");
            ReadFile(".\\templateCodeFiles\\scripts/app.js");
            CreateFile(location + directoryName + "\\scripts\\app.js", "js");
            ReadFile(".\\templateCodeFiles\\scripts\\jquery.js");
            CreateFile(location + directoryName + "\\scripts\\jquery.js", "js");
            CreateAssets(".\\templateCodeFiles\\assets", location + directoryName + "\\assets\\");
        }


        return "";
    }

} // class