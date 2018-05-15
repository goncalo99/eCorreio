package EmailAccount;

import Exceptions.DuplicatedMsgException;
import Exceptions.NonExistingEmailException;
import Exceptions.NonExistingSubjectException;

import java.time.LocalDate;
import java.util.*;

public class EmailAccountClass implements EmailAccount {

    private SortedMap<LocalDate, SortedMap<String, SortedSet<Msg>>> received;
    private SortedMap<LocalDate, SortedMap<String, SortedSet<Msg>>> sent;
    private Map<String, List<Msg>> byEmail;
    private Map<String, List<Msg>> bySubject;



    public EmailAccountClass() {
        received = new TreeMap<>();
        sent = new TreeMap<>();
        byEmail = new HashMap<>(200);
        bySubject = new HashMap<>();

    }

    @Override
    public void sendMsg(LocalDate date, String subject, String email, String text) throws DuplicatedMsgException {
        createMsg(date, subject, email, text, sent);
    }

    @Override
    public void receive(LocalDate date, String subject, String email, String text) throws DuplicatedMsgException {
        createMsg(date, subject, email, text, received);
    }

    @Override
    public String getSent() {
        return getSortedMapStrings(sent);
    }

    @Override
    public String getReceived() {
        return getSortedMapStrings(received);
    }

    @Override
    public String getMsgWithThatSubject(String subject) throws NonExistingSubjectException {
        if (bySubject.get(subject)== null) throw new NonExistingSubjectException();
        return getMapStrings(subject, bySubject);
    }



    @Override
    public String getMsgWithThatEmail(String email) throws NonExistingEmailException {
        if (byEmail.get(email)== null) throw new NonExistingEmailException();
        return getMapStrings(email, byEmail);
    }

    @Override
    public String getSubjects() {
        String result = "";
        for(String subject:bySubject.keySet())
            result += subject + "\n";
        return result.substring(0, result.length() - 1);
    }

    //Private Methods

    private void putMsgInSortedMap(LocalDate date, String subject, Msg msg, SortedMap<LocalDate,
            SortedMap<String, SortedSet<Msg>>> sortedMap) {
        try{
            SortedMap<String,SortedSet<Msg>> byDate = sortedMap.get(date);
            SortedSet<Msg> bySubject = byDate.get(subject);
        }catch (NullPointerException e){
            SortedMap<String,SortedSet<Msg>> byDate = new TreeMap<>();
            SortedSet<Msg> bySubject = new TreeSet<>();
            byDate.put(subject,bySubject);
            bySubject.add(msg);
            sortedMap.put(date, byDate);
        }

    }

    private void putMsgInMap(String key, Msg msg, Map<String, List<Msg>> map) {
        List<Msg> l = map.get(key);
        if (l == null) {
            l = new LinkedList<>();
            map.put(key, l);
        }
        l.add(msg);
    }

    private void createMsg(LocalDate date, String subject, String email, String text,
                           SortedMap<LocalDate, SortedMap<String, SortedSet<Msg>>> sortedMap) {
        if (byEmail.containsKey(email) && bySubject.containsKey(subject) && sortedMap.containsKey(date))
            throw new DuplicatedMsgException();

        Msg msg = new MsgClass(subject, email, text, date);

        putMsgInSortedMap(date, subject, msg, sortedMap);
        putMsgInMap(email, msg, byEmail);
        putMsgInMap(subject, msg, bySubject);
    }

    private String getSortedMapStrings(SortedMap<LocalDate, SortedMap<String, SortedSet<Msg>>> sortedMap) {
        String result = "";
        for (LocalDate date : sortedMap.keySet()) {
            for (String subject : sortedMap.get(date).keySet()) {
                Iterator<Msg> it =  sortedMap.get(date).get(subject).iterator();
                while (it.hasNext())
                    result += it.next().toStringWithoutText() + "\n";
            }
        }
        return result.substring(0,result.length() - 1);
    }

    private String getMapStrings(String key, Map<String, List<Msg>> map) {
        String result = "";
        Iterator<Msg> it =  map.get(key).iterator();
        while (it.hasNext())
            result += it.next() + "\n";
        return result.substring(0,result.length() - 1);
    }


}
