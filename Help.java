
public class Help {
    public Help() { } // Constructor

    public void PrintAllHelp() {
        System.out.print("\nNinjaCodeGen Version 3\n");
        PrintGeneralWaring();
        PrintLocationOptions();
        PrintFolderOptions();
        PrintTypeOptions();
    }
    public void PrintGeneralWaring() {
        System.out.print("\nUsage: ");
        System.out.print("NinjaCodeGen [Help], ");
        System.out.println("NinjaCodeGen [Directory Option] Folder [Site/Files Option]\n");
    } // PrintGeneralWaring()

    public void PrintLocationOptions() {
        System.out.println("Directory Options:");
        System.out.println("-c : creates directory in current location");
        System.out.println("-d : creates directory in your documents folder");
        System.out.println("-- Empty directory will be as same as option -c\n");
    } // PrintLocationOptions()

    public void PrintFolderOptions() {
        System.out.println("Folder:");
        System.out.println("-- Mandantory, cannot be empty!");
        System.out.println("-- Folders cannot begin with a number!");
        System.out.println("-- Contains no special symbol and space!\n");
    } // PrintFolderOptions()

    public void PrintTypeOptions() {
        System.out.println("Site/Files Options:");
        System.out.println("-b : creates a basic site with index.html app.css app.js files.");
        System.out.println("-t : creates a site template with all files and default layout.");
        System.out.println("-- Empty Site/Files will be as same as option -b\n");
    } // PrintTypeOptions()
} // Help()