import javax.swing.filechooser.FileSystemView;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private StringBuilder commandText = new StringBuilder();
    private String[] args;
    private Help help = new Help();

    public Validator(String[] args) {
        this.args = args;
    }

    public void CheckArgs() {

        if (args.length == 0) {
            System.out.println("\nNo option found!");
            help.PrintAllHelp();
            System.exit(0);
        }

        if (args[0].toUpperCase().equals("HELP")) {
            help.PrintAllHelp();
            System.exit(0);
        }

        // foldername -b
        if(args[0].length() != 2 && args[0].charAt(0) == '-') {
            System.out.println("\nDirectory option wrong!");
            help.PrintAllHelp();
            System.exit(0);
        }
        else if (args.length <= 3 && args.length > 0) {
            if ((args.length == 3) && !args[2].contains("-") || (args.length == 3) && args[2].length() != 2){
                System.out.println("\nSite/File option wrong!\n");
                help.PrintTypeOptions();
                System.exit(0);
            }
            for (String arg : args) {
                this.commandText.append(arg);
            }
        }
        else {
            System.out.println("\nMore than 3 options found!");
            help.PrintAllHelp();
            System.exit(0);
        }
    }
    
    public String CheckLocation() {
        String location = "";
        int dashPos = commandText.indexOf("-");

        if(dashPos < 0) {
            location = "";
        }
        else if(dashPos == 0) {
            location += this.commandText.charAt(0);
            location += this.commandText.charAt(1);
            commandText.delete(dashPos, 2);
        }
        else {
            location = "";
        }

        switch(location) {
            case "":
            case "-c": { // uses current location
                location = ".\\";
                break;
            }
            case "-d": { // documents folder
                //location = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + "\\";
                // 200ms less time consumming with FileSystemView than JFileChooser
                location = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\";
                // System.out.println("from -d");
                break;
            }
            default: { // oops
                System.out.println("\nUndefined directory options!");
                help.PrintLocationOptions();
                System.exit(0);
            }
        } // switch

        return location;
    } // CheckLocation()

    public String CheckType() {
        String projectType = "";
        int dashPos = commandText.lastIndexOf("-");
        
        if(dashPos < 0) {
            projectType = "";
        }
        else if(dashPos > 0) {
            // check lenght of dashPos to last position
            if( commandText.substring(dashPos, commandText.length()-1).length() + 1 == 2 ) {
                projectType = commandText.substring(dashPos, dashPos + 2);
                commandText.delete(dashPos, commandText.length());
            }
            else {
                Help help = new Help();
                System.out.println("\nWrong File Type!\n");
                help.PrintTypeOptions();
                System.exit(0);
            }
        }
        else {
            projectType += commandText.charAt(commandText.length() - 2);
            projectType += commandText.charAt(commandText.length() - 1);
            commandText.delete(dashPos, commandText.length());
        }

        switch(projectType) {
            case "":
            case "-b": { // basic folder and files - no design
                projectType = "basic";
                System.out.println("A basic site will be created...");
                break;
            }
            case "-t": { // complete template w design etc...
                projectType = "template";
                System.out.println("A site with templates will be created...");
                break;
            }
            default: { // oops
                Help help = new Help();
                System.out.println("\nWrong File Type!\n");
                help.PrintTypeOptions();
                System.exit(0);
            }
        } // switch

        return projectType;
    } // CheckType()

    public String CheckFolder() {
        String directoryName = "";
        String folderName = this.commandText.toString();
        Help help = new Help();
        
        if (folderName.isBlank()) {
            System.out.println("\nFolder not found!\n");
            help.PrintFolderOptions();
            System.exit(0);
        }

        // check char[0] not a num
        char firstChar = folderName.charAt(0);
        if(Character.isDigit(firstChar)) {
            System.out.println("\nWrong Folder Name!\n");
            help.PrintFolderOptions();
            System.exit(0);
        }

        // check for alphanumeric
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(folderName);
    
        if (matcher.matches()) {
            directoryName = folderName;
        } else {
            System.out.println("\nWrong Folder Name!\n");
            help.PrintFolderOptions();
            System.exit(0);
        }

        return directoryName;
    } // CheckFolder()

} // Validator()