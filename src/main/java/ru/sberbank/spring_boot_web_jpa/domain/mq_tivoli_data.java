package ru.sberbank.spring_boot_web_jpa.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class mq_tivoli_data {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String serverName;
    private String mqName;
    private String tivoliInstall;

    public mq_tivoli_data(String serverName, String mqName, String tivoliInstall) {
        this.serverName = serverName;
        this.mqName = mqName;
        this.tivoliInstall = tivoliInstall;
    }

    public mq_tivoli_data() {
    }

    public Long getId() {
        return id;
    }

    public String getServerName() {
        return serverName;
    }

    public String getMqName() {
        return mqName;
    }

    public String getTivoliInstall() {
        return tivoliInstall;
    }


}
