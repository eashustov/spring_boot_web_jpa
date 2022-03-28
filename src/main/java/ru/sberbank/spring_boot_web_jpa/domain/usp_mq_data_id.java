package ru.sberbank.spring_boot_web_jpa.domain;

import java.io.Serializable;
import java.util.Objects;

public class usp_mq_data_id implements Serializable {
    private String host;
    private String mqName;

    public usp_mq_data_id() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof usp_mq_data_id)) return false;
        usp_mq_data_id that = (usp_mq_data_id) o;
        return Objects.equals(host, that.host) &&
                Objects.equals(mqName, that.mqName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, mqName);
    }
}

