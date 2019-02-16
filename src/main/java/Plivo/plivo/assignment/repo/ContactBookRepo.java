package Plivo.plivo.assignment.repo;

import Plivo.plivo.assignment.entity.ContactBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactBookRepo extends JpaRepository<ContactBook,Integer> {

    @Modifying
    @Query(value = "update volunteer set isProcessed=true where id=?1", nativeQuery = true)
    void updateContactBook(long id);

    @Query(value="Select * from contact_book where id=?1", nativeQuery = true)
    public ContactBook findContactBookById(int contactBookId);

    @Query(value="Select * from contact_book where name=?1", nativeQuery = true)
    public List<ContactBook> findContactBookByName(String contactBookName);

    @Query(value="Select * from contact_book where email_address=?1", nativeQuery = true)
    public ContactBook findContactBookByEmail(String contactBookEmail);

}
