package social_network;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class FileExporter {
    UserList userList = UserList.getInstance();
    RelationshipList relationshipList = RelationshipList.getInstance();

    /**
     * This method exports the user list to a file.
     * It prompts the user to enter the file name and extension, and then writes the user list to the file.
     */
    public void exportPeople() {
        // Create a file selector dialog
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.showSaveDialog(null);
        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

        // Convert file path
        System.out.println("Selected file path: " + filePath);
        try{
            File outputFile = new File( filePath );
            PrintWriter pw = new PrintWriter(outputFile);
            for (Profile profile : userList.getUserList()) {
                if (profile != null) {
                    pw.println(profile.toString());
                }
            }
            pw.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method exports the relationship list to a file.
     * It prompts the user to enter the file name and extension, and then writes the relationship list to the file.
     */
    public void exportRelationships() {
        // Create a file selector dialog
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.showSaveDialog(null);
        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

        // Convert file path
        System.out.println("Selected file path: " + filePath);
        try{
            File outputFile = new File( filePath );
            PrintWriter pw = new PrintWriter(outputFile);
            for (Relationship relationship : relationshipList.getRelationshipList()) {
                if (relationship != null) {
                    pw.println(relationship.toString());
                }
            }
            pw.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
