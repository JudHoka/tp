import MainFunction.ManagementSystem;
import Misc.Parser;
import Misc.Ui;

public class ClinicEase {
    public static void main(String[] args) {
        ManagementSystem manager = new ManagementSystem();
        Ui ui = new Ui();
        ui.showWelcome();

        boolean running = true;
        while (running) {
            String input = ui.readCommand();

            if (Parser.isBye(input)) {
                ui.showBye();
                running = false;
            } else if (Parser.isAddAppointment(input)) {
                String[] details = Parser.parseAddAppointment(input);
                if (details == null) {
                    System.out.println("Invalid format. Use: add-appointment ic/NRIC dt/DATE t/TIME dsc/DESCRIPTION");
                } else {
                    manager.addAppointment(details);
                }
            } else if (Parser.isDeleteAppointment(input)) {
                String apptId = Parser.parseDeleteAppointment(input);
                if (apptId == null) {
                    System.out.println("Invalid format. Use: delete-appointment APPOINTMENT_ID");
                } else {
                    manager.deleteAppointment(apptId);
                }
            } else if (Parser.isListAppointments(input)) {
                manager.listAppointments();
            } else if (Parser.isAddPatient(input)) {
                manager.addPatient(input);
            } else if (Parser.isDeletePatient(input)) {
                manager.deletePatient(input);
            } else if (Parser.isListPatient(input)){
                manager.listPatients();
            } else if (Parser.isViewPatient(input)) {
                System.out.println("Feature not implemented yet.");
            } else if (Parser.isViewHistory(input)) {
                System.out.println("Feature not implemented yet.");
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
}
