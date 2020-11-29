This is a simple HTML code generator can be executed with windows command line:

Usage:
NinjaCodeGen [Help] or
NinjaCodeGen [Directory Option] Folder [Site/Files Option]

Directory Options:
-c : creates directory in current location
-d : creates directory in your documents folder
Empty will be as same as -c

Folder:
-- Mandantory, cannot be empty!
-- Folders cannot begin with a number!
-- Contains no special symbol and space!

Site/Files Options:
-b : creates a basic site with index.html app.css app.js files.
-t : creates a site template with all files and default layout.
Empty will be as same as -b

Compilation command: javac NCGMain.java
Sample run command:  java NCGMain -c sample -b
Sample release run command: NinjaCodeGen -c sample -b

release location
https://github.com/Trui-git/NinjaCodeGen/releases/tag/NinjaCodeGen