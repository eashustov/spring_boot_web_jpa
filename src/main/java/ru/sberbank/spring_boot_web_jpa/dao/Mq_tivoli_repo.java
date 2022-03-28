package ru.sberbank.spring_boot_web_jpa.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.spring_boot_web_jpa.domain.mq_tivoli_data;

@Repository
public interface Mq_tivoli_repo extends CrudRepository<mq_tivoli_data, Long> {

    @Override
    Iterable<mq_tivoli_data> findAll();

    List<mq_tivoli_data> findByServerName(String ServerName);

    mq_tivoli_data findById(long id);
}
