package EmailAccount;

import Exceptions.*;

import java.time.LocalDate;

public interface EmailAccount {

    void sendMsg(LocalDate date, String subject, String email, String text) throws DuplicatedMsgException;

    void receive(LocalDate date, String subject, String email, String text) throws DuplicatedMsgException;

    String getSent();

    String getReceived();

    String getMsgWithThatSubject(String subject) throws NonExistingSubjectException;

    String getMsgWithThatEmail(String email) throws NonExistingEmailException;

    String getSubjects();
}
