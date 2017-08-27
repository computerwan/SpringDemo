package com.jobs.repository;

import com.jobs.entity.NoteBook;
import com.jobs.entity.NoteType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Wan on 2017/8/27.
 */
public interface NoteTypeRepository extends CrudRepository<NoteType, Long> {
}
