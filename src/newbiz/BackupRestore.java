package newbiz;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author anthonydonx
 */
public class BackupRestore {

    public static boolean backup(String backupPath) {
        boolean status = false;
        String username = "root";
        String password = "";
        String database = "smartBiz";    //Database Name

        String mysqldumpPath = "C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin";
        //MYSQL DUMPPATH location is changed if u using MYSQL5.5


        String command = "/" + mysqldumpPath + "/mysqldump -u " + username + " -p" + password + " " + database + " -r " + backupPath;
        try {
            Process runtimeProcess = Runtime.getRuntime().exec(command);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("DatabaseManager.backup: Backup Successfull");
                JOptionPane.showMessageDialog(null, "DTF Successfull save file in " + backupPath);
                status = true;
            } else {
                System.out.println("DatabaseManager.backup: Backup Failure!");
                JOptionPane.showMessageDialog(null, "DTF Failure!");
            }
        } catch (IOException ioe) {
            System.out.println("Exception IO");
            JOptionPane.showMessageDialog(null, "I/O Error  " + ioe);
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            JOptionPane.showMessageDialog(null, "Error  " + e);
            e.printStackTrace();
        }
        return status;
    }

    public static boolean restore() {
        boolean status = false;
        String username = "root";
        String password = "";
        String filePath = "D:/DTF.sql";  //GIVE SAVED BAKUP FILE PATH

        String[] command = new String[]{"C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysql", "smartBiz", "-u" + username, "-p" + password, "-e", " source " + filePath};

        //Please Change C:/Program Files/MySQL/MySQL Server 5.1/bin/mysql link if u using MYSQL 5.5


        try {
            Process runtimeProcess = Runtime.getRuntime().exec(command);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("DatabaseManager.restore: Restore Successfull");
                JOptionPane.showMessageDialog(null, "DTF Uploded Successfully");
                status = true;
            } else {
                System.out.println("DatabaseManager.restore: Restore Failure!");
                JOptionPane.showMessageDialog(null, "DTF Failure!");
            }
        } catch (IOException ioe) {
            System.out.println("Exception IO");
            JOptionPane.showMessageDialog(null, "I/O Error  " + ioe);
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            JOptionPane.showMessageDialog(null, "Error  " + e);
            e.printStackTrace();
        }
        return status;
    }
}
