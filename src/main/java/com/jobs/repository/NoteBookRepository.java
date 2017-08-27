package com.jobs.repository;

import com.jobs.entity.Customer;
import com.jobs.entity.NoteBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Wan on 2017/8/27.
 */
public interface NoteBookRepository extends CrudRepository<NoteBook, Long> {
    List<NoteBook> findByName(String name);

    List<NoteBook> findById(Long id);

}
