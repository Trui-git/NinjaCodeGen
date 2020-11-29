
public class Help {
    public Help() { } // Constructor

    public void PrintAllHelp() {
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
        System.out.println("-- Empty will be as same as -c");
        System.out.println("-c : creates directory in current location");
        System.out.println("-d : creates directory in your documents folder\n");
    } // PrintLocationOptions()

    public void PrintFolderOptions() {
        System.out.println("Folder:");
        System.out.println("-- Mandantory, cannot be empty!");
        System.out.println("-- Folders cannot begin with a number!");
        System.out.println("-- Contains no special symbol and space!\n");
    } // PrintFolderOptions()

    public void PrintTypeOptions() {
        System.out.println("Site/Files Options:");
        System.out.println("-- Empty will be as same as -b");
        System.out.println("-b : creates a basic site with index.html app.css app.js files.");
        System.out.println("-t : creates a site template with all files and default layout.");
    } // PrintTypeOptions()
} // Help()