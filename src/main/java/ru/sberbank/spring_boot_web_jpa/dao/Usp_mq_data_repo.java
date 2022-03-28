package ru.sberbank.spring_boot_web_jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.spring_boot_web_jpa.domain.usp_mq_data;
import ru.sberbank.spring_boot_web_jpa.domain.usp_mq_data_id;

import java.util.List;

@Repository
public interface Usp_mq_data_repo extends CrudRepository<usp_mq_data, usp_mq_data_id> {

    @Override
    Iterable<usp_mq_data> findAll();

    List<usp_mq_data> findAllByDateCapture(String date);

    List<usp_mq_data> findAllByHost(String host);


    }
