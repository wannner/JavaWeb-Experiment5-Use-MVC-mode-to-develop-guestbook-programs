package dao;

import vo.Revert;

import java.util.List;

public interface IRevertDAO {
    public void insertRevert(Revert revert);

    public List<Revert> findAllRevertByMessageId(int id);

}
