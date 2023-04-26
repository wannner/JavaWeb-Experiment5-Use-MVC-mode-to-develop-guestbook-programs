package vo;

public class Revert {
    int revertID;
    int messageID;
    String content;
    String writer;
    String writerDate;

    public Revert() {
    }

    @Override
    public String toString() {
        return "Revert{" +
                "revertID=" + revertID +
                ", messageID=" + messageID +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", writerDate='" + writerDate + '\'' +
                '}';
    }

    public int getRevertID() {
        return revertID;
    }

    public void setRevertID(int revertID) {
        this.revertID = revertID;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
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
