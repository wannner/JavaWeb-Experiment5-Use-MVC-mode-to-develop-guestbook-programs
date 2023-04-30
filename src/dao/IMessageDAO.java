package dao;

import vo.Message;

import java.util.List;

public interface IMessageDAO {
    public List<Message> showAllMessage();

    public void deleteMessage(int id);

    public Message getMessageById(int id);

    public void insertNewMessage(Message message);
}
