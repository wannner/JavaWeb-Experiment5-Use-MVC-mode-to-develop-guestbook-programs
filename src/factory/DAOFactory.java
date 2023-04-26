package factory;

import dao.impl.MessageDAOimpl;
import dao.impl.PersonDAOimpl;
import dao.impl.RevertDAOimpl;

public class DAOFactory {
    public static MessageDAOimpl getMessageDAOimplInstance(){
        return new MessageDAOimpl();
    }

    public static PersonDAOimpl getPersonDAOimpInstance(){
        return new PersonDAOimpl();
    }

    public static RevertDAOimpl getRevertDAOimpInstance(){
        return new RevertDAOimpl();
    }
}
