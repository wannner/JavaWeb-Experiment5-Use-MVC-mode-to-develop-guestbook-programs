package vo;

public class Message {
    int messageID;
    String title;
    String content;
    String writer;
    String writerDate;

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageID=" + messageID +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", writerDate='" + writerDate + '\'' +
                '}';
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWriterDate() {
        return writerDate;
    }

    public void setWriterDate(String writerDate) {
        this.writerDate = writerDate;
    }
}
