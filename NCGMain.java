public class NCGMain {

    public static String location = "";
    public static String directoryName = "";
    public static String projectType = "";
    
    public static void main(String[] args) {

        Validator validator = new Validator(args);
        validator.CheckArgs();
        location = validator.CheckLocation();
        projectType = validator.CheckType();
        directoryName = validator.CheckFolder();

        //////////////////////////////////////////
        // Folder(s) Creation
        FolderCreator folderCreator = new FolderCreator(location, directoryName);
        System.out.println(folderCreator.GenerateFolders());

        //////////////////////////////////////////
        // File(s) Creation // app.css app.js
        FileCreator fileCreator = new FileCreator(projectType);
        fileCreator.GenerateFiles(location, directoryName);
        System.out.println("Files Creating Prcocess Done!");

        /*
        if(projectType.equals("basic")) {
            fileCreator.ReadFile(".\\basicCodeFiles\\basic.html");
            fileCreator.CreateFile(location + directoryName + "\\index.html", "html");
            fileCreator.CreateFile(location + directoryName + "\\css\\app.css", "css");
            fileCreator.CreateFile(location + directoryName + "\\scripts\\app.js", "js");
        }
        else {
            fileCreator.ReadFile(".\\templateCodeFiles\\template.html");
            fileCreator.CreateFile(location + directoryName + "\\index.html", "html");
            fileCreator.ReadFile(".\\templateCodeFiles\\css\\app.css");
            fileCreator.CreateFile(location + directoryName + "\\css\\app.css", "css");
            fileCreator.ReadFile(".\\templateCodeFiles\\scripts/app.js");
            fileCreator.CreateFile(location + directoryName + "\\scripts\\app.js", "js");
            fileCreator.ReadFile(".\\templateCodeFiles\\scripts\\jquery.js");
            fileCreator.CreateFile(location + directoryName + "\\scripts\\jquery.js", "js");
            fileCreator.CreateAssets(".\\templateCodeFiles\\assets", location + directoryName + "\\assets\\");
        }
        */

    } // main

} // class


