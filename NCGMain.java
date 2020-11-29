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
    } // main

} // class


