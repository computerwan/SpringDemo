package com.jobs.repository;

import com.jobs.entity.Log;
import com.jobs.entity.LogDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Wan on 2017/8/27.
 */
public interface LogRepository extends CrudRepository<Log, Long> {
    List<Log> findByNoteBookId(Long noteBookId);
}
