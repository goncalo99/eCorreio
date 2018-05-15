import EmailAccount.EmailAccount;
import EmailAccount.EmailAccountClass;
import Enums.*;
import Exceptions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author Goncalo Areia (52714) && Diogo Cebola (52718)
 */
public class Main {

    private static final String Success_Msg = "Mensagem registada.";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        EmailAccount account = new EmailAccountClass();
        Commands command = getCommand(in);

        while (!command.equals(Commands.SAIR)) {
            switch (command) {
                case ENVIAR:
                    System.out.println(send(in, account));
                    break;
                case RECEBER:
                    System.out.println(receive(in, account));
                    break;
                case ENVIADAS:
                    System.out.println(sent(account));
                    break;
                case RECEBIDAS:
                    System.out.println(received(account));
                    break;
                case ASSUNTO:
                    System.out.println(bySubject(in, account));
                    break;
                case EMAIL:
                    System.out.println(byEmail(in, account));
                    break;
                case ASSUNTOS:
                    System.out.println(subjects(account));
                    break;
                case UNKNOWN:
                    System.out.println(Sistema.INPUT_MISMATCH);
                    break;

            }
            System.out.println();
            command = getCommand(in);

        }
        closeProgram(in);

    }

    /**
     * @param in the Scanner
     * @return the command to be executed.
     */
    private static Commands getCommand(Scanner in) {
        try {
            return Commands.valueOf(in.next().toUpperCase().trim());

        } catch (IllegalArgumentException e) {
            return Commands.UNKNOWN;

        }
    }

    /**
     * Closes the application.
     */
    private static void closeProgram(Scanner in) {
        System.out.println(Sistema.QUIT + "\n");
        in.close();
    }

    private static String send(Scanner in, EmailAccount account) {
        String subject = in.nextLine();
        String email = in.nextLine();

        String text = null;
        while(!in.hasNextInt())
            text = text + in.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime date = LocalDateTime.parse(in.nextLine(),formatter);
        try{
            account.sendMsg(date, subject, email, text);
            return Success_Msg;
        }
        catch (DuplicatedMsgException e){
            return e.getErrorMsg();
        }
    }

    private static String receive(Scanner in, EmailAccount account) {
        String subject = in.nextLine();
        String email = in.nextLine();

        String text = null;
        while(!in.hasNextInt())
            text = text + in.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime date = LocalDateTime.parse(in.nextLine(),formatter);
        try{
            account.receive(date, subject, email, text);
            return Success_Msg;
        }
        catch (DuplicatedMsgException e){
            return e.getErrorMsg();
        }

    }

    private static String sent(EmailAccount account) {
        return account.getSent();
    }

    private static String received(EmailAccount account) {
        return account.getReceived();
    }

    private static String bySubject(Scanner in, EmailAccount account) {
        String subject = in.nextLine();
        try{
            System.out.println(bySubject_Format);
            return account.getMsgWithThatSubject(subject);
        }
        catch(NonExistingSubjectException e){
            return e.getErrorMsg();
        }
    }

    private static String byEmail(Scanner in, EmailAccount account) {
        String email = in.nextLine();
        try{
            System.out.println(byEmail_Format);
            return account.getMsgWithThatEmail(email);
        }
        catch(NonExistingEmailException e){
            return e.getErrorMsg();
        }
    }

    private static String subjects(EmailAccount account) {
        return account.getSubjects();
    }
}

