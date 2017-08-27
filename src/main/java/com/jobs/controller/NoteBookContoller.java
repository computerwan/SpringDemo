package com.jobs.controller;

import com.jobs.entity.Log;
import com.jobs.entity.LogDetail;
import com.jobs.entity.NoteBook;
import com.jobs.entity.NoteType;
import com.jobs.repository.LogDetailRepository;
import com.jobs.repository.LogRepository;
import com.jobs.repository.NoteBookRepository;
import com.jobs.repository.NoteTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Wan on 2017/8/27.
 */

@Controller
public class NoteBookContoller {

    @Autowired
    NoteBookRepository noteBookRepository;

    @Autowired
    NoteTypeRepository noteTypeRepository;

    @Autowired
    LogDetailRepository logDetailRepository;

    @Autowired
    LogRepository logRepository;


    @RequestMapping("/showAll")
    public String showAll(Model model) {
        /**
         * 目前显示10个
         */
        List<NoteBook> resList = new ArrayList<NoteBook>();
        AtomicLong count = new AtomicLong(0);
        Iterator<NoteBook> it = noteBookRepository.findAll().iterator();
        while (it.hasNext()) {
            resList.add(it.next());
            count.getAndIncrement();
            if (count.get() == 10) {
                break;
            }
        }
        model.addAttribute("notebook", resList);
        return "notebook";
    }


    @RequestMapping("/showSchema")
    public String showSchema(@RequestParam(value = "id", required = true) Long id, Model model) {
        NoteBook noteBook = noteBookRepository.findById(id).get(0);
        List<String> resList = new ArrayList<String>();

        /**
         * 载入type的映射关系（不包含目录）
         */
        Map<Long, String> map = new HashMap();
        Iterator<NoteType> it = noteTypeRepository.findAll().iterator();
        while (it.hasNext()) {
            NoteType next = it.next();
            if (!next.getDir()) {
                map.put(next.getId(), next.getType());
            }
        }
        System.out.println(map.toString());
        /**
         * 获取需要展示的字段信息
         */
        String type = noteBook.getType();
        char[] chars = type.toCharArray();
        for (char c : chars) {
            String s = map.get(Long.parseLong(c + ""));
            resList.add(s);
        }
        model.addAttribute("schema", resList);
        return "notebook";
    }

    @RequestMapping("/showDetail")
    public String showDetail(@RequestParam(value = "id", required = true) Long id, Model model) {
        /**
         * 载入type的映射关系
         */
        Map<Long, String> map = new HashMap();
        Iterator<NoteType> it = noteTypeRepository.findAll().iterator();
        while (it.hasNext()) {
            NoteType next = it.next();
            map.put(next.getId(), next.getType());
        }
        System.out.println(map.toString());

        /**
         * 获取该notebook下所有记录
         * （可以增加时间或者公共字段）
         */
        List<Log> logs = logRepository.findByNoteBookId(id);
        List<Long> logIds = new ArrayList<>();
        for (Log log : logs) {
            logIds.add(log.getId());
        }
        System.out.println(logIds.toString());
        /**
         * 根据Log表中匹配到的信息查询详细信息
         */
        Iterable<LogDetail> logDetails = logDetailRepository.findByLogIdIn(logIds);
        Map<Long, Map<String, String>> resMap = new HashMap<>();
        for (LogDetail logDetail : logDetails) {
            System.out.println(logDetail.toString());
            Long logId = logDetail.getLogId();
            Long typeId = logDetail.getTypeId();
            String value = logDetail.getValue();
            String type = map.get(typeId);
            if (resMap.containsKey(logId)) {
                Map<String, String> tmp = resMap.get(logId);
                tmp.put(type, value);
                resMap.put(logId, tmp);
            } else {
                Map<String, String> tmp = new HashMap<>();
                tmp.put(type, value);
                resMap.put(logId, tmp);
            }
        }
        model.addAttribute("detail", resMap);
        return "notebook";
    }


}
